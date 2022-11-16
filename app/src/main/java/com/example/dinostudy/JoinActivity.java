package com.example.dinostudy;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class JoinActivity extends AppCompatActivity {
    EditText nickname;
    Button birth;
    Button btn_join;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        birth = findViewById(R.id.birth);

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                birth.setText(birth+"년 " + (month+1) + "월 " + dayOfMonth + "일");
            }
        }, mYear, mMonth, mDay);

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (birth.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });
    }
}
