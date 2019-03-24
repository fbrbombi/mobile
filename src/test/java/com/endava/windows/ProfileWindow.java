package com.endava.windows;

import com.endava.helper.ConfigLoader;
import com.endava.helper.DriverFactory;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProfileWindow extends BaseWindow {

    @AndroidFindBy(id = "com.olx.olx:id/wallet_onboarding_ok_button")
    private AndroidElement understoodButton;

    @AndroidFindBy(id = "com.olx.olx:id/basic_info_edit_profile")
    private AndroidElement editButton;

    @AndroidFindBy(id = "com.olx.olx:id/edit_profile_fullname")
    private AndroidElement editName;

    @AndroidFindBy(id = "com.olx.olx:id/edit_profile_password")
    private AndroidElement editPassword;

    @AndroidFindBy(id = "com.olx.olx:id/edit_profile_change_picture_button")
    private AndroidElement editPhoto;

    @AndroidFindBy(id = "com.olx.olx:id/edit_profile_img")
    private AndroidElement photoContent;

    @AndroidFindBy(id = "com.olx.olx:id/current_password")
    private AndroidElement currentPassword;

    @AndroidFindBy(id = "com.olx.olx:id/new_password")
    private AndroidElement newPassword;

    @AndroidFindBy(id = "com.olx.olx:id/confirm_new_password")
    private AndroidElement confirmPassword;

    @AndroidFindBy(id = "com.olx.olx:id/save")
    private AndroidElement saveButton;

    @AndroidFindBy(id = "com.olx.olx:id/basic_info_txt_fullname")
    private AndroidElement nameText;

    @AndroidFindBy(id = "com.olx.olx:id/snackbar_text")
    private AndroidElement alertMessage;

    private String alertText;
    private String name;

    public ProfileWindow() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.androidDriver), this);
    }

    public void changeProfileInfo(String pass) {
        waitForElementToBeClickable(understoodButton);
        understoodButton.click();
        waitForVisibility(editButton);
        editButton.click();
        editName.replaceValue("");
        editName.sendKeys(ConfigLoader.getValueByKey("newName"));
        saveButton.click();
        waitForVisibility(editButton);
        name = nameText.getText();
        editButton.click();
        changePassword(pass);

    }

    private void changePassword(String pass) {
        editPassword.click();
        waitForVisibility(currentPassword);
        currentPassword.sendKeys(pass);
        newPassword.sendKeys(ConfigLoader.getValueByKey("pass2"));
        confirmPassword.sendKeys(ConfigLoader.getValueByKey("pass2"));
        saveButton.click();
        waitForVisibility(alertMessage);
        alertText = alertMessage.getText();
        System.out.println(alertText);

    }

    public String getName() {
        return name;
    }

    public String getAlert() {
        return alertText;
    }
}
