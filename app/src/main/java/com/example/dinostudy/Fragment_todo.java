package com.example.dinostudy;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_todo extends Fragment {

    private ArrayList<Data_Todo> arrayList;
    private TodoAdapter todoAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    public Fragment_todo(){

    }

    Context ct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_todo, container, false);

        ct = container.getContext();

        recyclerView = (RecyclerView)v.findViewById(R.id.rv_todo);
        linearLayoutManager = new LinearLayoutManager(ct);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        todoAdapter = new TodoAdapter(arrayList);
        recyclerView.setAdapter(todoAdapter);

        ImageButton btn_plus_todo = (ImageButton) v.findViewById(R.id.btn_plus_todo);
        btn_plus_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Data_Todo dataTodo = new Data_Todo(true, "단어 외우기");
                arrayList.add(dataTodo);
                todoAdapter.notifyDataSetChanged();
                */
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                View view1 = LayoutInflater.from(ct).inflate(R.layout.plus_todo, null, false);
                builder.setView(view1);

                final Button btn_todo_insert = (Button)view1.findViewById(R.id.btn_todo_insert);
                final CheckBox checkBox_todo = (CheckBox)view1.findViewById(R.id.cb_todo);
                final EditText editText_todo = (EditText)view1.findViewById(R.id.et_todo);

                final AlertDialog dialog = builder.create();

                btn_todo_insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //사용자 입력한 내용
                        String todo_content = editText_todo.getText().toString();

                        Data_Todo dataTodo = new Data_Todo(false, todo_content);
                        arrayList.add(dataTodo); //마지막줄에 추가

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });



        return v;
    }
}
