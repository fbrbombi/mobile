package com.endava.windows;

import com.endava.helper.DriverFactory;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoriteWindow extends BaseWindow {

    @AndroidFindBy(id = "com.olx.olx:id/myfavorites_listview")
    private AndroidElement favoriteList;

    @AndroidFindBy(id = "com.olx.olx:id/wallet_onboarding_ok_button")
    private AndroidElement understoodButton;

    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/myfavorites_item_title']")
    private List<AndroidElement> favoriteListTitles;

    public FavoriteWindow() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.androidDriver), this);
    }

    public boolean isTheProductAdded(String productName) {
        waitForElementToBeClickable(understoodButton);
        understoodButton.click();
        waitForVisibility(favoriteList);
        for (AndroidElement favoriteListTitle : favoriteListTitles) {
            if (favoriteListTitle.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }


}
