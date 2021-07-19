package com.example.design.fragnemts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.AboutDebtActivity;
import com.example.design.R;
import com.example.design.adapters.DebtListAdapter;
import com.example.design.data_classes.Debt;
import com.example.design.interfaces.IDebtItemClick;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

public class FragmentDebts extends Fragment {
    View view;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    DebtListAdapter debtListAdapter;
    ArrayList<Debt> debtArrayList = new ArrayList<>();
    IDebtItemClick itemClick;

    FloatingActionButton b_add_debt;

    public void setItemClickCallback(IDebtItemClick itemClick) {
        this.itemClick = itemClick;
    }

    private boolean isIOwe;

    public FragmentDebts(boolean isIOwe){
        this.isIOwe = isIOwe;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_debt_list, container, false);

        b_add_debt = view.findViewById(R.id.b_add_debt);
        b_add_debt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutDebtActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = view.findViewById(R.id.rv_debt_list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        debtListAdapter = new DebtListAdapter(getActivity(), debtArrayList, itemClick, isIOwe);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(debtListAdapter);

        for(int i = 0; i < 5; i++){
            debtArrayList.add(new Debt(i, 1*10, true, "adfasfdasdfa", new Date(2021, 02,11), new Date(2021, 03,11)));
        }

        updateRecyclerView();

        return view;
    }

    public void updateRecyclerView(){
        debtListAdapter.notifyDataSetChanged();
    }
}
