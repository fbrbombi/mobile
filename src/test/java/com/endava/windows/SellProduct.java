package com.endava.windows;

import com.endava.helper.DriverFactory;
import com.endava.utilites.Random;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SellProduct extends BaseWindow {

    @AndroidFindBy(id = "com.olx.olx:id/main")
    private AndroidElement main;

    @AndroidFindBy(id = "com.olx.olx:id/take_photo")
    private AndroidElement takePhoto;

    @AndroidFindBy(id = "com.olx.olx:id/select_photos")
    private AndroidElement usePhoto;

    @AndroidFindBy(id = "com.olx.olx:id/posting_title")
    private AndroidElement titleAdd;

    @AndroidFindBy(id = "com.olx.olx:id/posting_title_button")
    private AndroidElement titleButton;

    @AndroidFindBy(id = "com.olx.olx:id/posting_price")
    private AndroidElement priceText;

    @AndroidFindBy(id = "com.olx.olx:id/posting_price_button")
    private AndroidElement priceButton;

    @AndroidFindBy(id = "com.olx.olx:id/categories_recycler_view")
    private AndroidElement categoryListView;

    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/category_name']")
    private List<AndroidElement> categoryList;

    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/subcategory_name']")
    private List<AndroidElement> subCategoryList;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][1]")
    private AndroidElement doneText;

    @AndroidFindBy(id = "com.olx.olx:id/see_my_ad")
    private AndroidElement seeMyAdd;

    @AndroidFindBy(id = "com.olx.olx:id/gallery_fragment")
    private AndroidElement miniGallery;

    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/gridTile']")
    private List<AndroidElement> pictureList;

    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/gridTile'][1]")
    private AndroidElement image;

    private String adTitle;

    public SellProduct() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.androidDriver), this);
    }

    public void sellProductFirstStep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> el = findElementsByUI("new UiSelector().className(\"android.widget.ImageView\")");
        //android.widget.ImageView
        if (el.isEmpty()) {
            System.out.println("Button not found");
            return;
        }
        System.out.println("tap Button");
        el.get(0).click();
        waitForVisibility(usePhoto);
        usePhoto.click();
    }

    public void sellProductSecondStep() {
        waitForVisibility(titleAdd);
        adTitle = Random.generateRandomString(7);
        titleAdd.sendKeys(adTitle);
        implicitWait(1);
        titleButton.click();
    }

    public void sellProductThirdStep() {
        waitForVisibility(priceText);
        priceText.sendKeys(Integer.toString(Random.generateRandomNumber(10000, 1000)));
        implicitWait(1);
        priceButton.click();
        selectsACategory();
        waitForVisibility(seeMyAdd);

    }

    public String getPostResponse() {
        return doneText.getText();
    }


    private void selectsACategory() {
        waitForVisibility(categoryListView);
        int id = Random.generateRandomNumber((categoryList.size() - 2), 2);
        categoryList.get(id).click();
        waitForVisibility(subCategoryList.get(0));
        id = Random.generateRandomNumber(subCategoryList.size() - 1, 0);
        subCategoryList.get(id).click();
    }


}
