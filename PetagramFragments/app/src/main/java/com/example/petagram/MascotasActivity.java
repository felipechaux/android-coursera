package com.example.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.petagram.adapter.PageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MascotasActivity extends BaseActivity {


    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        tablayout= findViewById(R.id.tabLayout);
        viewPager= findViewById(R.id.viewPager);

        configActionBar(this);
        setupViewPager();

    }

    private ArrayList<Fragment> addFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        try {
            fragments.add(new ListMascotasFragment());
            fragments.add(new PerfilMascotaFragment());
        }catch (Exception e){
            e.printStackTrace();
        }
        return fragments;
    }

    private void setupViewPager(){
        try {
            viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),addFragment()));
            tablayout.setupWithViewPager(viewPager);
            tablayout.getTabAt(0).setIcon(R.drawable.ic_home);
            tablayout.getTabAt(1).setIcon(R.drawable.ic_dog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}