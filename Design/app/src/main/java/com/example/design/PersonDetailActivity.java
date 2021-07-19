package com.example.design;

import android.content.Intent;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.adapters.PersonDebtsListAdapter;
import com.example.design.data_classes.Debt;
import com.example.design.data_classes.Person;
import com.example.design.interfaces.IDebtItemClick;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

public class PersonDetailActivity extends AppCompatActivity implements IDebtItemClick {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    PersonDebtsListAdapter personDebtsListAdapter;
    ArrayList<Debt> debtArrayList = new ArrayList<>();


    TextView tv_person_name;
    TextView tv_debt_amount;
    FloatingActionButton b_add_debt;

    private Person person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        person = getPerson();

        findViewComponents();
        tuneRecyclerView();
        setButtonListeners();

        //TODO заглушка
        for(int i = 0; i < 5; i++){
            debtArrayList.add(new Debt(i, 1*10, true, "adfasfdasdfa", new Date(2021, 02,11), new Date(2021, 03,11)));
        }

        updateUI();
    }

    @Override
    public void onDebtItemClick(Debt debt) {
        startOperationActivity(debt);
    }

    private void findViewComponents(){
        tv_person_name = findViewById(R.id.tv_person_name);
        tv_debt_amount = findViewById(R.id.tv_debt_amount);

        b_add_debt = findViewById(R.id.b_add_debt);

        recyclerView = findViewById(R.id.rv_person_debts_list);
    }

    private void tuneRecyclerView(){
        linearLayoutManager = new LinearLayoutManager(this);
        personDebtsListAdapter = new PersonDebtsListAdapter(this, debtArrayList, this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personDebtsListAdapter);
    }

    private void setButtonListeners(){
        b_add_debt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOperationActivity(null);
            }
        });
    }

    private Person getPerson(){
        Bundle argument = getIntent().getExtras();
        if(argument != null)
            return (Person)argument.getSerializable(String.valueOf(R.string.intent_keys_person));
        else return null;
    }

    private void updateUI(){
        tv_person_name.setText(person.getName());
        tv_debt_amount.setText(person.getDebt());
        personDebtsListAdapter.notifyDataSetChanged();
    }

    private void startOperationActivity(Debt debt){
        Intent intent = new Intent(PersonDetailActivity.this, OperationActivity.class);
        if(debt != null) intent.putExtra(String.valueOf(R.string.intent_keys_debt), debt);
        startActivity(intent);
    }
}
