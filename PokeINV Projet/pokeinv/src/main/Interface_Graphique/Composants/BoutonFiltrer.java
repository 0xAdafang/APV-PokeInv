package Interface_Graphique.Composants;

import javax.swing.JButton;
import java.awt.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;

public class BoutonFiltrer extends JButton {

    public BoutonFiltrer() {
        setText("filtrer les cartes");
        FlatSVGIcon icon = new FlatSVGIcon("");
        setIcon(icon);
        setPreferredSize(new Dimension(200, 50));
        setBackground(new Color(0, 94, 183));
        setIconTextGap(10);
    }

}
