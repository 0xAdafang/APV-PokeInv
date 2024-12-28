package Interface_Graphique.Composants;

import javax.swing.JButton;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;

public class BoutonAjouter extends JButton {

    public BoutonAjouter() {
        try {
            FlatSVGIcon icon = new FlatSVGIcon(getClass().getResource("/donnees/ajoute.svg"));
            setIcon(icon);
            setBackground(new Color(0xFFC107));
            setBounds(100, 100, 100, 100);
            setSize(100, 100);
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
        }
    }

}
