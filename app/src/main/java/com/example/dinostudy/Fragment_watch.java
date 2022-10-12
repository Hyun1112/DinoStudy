package com.example.dinostudy;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;

public class Fragment_watch extends Fragment {

    private ArrayList<Data_Subject> arrayList;
    private StopwatchAdapter stopwatchAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    //private Chronometer chronometer;
    private TextView study_time;
    private Thread timeThread = null;
    private Boolean isRunning = false;

    private long mSecTime = 0L;     //시작 누르고 흐른 시간
    private long startTime = 0L;    //시작 누른 시간
    private long timeBuff = 0L;     //일시정지 눌렀을 때 측정된 총 시간
    private long updateTime = 0L;   //총 시간 = 일시정지 눌렀을 때 총 시간 + 시작 누르고 난 이후 부터 시간

    Handler handler;

    int sec, min, hour;

    public Fragment_watch(){

    }

    Context ct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_watch, container, false);

        ct = container.getContext();

        recyclerView = (RecyclerView)v.findViewById(R.id.rv_stopwatch);
        linearLayoutManager = new LinearLayoutManager(ct);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        stopwatchAdapter = new StopwatchAdapter(arrayList);
        recyclerView.setAdapter(stopwatchAdapter);

        ImageButton btn_plus_subject = (ImageButton)v.findViewById(R.id.btn_plus_subject);
        Button btn_start = (Button)v.findViewById(R.id.btn_start);
        Button btn_pause = (Button)v.findViewById(R.id.btn_pause);
        Button btn_reset = (Button)v.findViewById(R.id.btn_reset);
        study_time = (TextView)v.findViewById(R.id.study_time);

        handler = new Handler();

        btn_plus_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Data_Subject dataSubject = new Data_Subject("토익","00:00:00");
                arrayList.add(dataSubject);
                stopwatchAdapter.notifyDataSetChanged();
                */
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                View view1 = LayoutInflater.from(ct).inflate(R.layout.plus_subject, null, false);
                builder.setView(view1);

                final EditText et_subject = (EditText)view1.findViewById(R.id.et_subject);
                final Button btn_subject_name = (Button)view1.findViewById(R.id.btn_subject_name);

                //btn_subject_name.setText("삽입");
                final AlertDialog dialog = builder.create();

                btn_subject_name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //사용자 입력 내용
                        String strSubject = et_subject.getText().toString();
                        String subjectTime = "00:00:00";

                        //ArrayList에 추가
                        Data_Subject dataSubject = new Data_Subject(strSubject, subjectTime);
                        arrayList.add(0, dataSubject); //첫번째 줄
                        stopwatchAdapter.notifyDataSetChanged(); //새로고침

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        //시작
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                //SystemClock.iptimeMillis()는 디바이스 부팅 후 부터 쉰 시간 '제외'한 밀리초 반환

                handler.postDelayed(runnable, 0);

                btn_reset.setEnabled(false);
                //시작하면 리셋버튼 비활성화
            }
        });

        //일시정지
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeBuff += mSecTime;
                //일시정지 눌렀을 때의 총 시간

                handler.removeCallbacks(runnable);
                //Runnable 객체 제거

                btn_reset.setEnabled(true);
                //일시정지 누르면 초기화 버튼 활성화
            }
        });

        //초기화
        btn_reset.setOnClickListener(new View.OnClickListener() {
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

                study_time.setText("00:00:00");
            }
        });

        return v;
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

            study_time.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", min) + ":"
                    + String.format("%02d", sec));

            handler.postDelayed(this, 0);
        }
    };

}
