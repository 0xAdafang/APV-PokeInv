package View.Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import View.Interface_Graphique.Composants.parts.NorthPanel;
import View.Interface_Graphique.Composants.parts.WestPanel;

public class InterfacePrincipaleEmploye extends JPanel {
    public InterfacePrincipaleEmploye() throws IOException {
        initialiserComposantsEmploye();
        setVisible(true);
    }

    private void initialiserComposantsEmploye() throws IOException {
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));

        // Panel du Nord
        NorthPanel northPanel = new NorthPanel();
        northPanel.setPreferredSize(new Dimension(80, 100));

        // Panel du West
        WestPanel westPanel = new WestPanel();

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

}
