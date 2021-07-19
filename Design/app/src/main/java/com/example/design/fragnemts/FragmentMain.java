package com.example.design.fragnemts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.design.DebtsActivity;
import com.example.design.MainActivity;
import com.example.design.R;

public class FragmentMain extends Fragment {
    View view;

    Button b_my_debt;
    Button b_debt_me;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_constraint,container,false);

        b_my_debt = view.findViewById(R.id.b_my_debt);
        b_debt_me = view.findViewById(R.id.b_debt_me);

        b_my_debt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DebtsActivity.class);
                startActivity(intent);
            }
        });

        b_debt_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DebtsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
