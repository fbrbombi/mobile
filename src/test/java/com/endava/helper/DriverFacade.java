package com.endava.helper;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverFacade extends DriverFactory {


    public DriverFacade() {

    }

    protected void waitForVisibility(AndroidElement androidElement) {
        androidDriverWait.until(ExpectedConditions.visibilityOf(androidElement));
    }

    protected void waitForVisibilityOfAllElements(List<WebElement> androidElement) {
        androidDriverWait.until(ExpectedConditions.visibilityOfAllElements(androidElement));
    }

    protected WebElement findSubElementById(AndroidElement androidElement, String id) {
        return androidElement.findElement(By.id(id));
    }

    protected void tapElement(int fingers, int x, int y, int duration) {
        androidDriver.tap(fingers, x, y, duration);
    }

    protected void hideKeyboardIfVisible() {
        androidDriver.hideKeyboard();
    }

    public void goBack() {
        androidDriver.navigate().back();
    }

    public void implicitWait(int timeOut) {
        androidDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

    }

    protected void waitForRefresh(AndroidElement androidElement) {
        androidDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(androidElement))));
    }

    protected void waitForElementToBeClickable(AndroidElement androidElement) {
        androidDriverWait.until(ExpectedConditions.elementToBeClickable(androidElement));
    }

    protected void addImageToEmulator() {
        try {
            androidDriver.pushFile("/storage/emulated/0/DCIM/Camera/testImage.png", new File("testImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected List<WebElement> findElementsByUI(String UIText) {
        return DriverFactory.androidDriver.findElements(MobileBy.AndroidUIAutomator(UIText));

    }
}
