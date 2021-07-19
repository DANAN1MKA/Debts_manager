package com.example.design.data_classes;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private String number;
    private int debt;

    public Person(int _id, String _name, String _number, int _debt){
        id = _id;
        name = _name;
        number = _number;
        debt = _debt;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public int getDebt() {
        return debt;
    }
    public void setDebt(int debt) {
        this.debt = debt;
    }
}
