package com.example.dinostudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //ImageButton navi_menu;
    ImageButton btn_todo, btn_chart, btn_watch, btn_commu, btn_diary, btn_heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.navi_menu); //왼쪽 상단 버튼 아이콘 지정
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        //navi_menu = (ImageButton)findViewById(R.id.navi_menu);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        //actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        //actionBar.setHomeAsUpIndicator(R.drawable.menu); //뒤로가기 버튼 이미지 지정

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id = item.getItemId();
                String title = item.getTitle().toString();

                if(id == R.id.item_info){
                    //Intent intent = new Intent(getApplicationContext(), ??.class);
                    //startActivity(intent);
                } else if(id == R.id.item_mission){
                    Intent intent = new Intent(getApplicationContext(), MissionActivity.class);
                    startActivity(intent);
                } else if(id == R.id.item_group){

                }

                return true;
            }
        });

        String id = null;

        btn_todo = (ImageButton)findViewById(R.id.btn_chk);
        btn_chart = (ImageButton)findViewById(R.id.btn_chart);
        btn_watch = (ImageButton)findViewById(R.id.btn_watch);
        btn_commu = (ImageButton)findViewById(R.id.btn_commu);
        btn_diary = (ImageButton)findViewById(R.id.btn_diary);
        btn_heart = (ImageButton)findViewById(R.id.btn_heart);

        //btn_watch.performClick();

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
                FragmentBoard fragment_board = new FragmentBoard();
                transaction.replace(R.id.frame,fragment_board);
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

        btn_watch.performClick(); //첫 홈화면을 스톱워치로 설정하기

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}