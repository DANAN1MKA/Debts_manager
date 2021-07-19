package com.example.design;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.design.adapters.ViewPagerAdapter;
import com.example.design.data_classes.Debt;
import com.example.design.fragnemts.FragmentDebts;
import com.example.design.interfaces.IDebtItemClick;
import com.google.android.material.tabs.TabLayout;

public class DebtsActivity extends AppCompatActivity implements IDebtItemClick {

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
        FragmentDebts fragmentIOwe = new FragmentDebts(true);
        FragmentDebts fragmentOweMe = new FragmentDebts(false);

        fragmentIOwe.setItemClickCallback(this);
        fragmentOweMe.setItemClickCallback(this);

        viewPagerAdapter.addFragmen(fragmentIOwe, "I owe");
        viewPagerAdapter.addFragmen(fragmentOweMe, "Owe me");

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


        //update recyclerview
        //fragmentPersons.updateRecyclerView();

        //tabs & fragments


    }

    @Override
    public void onDebtItemClick(Debt debt) {
        Intent intent = new Intent(DebtsActivity.this, PersonDetailActivity.class);
        //intent.putExtra("debt", debt);
        startActivity(intent);
    }
}
