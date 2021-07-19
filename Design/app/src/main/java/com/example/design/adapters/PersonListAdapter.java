package com.example.design.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.data_classes.Person;
import com.example.design.interfaces.IPersonItemClick;

import java.util.ArrayList;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.RecyclerViewHolder> {
    Context context;
    private ArrayList<Person> contentList;
    IPersonItemClick itemClickInterface;

    public PersonListAdapter(Context _context, ArrayList<Person> _contentList, IPersonItemClick _itemClickInterface){
        this.context = _context;
        this.contentList = _contentList;
        this.itemClickInterface = _itemClickInterface;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_view_person_entry, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.tv_name.setText("Name");
        holder.tv_debt.setText("-200");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickInterface.onPersonItemClick(contentList.get(position));
            }
        };

        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_debt;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_debt = itemView.findViewById(R.id.tv_debt);
        }
    }
}
