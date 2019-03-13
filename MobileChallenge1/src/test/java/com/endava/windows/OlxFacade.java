package com.endava.windows;

import io.appium.java_client.android.AndroidDriver;

public class OlxFacade {
    LoginWindow loginWindow;


    public OlxFacade(AndroidDriver androidDriver) {
        loginWindow = new LoginWindow(androidDriver);
    }

    public void goToMainWindow() {
        loginWindow.getMainPage();
    }

}
