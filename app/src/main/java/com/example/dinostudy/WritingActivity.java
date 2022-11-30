package com.example.dinostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class WritingActivity extends AppCompatActivity {
    //사용자, 현재 날짜 가져오기
    String user, date;
    private EditText et_title, et_contents;
    Button btn_board_write;
    Spinner spinner_category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);

        et_title = findViewById(R.id.et_title);
        et_contents = findViewById(R.id.et_contents);
        btn_board_write = findViewById(R.id.btn_board_write);
        spinner_category = findViewById(R.id.spinner_board);

        String title = et_title.getText().toString();
        String contents = et_contents.getText().toString();
        String category = spinner_category.getSelectedItem().toString();

        /*
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String category = (String) spinner_category.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

         */


        btn_board_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),PostActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("contents", contents);
                intent.putExtra("category",category);
            }
        });
    }

}
