package Interface_Graphique.Composants;

import javax.swing.JButton;
import java.awt.*;

public class BoutonAjouter extends JButton {

    public BoutonAjouter() {
        setText("Ajouter une carte");
        setPreferredSize(new Dimension(200, 50));
        setBackground(new Color(0, 94, 183));
        setIconTextGap(10);
    }

}
