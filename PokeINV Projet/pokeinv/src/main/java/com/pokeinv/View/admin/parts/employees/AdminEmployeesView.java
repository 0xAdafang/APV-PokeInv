package com.pokeinv.View.admin.parts.employees;

import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.parts.tables.EmployeesTable;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class AdminEmployeesView extends JPanel {

    private AdminView adminView;

    public AdminEmployeesView(AdminView adminView) {
        this.adminView = adminView;
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() {

        setLayout(new BorderLayout());
        WestPanel westPanel = new WestPanel(adminView);
        EmployeesTable table = new EmployeesTable();
        JScrollPane main = new JScrollPane(table);
        main.setBorder(new MatteBorder(1, 1, 1, 1, new Color(28, 28, 51)));
        add(main, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);

    }

}
