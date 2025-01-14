package com.pokeinv.View;

import com.pokeinv.View.login.LoginView;
import com.pokeinv.View.shared.Composants.Notification;
import com.pokeinv.View.shared.SoundPlayer;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainView extends JFrame {

    private static Clip clip;
    private LoginView interfacePrincipaleLogin;

    public MainView() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        setTitle("PokeINV");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        SoundPlayer.play("/musique/MusiqueCenter.wav", true);

        interfacePrincipaleLogin = new LoginView();
        mainPanel.add(interfacePrincipaleLogin, BorderLayout.CENTER);

        add(mainPanel);
        revalidate();
        repaint();
        Notification.setMainFrame(this);
        setVisible(true);

    }

    public static Clip getClip() {
        return clip;
    }

}
