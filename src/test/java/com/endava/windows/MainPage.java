package com.endava.windows;

import com.endava.helper.DriverFactory;
import com.endava.utilites.Random;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BaseWindow {

    String homePageTitle;
    @AndroidFindBy(id = "com.olx.olx:id/activity_overlay_fragment_layout")
    private AndroidElement gotItButton;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
    private AndroidElement menuButton;
    @AndroidFindBy(id = "com.olx.olx:id/app_drawer")
    private AndroidElement menuList;
    @AndroidFindBy(id = "com.olx.olx:id/drawer_my_profile")
    private AndroidElement profileButton;
    @AndroidFindBy(id = "com.olx.olx:id/drawer_my_ads")
    private AndroidElement myAdsButton;
    @AndroidFindBy(xpath = "//*[ @resource-id='com.olx.olx:id/category_image']")
    private List<AndroidElement> homeCategories;
    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/items']//*[@class='android.widget.LinearLayout']")
    private List<AndroidElement> subCategories;
    @AndroidFindBy(id = "com.olx.olx:id/items")
    private AndroidElement subCategoriesList;
    @AndroidFindBy(xpath = "//*[@resource-id='com.olx.olx:id/home_main_container']")
    private List<AndroidElement> homePageProducts;
    @AndroidFindBy(id = "com.olx.olx:id/menu_favorite")
    private AndroidElement favoriteButton;
    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    private AndroidElement backButton;
    @AndroidFindBy(id = "com.olx.olx:id/drawer_my_favs")
    private AndroidElement goToFavoritePageButton;
    @AndroidFindBy(id = "com.olx.olx:id/fab_posting_masonry_home")
    private AndroidElement sellProduct;

    public MainPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.androidDriver), this);
    }

    public void goToProfileInfo() {
        closeGotItButton();
        menuButton.click();
        waitForVisibility(menuList);
        profileButton.click();
    }

    private void closeGotItButton() {
        waitForVisibility(gotItButton);
        gotItButton.click();
    }

    public void chooseHomeCategory() {
        closeGotItButton();
        homeCategories.get(Random.generateRandomNumber(homeCategories.size() - 1, 0)).click();
    }

    public void chooseSubCategory() {
        waitForVisibility(subCategoriesList);
        subCategories.get(Random.generateRandomNumber(subCategories.size() - 1, 0)).click();
    }

    public void chooseAProduct() {
        closeGotItButton();
        int id = Random.generateRandomNumber(subCategories.size() - 1, 0);
        homePageTitle = findSubElementById(homePageProducts.get(id), "com.olx.olx:id/home_item_title").getText();
        homePageProducts.get(id).click();
    }

    public void addToFavoriteList() {
        waitForVisibility(favoriteButton);
        favoriteButton.click();
        goBack();
    }

    public void goToFavoriteList() {
        waitForVisibility(menuButton);
        menuButton.click();
        waitForVisibility(menuList);
        goToFavoritePageButton.click();
    }

    public String getHomePageTitle() {
        return homePageTitle;
    }

    public void goToPublishSteps() {
        closeGotItButton();
        sellProduct.click();
        androidDriver.switchTo().activeElement();
    }


}
