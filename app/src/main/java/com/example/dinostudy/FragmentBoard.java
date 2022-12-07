package com.example.dinostudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentBoard extends Fragment implements View.OnClickListener {

    private ArrayList<Data_Board> arrayList;
    private BoardAdapter boardAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton fab_main;
    private FloatingActionButton fab_search;
    private FloatingActionButton fab_write;
    boolean isMenuOpen = false;

    Context ct;

    public FragmentBoard(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        ct = container.getContext();

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_board);  //mPostRecyclerView
        linearLayoutManager = new LinearLayoutManager(ct);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();  //mDatas
        arrayList.add(new Data_Board("null", "title", "content","d", "20220222"));
        arrayList.add(new Data_Board("null", "title", "content","d", "20220222"));
        arrayList.add(new Data_Board("null", "title", "content","d", "20220222"));

        boardAdapter = new BoardAdapter(arrayList);
        recyclerView.setAdapter(boardAdapter);

        fab_main = (FloatingActionButton)view.findViewById(R.id.fab_main_board);
        fab_search = (FloatingActionButton)view.findViewById(R.id.fab_search_board);
        fab_write = (FloatingActionButton)view.findViewById(R.id.fab_write_board);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuOpen();


            }
        });

        view.findViewById(R.id.fab_write_board).setOnClickListener(this);

        return view;
    }

    private void menuOpen() {   //fab 애니메이션
        if(!isMenuOpen){
            fab_search.animate().translationY(-getResources().getDimension(R.dimen.fab_search));
            fab_search.setVisibility(fab_search.VISIBLE);
            fab_write.animate().translationY(-getResources().getDimension(R.dimen.fab_write));
            fab_write.setVisibility(fab_search.VISIBLE);

            isMenuOpen = true;
        } else{
            fab_search.animate().translationY(0);
            fab_search.setVisibility(fab_search.INVISIBLE);
            fab_write.animate().translationY(0);
            fab_write.setVisibility(fab_search.INVISIBLE);

            isMenuOpen = false;
        }
    }

    @Override
    public void onClick(View view) {    //글쓰기 화면 진입
        Intent intent = new Intent(getActivity(), WritingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }


}
