package com.example.dinostudy.view.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dinostudy.databinding.FragmentWatchBinding;
import com.example.dinostudy.databinding.FragmentWatchPlusSubjectBinding;
import com.example.dinostudy.view.adapter.WatchAdapter;
import com.example.dinostudy.view.item.SubjectItem;

import java.util.ArrayList;

public class WatchFragment extends Fragment {

    private FragmentWatchBinding binding;
    private FragmentWatchPlusSubjectBinding binding_plus_subject;

    private ArrayList<SubjectItem> arrayList;
    private WatchAdapter stopwatchAdapter;
//    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    //private Chronometer chronometer;
    private Thread timeThread = null;
    private Boolean isRunning = false;

    private long mSecTime = 0L;     //시작 누르고 흐른 시간
    private long startTime = 0L;    //시작 누른 시간
    private long timeBuff = 0L;     //일시정지 눌렀을 때 측정된 총 시간
    private long updateTime = 0L;   //총 시간 = 일시정지 눌렀을 때 총 시간 + 시작 누르고 난 이후 부터 시간

    Handler handler;

    int sec, min, hour;

    public WatchFragment(){

    }

    Context ct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWatchBinding.inflate(inflater, container, false);

        ct = container.getContext();

        linearLayoutManager = new LinearLayoutManager(ct);
        binding.rvStopwatch.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        stopwatchAdapter = new WatchAdapter(arrayList);
        binding.rvStopwatch.setAdapter(stopwatchAdapter);

        handler = new Handler();

        int code = getArguments().getInt("code"); // 200 데이터 존재, 204 데이터 없음
        String username = getArguments().getString("username");

        if (code == 204) {

        }

        binding.btnPlusSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Data_Subject dataSubject = new Data_Subject("토익","00:00:00");
                arrayList.add(dataSubject);
                stopwatchAdapter.notifyDataSetChanged();
                */
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                binding_plus_subject = FragmentWatchPlusSubjectBinding.inflate(inflater, container, false);
                builder.setView(binding_plus_subject.getRoot());

                //btn_subject_name.setText("삽입");
                final AlertDialog dialog = builder.create();

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                binding_plus_subject.btnSubjectInsert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //사용자 입력 내용
                        String strSubject = binding_plus_subject.etSubject.getText().toString();
                        String subjectTime = "00:00:00";

                        //ArrayList에 추가
                        SubjectItem dataSubject = new SubjectItem(strSubject, subjectTime);
                        arrayList.add(dataSubject); //마지막 줄에 추가. 첫번째 줄은 (0, dataSubject)
                        stopwatchAdapter.notifyDataSetChanged(); //새로고침

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        //시작
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                //SystemClock.iptimeMillis()는 디바이스 부팅 후 부터 쉰 시간 '제외'한 밀리초 반환

                handler.postDelayed(runnable, 0);

                binding.btnReset.setEnabled(false);
                //시작하면 리셋버튼 비활성화
            }
        });

        //일시정지
        binding.btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeBuff += mSecTime;
                //일시정지 눌렀을 때의 총 시간

                handler.removeCallbacks(runnable);
                //Runnable 객체 제거

                binding.btnReset.setEnabled(true);
                //일시정지 누르면 초기화 버튼 활성화
            }
        });

        //초기화
        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSecTime = 0L;
                startTime = 0L;
                timeBuff = 0L;
                updateTime = 0L;
                sec = 00;
                min = 00;
                hour = 00;
                //측정 시간 모두 리셋

                binding.studyTime.setText("00:00:00");
            }
        });

        return binding.getRoot();
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mSecTime = SystemClock.uptimeMillis() - startTime;
            //디바이스 부팅 후부터 현재까지 시간 - 시작 버튼 누른 시간

            updateTime = timeBuff + mSecTime;
            //일시정지 눌렀을 때의 총 시간 + 시작 버튼 누르고 난 이후 부터의 시간(이어서 재기)

            sec = (int) (updateTime / 1000);
            min = sec / 60;
            sec = sec % 60;
            hour = min / 60;

            binding.studyTime.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", min) + ":"
                    + String.format("%02d", sec));

            handler.postDelayed(this, 0);
        }
    };

}
