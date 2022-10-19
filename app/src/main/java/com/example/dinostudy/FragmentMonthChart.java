package com.example.dinostudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMonthChart extends Fragment {
    public FragmentMonthChart(){

    }

    private TextView tv_monthchart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_month, container, false);

        tv_monthchart = view.findViewById(R.id.tv_monthchart);

        return view;
    }
}
