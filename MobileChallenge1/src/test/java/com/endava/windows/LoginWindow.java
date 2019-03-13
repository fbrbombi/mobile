package com.endava.windows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class LoginWindow extends BaseWindow {

    @FindBy(id = "com.olx.olx:id/walkthrough_next")
    AndroidElement beginButton;

    public LoginWindow(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void getMainPage(){
        waitForVisibility(beginButton);

    }


}
