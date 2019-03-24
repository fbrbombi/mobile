package com.endava.windows;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAdsWindow extends BaseWindow {

    @AndroidFindBy(id = "com.olx.olx:id/wallet_onboarding_ok_button")
    private AndroidElement understoodButton;

    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/myads_item_title']")
    private List<WebElement> adsTitle;


    public MyAdsWindow() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);

    }

    public boolean isAnyAdEquals(String myAdName) {
        //waitForElementToBeClickable(understoodButton);
        //understoodButton.click();
        waitForVisibilityOfAllElements(adsTitle);
        for (WebElement element : adsTitle) {
            if (myAdName.equals(element.getText())) {
                return true;
            }
        }
        return false;
    }
}
