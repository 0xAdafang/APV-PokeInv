package com.pokeinv.events.login;

import java.util.EventObject;

public class LoginSuccessEvent extends EventObject {
    private final String role;

    public LoginSuccessEvent(Object source, String role) {
        super(source);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
