package com.pokeinv.View.admin.parts.employees;

import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.components.Copyright;
import com.pokeinv.View.admin.components.EmployeesLeftMenu;
import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import java.awt.*;

public class WestPanel extends JPanel {

    public WestPanel(AdminView adminView) {
        setLayout(new BorderLayout());
        setBackground(ColorManager.BackgroundColor);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(3, 22, 38));
        JLabel title = new JLabel("MENU");
        title.setForeground(new Color(255, 255, 255));
        titlePanel.add(title);

        JPanel buttonsPanel = new EmployeesLeftMenu(adminView);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBackground(ColorManager.BackgroundColor);
        centerPanel.add(buttonsPanel);

        add(titlePanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        JPanel panelCopyright = new Copyright();
        add(panelCopyright, BorderLayout.SOUTH);
        setVisible(true);

    }

}