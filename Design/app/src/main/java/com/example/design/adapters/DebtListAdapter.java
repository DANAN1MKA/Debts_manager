package com.example.design.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.data_classes.Debt;
import com.example.design.interfaces.IDebtItemClick;
import com.example.design.interfaces.IPersonItemClick;

import java.util.ArrayList;

public class DebtListAdapter extends RecyclerView.Adapter<DebtListAdapter.RecyclerViewHolder> {
    Context context;
    private ArrayList<Debt> contentList;
    IDebtItemClick onItemClick;
    private boolean isIOwe;

    public DebtListAdapter(Context _context, ArrayList<Debt> _contentList, IDebtItemClick _onItemClick, boolean isIOwe){
        this.context = _context;
        this.contentList = _contentList;
        this.onItemClick = _onItemClick;
        this.isIOwe = isIOwe;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_view_debt_entry, parent, false);

        return new DebtListAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.tv_name.setText("Name");

        String debtText = isIOwe ? "-500" : "+500";
        holder.tv_debt.setText(debtText);
        holder.tv_loan_date.setText("Date: 12.02.2021");
        holder.tv_payment_date.setText("Date: 12.01.2021");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onDebtItemClick(contentList.get(position));
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
        TextView tv_loan_date;
        TextView tv_payment_date;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_debt = itemView.findViewById(R.id.tv_debt);
            tv_loan_date = itemView.findViewById(R.id.tv_loan_date);
            tv_payment_date = itemView.findViewById(R.id.tv_payment_date);
        }
    }
}
