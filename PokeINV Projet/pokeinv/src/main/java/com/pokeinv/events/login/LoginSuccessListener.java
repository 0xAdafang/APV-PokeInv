package com.pokeinv.events.login;

import java.util.EventListener;

public interface LoginSuccessListener extends EventListener {
    void loginSuccess(LoginSuccessEvent event);
}
