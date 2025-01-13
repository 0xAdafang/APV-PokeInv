package com.pokeinv.Model.entity;

import java.util.Date;

public class Connexion {

    private Long id;
    private String email;
    private String password;
    private String status;
    private Date lastConnection;

    private Employe employe;

    public Connexion(Long id, String email, String password, String status, Date lastConnection, Employe employee) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.lastConnection = lastConnection;
        this.employe = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }

    public Employe getEmployee() {
        return employe;
    }

    public void setEmployee(Employe employee) {
        this.employe = employee;
    }

    @Override
    public String toString() {
        return "Connexion{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", lastConnection=" + lastConnection +
                ", employee=" + employe +
                '}';
    }
}