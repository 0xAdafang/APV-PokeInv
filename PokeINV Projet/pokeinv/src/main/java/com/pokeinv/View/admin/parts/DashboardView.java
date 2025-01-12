package com.pokeinv.View.admin.parts;

import com.pokeinv.View.admin.AdminView;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel {

    public DashboardView(AdminView adminView) {
        setLayout(new BorderLayout());
        DashboardWestPanel westPanel = new DashboardWestPanel(adminView);
        MainDashboardPanel main = new MainDashboardPanel();
        add(main, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);
    }
}
