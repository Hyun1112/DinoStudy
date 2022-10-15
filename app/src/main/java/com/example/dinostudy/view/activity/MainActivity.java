// 10.04 4:47 고쳐본거 mainactivity.java
// 10.04 5:26 고쳐본거 mainactivity.java
package com.example.dinostudy.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dinostudy.R;
import com.example.dinostudy.view.fragment.ChartFragment;
import com.example.dinostudy.view.fragment.CommunityFragment;
import com.example.dinostudy.view.fragment.DiaryFragment;
import com.example.dinostudy.view.fragment.HeartFragment;
import com.example.dinostudy.view.fragment.TodoFragment;
import com.example.dinostudy.view.fragment.WatchFragment;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton btn_todo, btn_chart, btn_watch, btn_commu, btn_diary, btn_heart;
    //private GoogleApiClient mGoogleApiClient;

    Button btnSignOut;
    public FirebaseAuth mAuth;

    public GoogleSignInClient googleSignInClient;


    // private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Configure Google Sign In
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnSignOut = (Button)findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btnSignOut:
//                        signOut();
//                        Toast.makeText(MainActivity.this,"로그아웃 완료", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                        startActivity(intent);
//                        break;
//                }

                mAuth.signOut();
                googleSignInClient.signOut();
                // googleSignInClient.revokeAccess();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        // 탈퇴처리
        // mAuth.getCurrentUser().delete();




        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu); //왼쪽 상단 버튼 아이콘 지정
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);

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
                TodoFragment fragment_todo = new TodoFragment();
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
                ChartFragment fragment_chart = new ChartFragment();
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
                WatchFragment fragment_watch = new WatchFragment();
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
                CommunityFragment fragment_community = new CommunityFragment();
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
                DiaryFragment fragment_diary = new DiaryFragment();
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
                HeartFragment fragment_heart = new HeartFragment();
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

    // 로그아웃,,
    private void signOut() {
        //firebase sign out
        FirebaseAuth.getInstance().signOut();

        //google sign out
        googleSignInClient.signOut();


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