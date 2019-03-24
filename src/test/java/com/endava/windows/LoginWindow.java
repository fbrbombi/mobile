package com.endava.windows;

import com.endava.helper.DriverFactory;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginWindow extends BaseWindow {

    @AndroidFindBy(id = "com.olx.olx:id/walkthrough_title")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Google Map']")
    private AndroidElement googleMap;

    @AndroidFindBy(id = "com.olx.olx:id/walkthrough_next")
    private AndroidElement nextButton;

    @AndroidFindBy(id = "com.olx.olx:id/autolocation_button")
    private AndroidElement autoLocation;

    @AndroidFindBy(id = "com.olx.olx:id/search_location")
    private AndroidElement searchLocationText;

    @AndroidFindBy(id = "com.olx.olx:id/search_button")
    private AndroidElement searchButton;

    // @AndroidFindBy(id = "com.olx.olx:id/tutorial_btn_sign_in")
    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/tutorial_btn_sign_in']")
    private AndroidElement mailButton;

    @AndroidFindBy(id = "com.olx.olx:id/tutorial_form_edt_email")
    private AndroidElement mailLabel;

    @AndroidFindBy(id = "com.olx.olx:id/password_edt")
    private AndroidElement passLabel;

    @AndroidFindBy(id = "com.olx.olx:id/tutorial_signup_btn_register")
    private AndroidElement loginButton;

    @AndroidFindBy(id = "com.olx.olx:id/email_confirmation_btn_ok")
    private AndroidElement confirmButton;

    @AndroidFindBy(id = "com.olx.olx:id/email_confirmation_edt_email")
    private AndroidElement confirmMail;

    @AndroidFindBy(id = "com.olx.olx:id/location_fragment")
    private AndroidElement map;

    @AndroidFindBy(className = "android.widget.RelativeLayout")
    private AndroidElement signIn;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> loginText;


    public LoginWindow() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.androidDriver), this);
    }

    public void goToLoginScreen(String mail, String pass) {
        List<WebElement> el = findElementsByUI("new UiSelector().resourceIdMatches(\"com.olx.olx:id/tutorial_btn_sign_in\")");
        if (el.isEmpty()) {
            System.out.println("Button not found");
            return;
        }
        System.out.println("tap Button");
        el.get(0).click();
        waitForVisibility(mailLabel);
        mailLabel.replaceValue(mail);
        sendKeys(passLabel, pass);
        hideKeyboardIfVisible();
        loginButton.click();
        waitForVisibility(confirmButton);
        confirmButton.click();
    }

    public void sendKeys(AndroidElement element, String text) {
        element.sendKeys(text);
    }

    public void addLocation() {
        waitForVisibility(map);
        waitForVisibility(searchLocationText);
        waitForElementToBeClickable(searchLocationText);
        sendKeys(searchLocationText, "Bogota");
        hideKeyboardIfVisible();
        searchButton.click();
        //waitForVisibility(googleMap);
        //googleMap.click();
        tapElement(1, 400, 650, 10); //emulador
        //tapElement(1, 359, 580, 10); //celu
        hideKeyboardIfVisible();
        waitForRefresh(map);
        implicitWait(5);
        nextButton.click();
        implicitWait(3);
    }

    public void addImage() {
        addImageToEmulator();
    }
}
