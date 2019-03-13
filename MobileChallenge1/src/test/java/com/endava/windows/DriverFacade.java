package com.endava.windows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFacade {
    protected AndroidDriver androidDriver;
    protected WebDriverWait webDriverWait;
    FluentWait wait;
    public DriverFacade(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        wait = new WebDriverWait(androidDriver, 10);
    }

    public void waitForVisibility(AndroidElement element){
           this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
