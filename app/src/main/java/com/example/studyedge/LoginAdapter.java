package com.example.studyedge;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm, Context context,int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int pos){
        switch(pos){
            case 0:
                LoginDesign loginTab = new LoginDesign();
                return loginTab;
            case 1:
                SignUpDesign signUpTab = new SignUpDesign();
                return signUpTab;
            default:
                return null;
        }
    }
}