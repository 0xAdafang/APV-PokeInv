package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Employe;
import com.pokeinv.service.DataFixtures;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Objects;

public class EmployesTableModel extends AbstractTableModel {

    private static EmployesTableModel instance;
    private final String[] nomsDesColonnes = {"ID", "Nom", "Prénom", "Date d'embauche", "Actions"};
    private List<Employe> employeList;

    private EmployesTableModel() {
        this.employeList = DataFixtures.getEmployes();
    }

    public static EmployesTableModel getInstance() {
        if (instance == null) {
            instance = new EmployesTableModel();
        }
        return instance;
    }

    @Override
    public int getRowCount() {
        return employeList.size();
    }

    @Override
    public int getColumnCount() {
        return nomsDesColonnes.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomsDesColonnes[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employe employee = employeList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> employee.getId();
            case 1 -> employee.getFirstname();
            case 2 -> employee.getLastname();
            case 3 -> employee.getHireDate();
            case 4 -> "Actions";
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4;
    }

    public void updateData(List<Employe> nouvelEmploye) {
        this.employeList = nouvelEmploye;
        fireTableDataChanged();
    }

    public Employe getEmployeeAt(int row) {
        return employeList.get(row);
    }

    public void addCard(Employe employe) {
        employeList.add(employe);
    }

    public void removeCardAt(int row) {
        employeList.remove(row);
        fireTableDataChanged();
    }

    public void filtrerEmployeesParNom(String nom) {
        if (nom.equals("ASC")) {
            employeList = employeList.stream().filter(employe -> employe.getLastname() != null).toList();
            fireTableDataChanged();
        }
    }

    public void filtrerEmployesParId(Long id) {
        employeList = employeList.stream().filter(employe -> Objects.equals(employe.getId(), id)).toList();
        fireTableDataChanged();
    }
}
