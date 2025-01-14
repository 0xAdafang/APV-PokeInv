package com.pokeinv.View;

import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.employe.EmployeView;
import com.pokeinv.View.login.LoginView;
import com.pokeinv.View.shared.Composants.Notification;
import com.pokeinv.View.shared.SoundPlayer;
import com.pokeinv.events.login.LoginSuccessEvent;
import com.pokeinv.events.login.LoginSuccessListener;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainView extends JFrame implements LoginSuccessListener {

    private static Clip clip;
    private final CardLayout cardLayout;
    private final JPanel viewContainer;

    public MainView() throws IOException {
        setTitle("PokeINV");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));
        ImageIcon iconApp = new ImageIcon(getClass().getResource("/icons/IconApp.png"));
        setIconImage(iconApp.getImage());
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        cardLayout = new CardLayout();
        viewContainer = new JPanel(cardLayout);

        clip = SoundPlayer.play("/musique/MusiqueCenter.wav", true);
        LoginView loginView = new LoginView(this);
        AdminView adminView = new AdminView();
        EmployeView employeView = new EmployeView();

        viewContainer.add(loginView, "LOGIN");
        viewContainer.add(adminView, "ADMIN");
        viewContainer.add(employeView, "EMPLOYEE");

        mainPanel.add(viewContainer, BorderLayout.CENTER);
        add(mainPanel);
        Notification.setMainFrame(this);
        setVisible(true);
    }

    public static Clip getClip() {
        return clip;
    }


    @Override
    public void loginSuccess(LoginSuccessEvent event) {
        cardLayout.show(viewContainer, event.getRole());
        Notification.showNotification("Heureux de vous revoir " + event.getRole() + " :)", Notification.SUCCESS);
    }
}
