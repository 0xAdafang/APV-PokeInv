package com.pokeinv.View.admin.parts;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel {

    public DashboardView() {
        setLayout(new BorderLayout());
        DashboardWestPanel westPanel = new DashboardWestPanel();
        MainDashboardPanel main = new MainDashboardPanel();
        add(main, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);
    }
}
