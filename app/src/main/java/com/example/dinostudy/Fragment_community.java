package com.example.dinostudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Fragment_community extends Fragment {

    public Fragment_community(){

    }

    ViewPager viewPager;
    private FragmentBoard FragmentBoard;
    private FragmentGroup FragmentGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        viewPager = view.findViewById(R.id.viewpager_community);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), 0);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout_community);
        tabLayout.setupWithViewPager(viewPager);

        FragmentBoard = new FragmentBoard();
        FragmentGroup = new FragmentGroup();

        adapter.addFragment(FragmentBoard, "게시판");
        adapter.addFragment(FragmentGroup, "스터디그룹");
        viewPager.setAdapter(adapter);

        return view;
    }
}
