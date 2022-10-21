package com.example.dinostudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;

public class FragmentDayChart extends Fragment {
    public FragmentDayChart(){

    }

    PieChart pieChart;
    private LineChart lineChart;
    private TextView tv_daychart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_day, container, false);

        tv_daychart = view.findViewById(R.id.tv_daychart);

        return view;
    }
}
