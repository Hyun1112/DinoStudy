package com.example.dinostudy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        arrayList.add(new FragmentDayChart());
        arrayList.add(new FragmentWeekChart());
        arrayList.add(new FragmentMonthChart());

        name.add("일간");
        name.add("주간");
        name.add("월간");
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){
        return name.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
