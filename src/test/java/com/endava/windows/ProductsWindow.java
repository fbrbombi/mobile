package com.endava.windows;

import com.endava.helper.DriverFactory;
import com.endava.utilites.Random;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsWindow extends BaseWindow {
    String firstTitle;
    @AndroidFindBy(id = "com.olx.olx:id/listing_button_filter")
    private AndroidElement filterButton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/home_main_container']")
    private List<AndroidElement> productList;
    @AndroidFindBy(id = "com.olx.olx:id/listing_recycler_ads")
    private AndroidElement productPage;
    @AndroidFindBy(id = "com.olx.olx:id/item_title")
    private AndroidElement productTitle;

    public ProductsWindow() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.androidDriver), this);

    }

    public void chooseAProduct() {
        closeFilterMessage();
        int idProduct = Random.generateRandomNumber(productList.size() - 1, 0);
        waitForVisibility(productPage);
        firstTitle = findSubElementById(productList.get(idProduct), "com.olx.olx:id/home_item_title").getText();
        productList.get(idProduct).click();
        System.out.println(firstTitle);
    }

    private void closeFilterMessage() {
        waitForVisibility(filterButton);
        filterButton.click();
    }

    public String getFisrtTitle() {
        return firstTitle;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
