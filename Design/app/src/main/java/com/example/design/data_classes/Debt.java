package com.example.design.data_classes;

import java.io.Serializable;
import java.util.Date;

public class Debt implements Serializable {
    private int user_id;
    private int debt_entry;
    private boolean my_debt;
    private String description;
    private Date taken;
    private Date term;

    public Debt(int _user_id, int _debt_entry, boolean _my_debt, String _description, Date _taken, Date _term){
        user_id = _user_id;
        debt_entry = _debt_entry;
        my_debt = _my_debt;
        description = _description;
        term = _term;
        taken = _taken;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDebt_entry() {
        return debt_entry;
    }
    public void setDebt_entry(int debt_entry) {
        this.debt_entry = debt_entry;
    }

    public boolean getMy_debt(){
        return my_debt;
    }
    public void setMy_debt(boolean my_debt) {
        this.my_debt = my_debt;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTerm() {
        return term;
    }
    public void setTerm(Date term) {
        this.term = term;
    }

    public Date getTaken() {
        return taken;
    }
    public void setTaken(Date taken) {
        this.taken = taken;
    }
}
