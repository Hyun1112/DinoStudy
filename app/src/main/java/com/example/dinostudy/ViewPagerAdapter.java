package com.example.dinostudy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override  //제목
    public CharSequence getPageTitle(int position){
        return name.get(position);
    }

    @NonNull
    @Override  //화면의 실제 프래그먼트 반환
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override //페이지수
    public int getCount() {
        return arrayList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        arrayList.add(fragment);
        name.add(title);
    }
}
