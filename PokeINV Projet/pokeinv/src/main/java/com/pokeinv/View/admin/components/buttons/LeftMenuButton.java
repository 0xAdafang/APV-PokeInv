package com.pokeinv.View.admin.components.buttons;

import com.pokeinv.View.shared.ColorManager;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class LeftMenuButton extends JButton {

    private boolean selected = false;
    private boolean sumItem = false;

    public LeftMenuButton(String text) {
        setText(text);
        init();
    }

    public LeftMenuButton(String text, boolean selected) {
        setText(text);
        this.selected = selected;
        init();
    }

    public LeftMenuButton(String text, boolean selected, boolean subItem) {
        setText(text);
        this.selected = selected;
        this.sumItem = subItem;
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(180, 50));
        setBackground(ColorManager.ColorMiniPanels);
        setIconTextGap(7);
        setHorizontalAlignment(SwingConstants.LEFT);
        setForeground(ColorManager.customColor(150, 150, 150));
        setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, ColorManager.BackgroundColor),
                new EmptyBorder(0, 15, 0, 0)
        ));

        if (selected) {
            setBackground(new Color(0, 56, 102));
            setBorder(new CompoundBorder(
                    new MatteBorder(0, 2, 0, 0, ColorManager.customColor(0, 145, 185)),
                    new EmptyBorder(0, 15, 0, 0)
            ));
        }

        if (sumItem) {
            setPreferredSize(new Dimension(160, 35));
            setBackground(new Color(0, 26, 47));
            setBorder(new CompoundBorder(
                    new MatteBorder(0, 2, 0, 0, new Color(0, 26, 47)),
                    new EmptyBorder(0, 15, 0, 0)
            ));
        }
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        super.setIcon(defaultIcon);
    }
}
