package com.example.dinostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {

    private ArrayList<Data_Comment> arrayList;
    private CommentAdapter commentAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private TextView tv_title,post_category, post_nickname, board_date, board_post_content;
    private EditText et_comment_write;
    private String user,date;
    //private ImageButton btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_post);

        recyclerView = (RecyclerView) findViewById(R.id.rv_comment);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        tv_title = findViewById(R.id.tv_title);
        post_category = findViewById(R.id.post_category);
        post_nickname = findViewById(R.id.nickname);
        board_date = findViewById(R.id.board_date);
        board_post_content = findViewById(R.id.board_post_content);
        //btn_back = findViewById(R.id.btn_back);

        arrayList = new ArrayList<>();

        commentAdapter = new CommentAdapter(arrayList);
        recyclerView.setAdapter(commentAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras(); // bundle??? ?????? Extra?????? ?????? ????????????
        String title = bundle.getString("title"); // ??? ?????? ????????? extras??? ?????? ????????? ?????????.
        String contents = bundle.getString("contents");
        String category = bundle.getString("category");

        tv_title.setText(title);
        post_category.setText(category);
        board_post_content.setText(contents);

        //?????? ????????????
        et_comment_write = findViewById(R.id.et_comment_write);
        user = "hk";
        date = "2022.12.07";

        Button btn_comment_insert = (Button) findViewById(R.id.btn_comment_insert);
        btn_comment_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = et_comment_write.getText().toString();

                Data_Comment dataComment = new Data_Comment(user,date,comment);
                arrayList.add(dataComment);
                commentAdapter.notifyDataSetChanged();
            }
        });

        /*
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment_watch fragment_watch = new Fragment_watch();
                transaction.replace(R.id.frame,fragment_watch);
                transaction.commit();
            }
        });

         */

    }
}
