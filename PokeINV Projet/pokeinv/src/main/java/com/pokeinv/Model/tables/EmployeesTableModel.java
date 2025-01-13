package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Employee;
import com.pokeinv.service.DataFixtures;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Objects;

public class EmployeesTableModel extends AbstractTableModel {

    private static EmployeesTableModel instance;
    private final String[] nomsDesColonnes = {"ID", "Nom", "Prénom", "Date d'embauche", "Actions"};
    private List<Employee> employeeList;

    private EmployeesTableModel() {
        this.employeeList = DataFixtures.getEmployees();
    }

    public static EmployeesTableModel getInstance() {
        if (instance == null) {
            instance = new EmployeesTableModel();
        }
        return instance;
    }

    @Override
    public int getRowCount() {
        return employeeList.size();
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
        Employee employee = employeeList.get(rowIndex);
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

    public void updateData(List<Employee> nouvelEmployee) {
        this.employeeList = nouvelEmployee;
        fireTableDataChanged();
    }

    public Employee getEmployeeAt(int row) {
        return employeeList.get(row);
    }

    public void addCard(Employee employee) {
        employeeList.add(employee);
    }

    public void removeCardAt(int row) {
        employeeList.remove(row);
        fireTableDataChanged();
    }

    public void filtrerEmployeesParNom(String nom) {
        if (nom.equals("ASC")) {
            employeeList = employeeList.stream().filter(employee -> employee.getLastname() != null).toList();
            fireTableDataChanged();
        }
    }

    public void filtrerEmployeesParId(Long id) {
        employeeList = employeeList.stream().filter(employee -> Objects.equals(employee.getId(), id)).toList();
        fireTableDataChanged();
    }
}
