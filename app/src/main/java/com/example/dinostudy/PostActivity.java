package com.example.dinostudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

        arrayList = new ArrayList<>();

        commentAdapter = new CommentAdapter(arrayList);
        recyclerView.setAdapter(commentAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras(); // bundle을 통해 Extra들을 모두 가져온다
        String title = bundle.getString("title"); // 키 값을 통해서 extras에 있는 값들을 얻는다.
        String contents = bundle.getString("contents");
        String category = bundle.getString("category");

        tv_title.setText(title);
        post_category.setText(category);
        board_post_content.setText(contents);

        Button btn_comment_insert = (Button) findViewById(R.id.btn_comment_insert);
        btn_comment_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data_Comment dataComment = new Data_Comment("hk","2022.12.01","안녕하세요");
                arrayList.add(dataComment);
                commentAdapter.notifyDataSetChanged();
            }
        });

    }
}
