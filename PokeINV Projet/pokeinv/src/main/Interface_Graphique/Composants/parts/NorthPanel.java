package Interface_Graphique.Composants.parts;

import javax.swing.*;

import Interface_Graphique.Composants.BoutonFiltrer;

import java.awt.*;

public class NorthPanel extends JPanel {

    public NorthPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(28, 28, 51));

        // Boutons
        BoutonFiltrer boutonFiltrer = new BoutonFiltrer();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(28, 28, 51));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(boutonFiltrer);

        add(buttonPanel, BorderLayout.EAST);
    }
}
