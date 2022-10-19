package com.example.dinostudy;

import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

public class Fragment_chart extends Fragment {
    public Fragment_chart(){

    }

    ViewPager viewPager;
    private FragmentDayChart FragmentDayChart;
    private FragmentWeekChart FragmentWeekChart;
    private FragmentMonthChart FragmentMonthChart;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), 0);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout_chart);
        tabLayout.setupWithViewPager(viewPager);

        FragmentDayChart = new FragmentDayChart();
        FragmentWeekChart = new FragmentWeekChart();
        FragmentMonthChart = new FragmentMonthChart();

        adapter.addFragment(FragmentDayChart, "일간");
        adapter.addFragment(FragmentWeekChart, "주간");
        adapter.addFragment(FragmentMonthChart, "월간");
        viewPager.setAdapter(adapter);

        return view;
    }
}
