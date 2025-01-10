package com.pokeinv.View;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.employe.EmployeView;
import com.pokeinv.View.login.LoginView;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MainView extends JFrame {

    private static Clip clip;
    private LoginView interfacePrincipaleLogin;

    public MainView() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        setTitle("PokeINV");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        URL url = getClass().getResource("/musique/MusiqueCenter.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();

        // interfacePrincipaleLogin = new LoginView();
        interfacePrincipaleLogin = new LoginView();
        mainPanel.add(interfacePrincipaleLogin, BorderLayout.CENTER);

        add(mainPanel);
        revalidate();
        repaint();

        setVisible(true);
    }

    public static Clip getClip() {
        return clip;
    }

}
