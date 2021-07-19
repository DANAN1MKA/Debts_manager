package com.example.design;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.design.adapters.ViewPagerAdapter;
import com.example.design.data_classes.Person;
import com.example.design.fragnemts.FragmentMain;
import com.example.design.fragnemts.FragmentPersons;
import com.example.design.interfaces.IPersonItemClick;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements IPersonItemClick {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tabs & fragments
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add Fragments
        FragmentMain fragmentMain = new FragmentMain();
        FragmentPersons fragmentPersons = new FragmentPersons();
        fragmentPersons.setPersonItemClick(this);

        viewPagerAdapter.addFragmen(fragmentMain, "main");
        viewPagerAdapter.addFragmen(fragmentPersons, "people");

        //set adapter
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //set listener
        TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                super.onTabSelected(tab);
            }
        };

        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
    }

    @Override
    public void onPersonItemClick(Person person) {
        Intent intent = new Intent(MainActivity.this, PersonDetailActivity.class);
        intent.putExtra(String.valueOf(R.string.intent_keys_person), person);
        startActivity(intent);
    }
}
