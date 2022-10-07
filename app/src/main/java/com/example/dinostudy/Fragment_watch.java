package com.example.dinostudy;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;

public class Fragment_watch extends Fragment implements View.OnClickListener {

    private ArrayList<Data_Subject> arrayList;
    private StopwatchAdapter stopwatchAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Chronometer chronometer;

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
        chronometer = (Chronometer)v.findViewById(R.id.chronometer);

        btn_start.setOnClickListener(this);
        btn_pause.setOnClickListener(this);

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

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                break;
            case R.id.btn_pause:
                chronometer.stop();
                break;
        }
    }
}
