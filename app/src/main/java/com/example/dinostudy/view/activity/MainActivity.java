package com.example.dinostudy.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.dinostudy.R;
import com.example.dinostudy.databinding.ActivityMainBinding;
import com.example.dinostudy.model.CheckEmailData;
import com.example.dinostudy.view.fragment.ChartFragment;
import com.example.dinostudy.view.fragment.CommunityFragment;
import com.example.dinostudy.view.fragment.DiaryFragment;
import com.example.dinostudy.view.fragment.HeartFragment;
import com.example.dinostudy.view.fragment.TodoFragment;
import com.example.dinostudy.view.fragment.WatchFragment;
import com.example.dinostudy.viewModel.TodoViewModel;
import com.example.dinostudy.viewModel.WatchViewModel;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private WatchViewModel watchViewModel;
    private TodoViewModel todoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        watchViewModel = new ViewModelProvider(this).get(WatchViewModel.class);
        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        // 현재 날짜 불러오기
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String curDate = sdf.format(date);

        // username 받아오기
        Intent intent = getIntent();
        String username = intent.getStringExtra("nickname");

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.navi_menu); //왼쪽 상단 버튼 아이콘 지정
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        //actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        //actionBar.setHomeAsUpIndicator(R.drawable.menu); //뒤로가기 버튼 이미지 지정

//        // default로 to do 보이게 함
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        TodoFragment fragment_todo = new TodoFragment();
//        transaction.replace(R.id.frame,fragment_todo);
//        transaction.commit();


        binding.btnChk.setImageResource(R.drawable.checkbox_y);
        binding.btnChart.setImageResource(R.drawable.chart_n);
        binding.btnWatch.setImageResource(R.drawable.watch_n);
        binding.btnCommu.setImageResource(R.drawable.bubble_n);
        binding.btnDiary.setImageResource(R.drawable.diary_n);
        binding.btnHeart.setImageResource(R.drawable.heart_n);


        binding.btnChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                TodoFragment fragment_todo = new TodoFragment();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                fragment_todo.setArguments(bundle);

                transaction.replace(binding.frame.getId(),fragment_todo);
                transaction.commit();


                binding.btnChk.setImageResource(R.drawable.checkbox_y);
                binding.btnChart.setImageResource(R.drawable.chart_n);
                binding.btnWatch.setImageResource(R.drawable.watch_n);
                binding.btnCommu.setImageResource(R.drawable.bubble_n);
                binding.btnDiary.setImageResource(R.drawable.diary_n);
                binding.btnHeart.setImageResource(R.drawable.heart_n);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                TodoFragment fragment_todo = new TodoFragment();
//
//                // plan에 현재 날짜에 해당하는 user가 있는지 확인
//                todoViewModel.checkTodo(new CheckTodoData(username, curDate));
//
//
//                todoViewModel.checkResult.observe(MainActivity.this, res -> {
//                    if(res.getCode() == 404) { // 에러
//
//                    } else {
//                        Bundle bundle = new Bundle();
//
//                        bundle.putInt("code", res.getCode());
//                        bundle.putString("username", res.getMessage());
//
//                        System.out.println(res.getCode());
//                        System.out.println(res.getMessage());
//
//                        // 프래그먼트에 데이터 넘겼음 code, username 값
//                        fragment_todo.setArguments(bundle);
//
//
//
//                    }
//                });
//
//
//                transaction.replace(R.id.frame,fragment_todo);
//                transaction.commit();
//
//
//                binding.btnChk.setImageResource(R.drawable.checkbox_y);
//                binding.btnChart.setImageResource(R.drawable.chart_n);
//                binding.btnWatch.setImageResource(R.drawable.watch_n);
//                binding.btnCommu.setImageResource(R.drawable.bubble_n);
//                binding.btnDiary.setImageResource(R.drawable.diary_n);
//                binding.btnHeart.setImageResource(R.drawable.heart_n);

            }
        });

        binding.btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                ChartFragment fragment_chart = new ChartFragment();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                fragment_chart.setArguments(bundle);

                transaction.replace(R.id.frame,fragment_chart);
                transaction.commit();

                binding.btnChk.setImageResource(R.drawable.checkbox_n);
                binding.btnChart.setImageResource(R.drawable.chart_y);
                binding.btnWatch.setImageResource(R.drawable.watch_n);
                binding.btnCommu.setImageResource(R.drawable.bubble_n);
                binding.btnDiary.setImageResource(R.drawable.diary_n);
                binding.btnHeart.setImageResource(R.drawable.heart_n);
            }
        });
