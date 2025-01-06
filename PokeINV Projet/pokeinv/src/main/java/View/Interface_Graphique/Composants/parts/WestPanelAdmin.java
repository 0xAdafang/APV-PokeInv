package View.Interface_Graphique.Composants.parts;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class WestPanelAdmin extends JPanel {

    public WestPanelAdmin() {
        setLayout(new BorderLayout());
        setSize(600, 600);
        setBackground(new Color(28, 28, 51));
        setBorder(new LineBorder(Color.WHITE, 2));

        // text test
        JLabel test = new JLabel("test test test test test");
        test.setForeground(Color.WHITE);
        test.setFont(new Font("Arial", Font.BOLD, 20));
        test.setAlignmentX(0.5f);

        add(test, BorderLayout.CENTER);
    }
}
