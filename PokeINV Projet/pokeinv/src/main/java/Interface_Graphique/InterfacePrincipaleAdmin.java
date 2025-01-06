package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLightLaf;

import Interface_Graphique.Composants.parts.NorthPanelAdmin;
import Interface_Graphique.Composants.parts.WestPanel;

public class InterfacePrincipaleAdmin extends JFrame {

    public InterfacePrincipaleAdmin() throws IOException {
        setTitle("PokeINV ADMIN");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() throws IOException {

        FlatLightLaf.setup();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        // Panel du centre
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));
        centerPanel.setBorder(new LineBorder(Color.WHITE, 2));
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel du west
        WestPanel westPanel = new WestPanel();

        // Panel du nord
        NorthPanelAdmin northPanel = new NorthPanelAdmin();
        northPanel.setPreferredSize(new Dimension(80, 100));

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

}
