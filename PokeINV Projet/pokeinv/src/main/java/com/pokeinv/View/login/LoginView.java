package com.pokeinv.View.login;

import com.pokeinv.View.MainView;
import com.pokeinv.View.shared.Composants.LoginForm;
import com.pokeinv.events.login.LoginSuccessEvent;
import com.pokeinv.events.login.LoginSuccessListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LoginView extends JPanel {
    private final List<LoginSuccessListener> listeners = new ArrayList<>();
    private final LoginForm form = new LoginForm();
    MainView mainView;

    public LoginView(MainView mainView) {
        this.mainView = mainView;
        initialiserComposantsLogin();

        setVisible(true);
    }

    private void initialiserComposantsLogin() {
        setLayout(new BorderLayout());
        setBackground(new Color(28, 28, 51));

        add(form);
        JButton loginButton = form.getButtonLogin();
        loginButton.addActionListener(e -> {
            if (form.isValidated()) {
                fireLoginSuccessEvent(form.getUserRole());
            }
        });

        add(form, BorderLayout.CENTER);
        addLoginSuccessListener(mainView);
    }


    public void addLoginSuccessListener(LoginSuccessListener listener) {
        listeners.add(listener);
    }

    public void removeLoginSuccessListener(LoginSuccessListener listener) {
        listeners.remove(listener);
    }

    private void fireLoginSuccessEvent(String role) {
        LoginSuccessEvent event = new LoginSuccessEvent(this, role);
        for (LoginSuccessListener listener : listeners) {
            listener.loginSuccess(event);
        }
    }

}