//
//        binding.btnWatch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                WatchFragment fragment_watch = new WatchFragment();
//
//                // timer에 현재 날짜, 사용자 데이터 있는지 확인
//                watchViewModel.checkWatch(new CheckWatchData(username, curDate));
//
//
//                // 타이머 데이터 존재 여부 -> WatchFragment로 보내기
//                watchViewModel.resultCode.observe(MainActivity.this, res -> {
//                    if(res.getCode() == 404) { // 에러
//
//                    } else {
//                        Bundle bundle = new Bundle();
//
//                        bundle.putInt("code", res.getCode());
//                        bundle.putString("username", res.getMessage());
//
//                        System.out.println(res.getCode());
//                        System.out.println(res.getMessage());
//
//                        fragment_watch.setArguments(bundle);
//                    }
//                });
//
//                transaction.replace(R.id.frame,fragment_watch);
//                transaction.commit();
//
//                binding.btnChk.setImageResource(R.drawable.checkbox_n);
//                binding.btnChart.setImageResource(R.drawable.chart_n);
//                binding.btnWatch.setImageResource(R.drawable.watch_y);
//                binding.btnCommu.setImageResource(R.drawable.bubble_n);
//                binding.btnDiary.setImageResource(R.drawable.diary_n);
//                binding.btnHeart.setImageResource(R.drawable.heart_n);
//            }
//        });

        binding.btnCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                CommunityFragment fragment_community = new CommunityFragment();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                fragment_community.setArguments(bundle);

                transaction.replace(R.id.frame,fragment_community);
                transaction.commit();

                binding.btnChk.setImageResource(R.drawable.checkbox_n);
                binding.btnChart.setImageResource(R.drawable.chart_n);
                binding.btnWatch.setImageResource(R.drawable.watch_n);
                binding.btnCommu.setImageResource(R.drawable.bubble_y);
                binding.btnDiary.setImageResource(R.drawable.diary_n);
                binding.btnHeart.setImageResource(R.drawable.heart_n);
            }
        });

        binding.btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                DiaryFragment fragment_diary = new DiaryFragment();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                fragment_diary.setArguments(bundle);

                transaction.replace(R.id.frame,fragment_diary);
                transaction.commit();

                binding.btnChk.setImageResource(R.drawable.checkbox_n);
                binding.btnChart.setImageResource(R.drawable.chart_n);
                binding.btnWatch.setImageResource(R.drawable.watch_n);
                binding.btnCommu.setImageResource(R.drawable.bubble_n);
                binding.btnDiary.setImageResource(R.drawable.diary_y);
                binding.btnHeart.setImageResource(R.drawable.heart_n);
            }
        });

        binding.btnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                HeartFragment fragment_heart = new HeartFragment();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                fragment_heart.setArguments(bundle);

                transaction.replace(R.id.frame,fragment_heart);
                transaction.commit();

                binding.btnChk.setImageResource(R.drawable.checkbox_n);
                binding.btnChart.setImageResource(R.drawable.chart_n);
                binding.btnWatch.setImageResource(R.drawable.watch_n);
                binding.btnCommu.setImageResource(R.drawable.bubble_n);
                binding.btnDiary.setImageResource(R.drawable.diary_n);
                binding.btnHeart.setImageResource(R.drawable.heart_y);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                binding.drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}