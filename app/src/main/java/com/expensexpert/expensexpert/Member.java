package com.expensexpert.expensexpert;

public class Member {
    private String name;
    private int balance, expense;

    public Member(String name, int balance, int expense) {
        this.name = name;
        this.balance = balance;
        this.expense = expense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}
