package com.example.dinostudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_todo, btn_chart, btn_watch, btn_commu, btn_diary, btn_heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_todo = (ImageButton)findViewById(R.id.btn_chk);
        btn_chart = (ImageButton)findViewById(R.id.btn_chart);
        btn_watch = (ImageButton)findViewById(R.id.btn_watch);
        btn_commu = (ImageButton)findViewById(R.id.btn_commu);
        btn_diary = (ImageButton)findViewById(R.id.btn_diary);
        btn_heart = (ImageButton)findViewById(R.id.btn_heart);

        btn_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_todo fragment_todo = new Fragment_todo();
                transaction.replace(R.id.frame,fragment_todo);
                transaction.commit();

                btn_todo.setImageResource(R.drawable.checkbox_y);
                btn_chart.setImageResource(R.drawable.chart_n);
                btn_watch.setImageResource(R.drawable.watch_n);
                btn_commu.setImageResource(R.drawable.bubble_n);
                btn_diary.setImageResource(R.drawable.diary_n);
                btn_heart.setImageResource(R.drawable.heart_n);
            }
        });

        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_chart fragment_chart = new Fragment_chart();
                transaction.replace(R.id.frame,fragment_chart);
                transaction.commit();

                btn_todo.setImageResource(R.drawable.checkbox_n);
                btn_chart.setImageResource(R.drawable.chart_y);
                btn_watch.setImageResource(R.drawable.watch_n);
                btn_commu.setImageResource(R.drawable.bubble_n);
                btn_diary.setImageResource(R.drawable.diary_n);
                btn_heart.setImageResource(R.drawable.heart_n);
            }
        });

        btn_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_watch fragment_watch = new Fragment_watch();
                transaction.replace(R.id.frame,fragment_watch);
                transaction.commit();

                btn_todo.setImageResource(R.drawable.checkbox_n);
                btn_chart.setImageResource(R.drawable.chart_n);
                btn_watch.setImageResource(R.drawable.watch_y);
                btn_commu.setImageResource(R.drawable.bubble_n);
                btn_diary.setImageResource(R.drawable.diary_n);
                btn_heart.setImageResource(R.drawable.heart_n);
            }
        });

        btn_commu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_community fragment_community = new Fragment_community();
                transaction.replace(R.id.frame,fragment_community);
                transaction.commit();

                btn_todo.setImageResource(R.drawable.checkbox_n);
                btn_chart.setImageResource(R.drawable.chart_n);
                btn_watch.setImageResource(R.drawable.watch_n);
                btn_commu.setImageResource(R.drawable.bubble_y);
                btn_diary.setImageResource(R.drawable.diary_n);
                btn_heart.setImageResource(R.drawable.heart_n);
            }
        });

        btn_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_diary fragment_diary = new Fragment_diary();
                transaction.replace(R.id.frame,fragment_diary);
                transaction.commit();

                btn_todo.setImageResource(R.drawable.checkbox_n);
                btn_chart.setImageResource(R.drawable.chart_n);
                btn_watch.setImageResource(R.drawable.watch_n);
                btn_commu.setImageResource(R.drawable.bubble_n);
                btn_diary.setImageResource(R.drawable.diary_y);
                btn_heart.setImageResource(R.drawable.heart_n);
            }
        });

        btn_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_heart fragment_heart = new Fragment_heart();
                transaction.replace(R.id.frame,fragment_heart);
                transaction.commit();

                btn_todo.setImageResource(R.drawable.checkbox_n);
                btn_chart.setImageResource(R.drawable.chart_n);
                btn_watch.setImageResource(R.drawable.watch_n);
                btn_commu.setImageResource(R.drawable.bubble_n);
                btn_diary.setImageResource(R.drawable.diary_n);
                btn_heart.setImageResource(R.drawable.heart_y);
            }
        });

    }
}