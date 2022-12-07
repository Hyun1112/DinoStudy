package com.example.dinostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WritingActivity extends AppCompatActivity {
    //사용자, 현재 날짜 가져오기
    String user, date;
    private EditText et_title, et_contents;
    Button btn_board_write;
    Spinner spinner_category;

    TextView test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);

        et_title = (EditText) findViewById(R.id.et_title);
        et_contents = (EditText)findViewById(R.id.et_contents);
        btn_board_write = (Button) findViewById(R.id.btn_board_write);
        spinner_category = findViewById(R.id.spinner_board);

        btn_board_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = et_title.getText().toString();
                String contents = et_contents.getText().toString();
                String category = spinner_category.getSelectedItem().toString();

                Intent intent = new Intent(getBaseContext(),PostActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("contents", contents);
                intent.putExtra("category",category);

                startActivity(intent);
            }
        });
    }

}
