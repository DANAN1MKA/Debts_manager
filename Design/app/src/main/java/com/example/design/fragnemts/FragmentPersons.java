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

import com.example.design.AddPersonActivity;
import com.example.design.R;
import com.example.design.data_classes.Person;
import com.example.design.adapters.PersonListAdapter;
import com.example.design.interfaces.IPersonItemClick;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentPersons extends Fragment {
    View view;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    PersonListAdapter personListAdapter;
    ArrayList<Person> personArrayList = new ArrayList<>();
    IPersonItemClick personItemClick;

    FloatingActionButton addPerson;

    public void setPersonItemClick(IPersonItemClick personItemClick) {
        this.personItemClick = personItemClick;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_persons, container, false);

        addPerson = view.findViewById(R.id.b_add_person);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPersonActivity.class);
                startActivity(intent);
            }
        };
        addPerson.setOnClickListener(onClickListener);

        recyclerView = view.findViewById(R.id.rv_person_list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        personListAdapter = new PersonListAdapter(getActivity(), personArrayList, personItemClick);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personListAdapter);

        for(int i = 0; i < 10; i++){
            personArrayList.add(new Person(i, "Name", "123", -200));
        }

        updateRecyclerView();

        return view;
    }

    public void updateRecyclerView(){
        personListAdapter.notifyDataSetChanged();
//        int visible = personArrayList.isEmpty() ? View.VISIBLE : View.INVISIBLE;
//        recyclerView.setVisibility(visible);
    }
}
