package com.pokeinv.entity;
import java.sql.Date;

public class Transaction {
    private Date dateTransaction;
    private double montant;
    private String proprietaire;
    
    public String getDetailsTransaction() {
        return "Date: " + dateTransaction + ", Montant: " + montant + ", Propriétaire: " + proprietaire;
    }
}

