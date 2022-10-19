package com.example.dinostudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWeekChart extends Fragment {
    public FragmentWeekChart(){

    }

    private TextView tv_weekchart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_week, container, false);

        tv_weekchart = view.findViewById(R.id.tv_weekchart);

        return view;
    }
}
