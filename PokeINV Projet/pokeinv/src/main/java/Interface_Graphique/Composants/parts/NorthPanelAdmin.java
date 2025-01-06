package Interface_Graphique.Composants.parts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Interface_Graphique.Composants.BoutonAjouter;
import Interface_Graphique.Composants.BoutonFiltrer;

public class NorthPanelAdmin extends JPanel {

    public NorthPanelAdmin() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(Color.WHITE, 2));

        // Boutons
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();
        boutonFiltrer.setSize(20, 20);
        BoutonAjouter boutonAjouter = new BoutonAjouter();

        // Text pour info de lapplication
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(new Color(28, 28, 51));
        JTextArea textArea = new JTextArea("\n Bienvenues!! \n ");
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new java.awt.Font("courier new", 1, 25));
        infoPanel.add(textArea, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.WEST);

        boutonAjouter.setSize(20, 20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(28, 28, 51));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        buttonPanel.add(boutonFiltrer);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(boutonAjouter);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
