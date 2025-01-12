package com.pokeinv.View.admin.components;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import com.pokeinv.View.shared.ColorManager;

import java.awt.*;

public class DashboardCard extends JPanel {


    public DashboardCard(String title, String stat, String startEnd) {
        setOpaque(false);
        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel titlePanel = new JPanel(new GridBagLayout());
        JLabel titleText = new JLabel(title);
        titlePanel.add(titleText, gbc);
        titlePanel.setPreferredSize(new Dimension(titlePanel.getWidth(), 35));
        titlePanel.setOpaque(false);
        add(titlePanel, BorderLayout.NORTH);

        JPanel statPanel = new JPanel(new GridBagLayout());


        JLabel statNumber = new JLabel(stat);
        Font font = new Font("Arial", Font.BOLD, 48);
        statNumber.setFont(font);
        statPanel.add(statNumber, gbc);
        statPanel.setOpaque(false);
        statPanel.setBorder(
                new MatteBorder(1, 0, 1, 0,
                        ColorManager.customColorAlpha(0, 94, 183, 100)
                ));
        add(statPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new GridBagLayout());
        JLabel footer = new JLabel(startEnd);
        footerPanel.setPreferredSize(new Dimension(titlePanel.getWidth(), 35));
        footerPanel.setOpaque(false);
        footerPanel.add(footer, gbc);
        add(footerPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(ColorManager.customColorAlpha(0, 94, 183, 120));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        g2.dispose();
    }
}
