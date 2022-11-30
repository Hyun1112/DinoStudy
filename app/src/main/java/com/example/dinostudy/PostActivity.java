package com.example.dinostudy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {
    //사용자, 현재 날짜 가져오기
    String user, date;
    private EditText et_title, et_contents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);

        et_title = findViewById(R.id.et_title);
        et_contents = findViewById(R.id.et_contents);

        findViewById(R.id.btn_board_write).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(user != null){

        }
    }
}
