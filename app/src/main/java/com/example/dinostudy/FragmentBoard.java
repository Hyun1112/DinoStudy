package com.example.dinostudy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentBoard extends Fragment {

    private ArrayList<Data_Board> arrayList;
    private BoardAdapter boardAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    Context ct;

    public FragmentBoard(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        ct = container.getContext();

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_board);
        linearLayoutManager = new LinearLayoutManager(ct);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        boardAdapter = new BoardAdapter(arrayList);
        recyclerView.setAdapter(boardAdapter);

        return view;
    }
}
