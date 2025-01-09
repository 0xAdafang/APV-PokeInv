package com.pokeinv.Model.entity;

import java.sql.Date;

public class Transaction {
    private Date transactionDate;
    private double amount;
    private String proprietaire;

    public String getDetailsTransaction() {
        return "Date: " + transactionDate + ", Montant: " + amount + ", Propriétaire: " + proprietaire;
    }
}

