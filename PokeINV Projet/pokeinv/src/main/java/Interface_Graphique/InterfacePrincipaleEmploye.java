package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfacePrincipaleEmploye extends JFrame {
    public InterfacePrincipaleEmploye() throws IOException {
        setTitle("PokeINV USER");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon("src/main/java/donnees/IconApp.png");
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        initialiserComposantsEmploye();
        setVisible(true);
    }

    private void initialiserComposantsEmploye() throws IOException {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

}
