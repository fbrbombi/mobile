package com.endava.steps;


import com.endava.helper.ConfigLoader;
import com.endava.helper.DriverFactory;
import com.endava.utilites.Random;
import com.endava.windows.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class OlxSteps {
    private LoginWindow loginWindow;
    private ProfileWindow profileWindow;
    private MainPage mainPage;
    private ProductsWindow productsWindow;
    private FavoriteWindow favoriteWindow;
    private SellProduct sellProduct;

    private String pass;

    @Before
    public void setup() {
        DriverFactory.generateDriver(DriverFactory.DriverType.PHONE);
    }

    @Given("^the user has set a location$")
    public void theUserHasSetALocation() {
        loginWindow = new LoginWindow();
        loginWindow.addLocation();
    }


    @And("^the user is logged in with long password$")
    public void theUserIsLoggedIn() {
        pass = Random.generateRandomString(14);
        loginWindow.goToLoginScreen(Random.generateRandomString(5) + "@mail.com", pass);

    }


    @Given("^the user is in the main screen$")
    public void theUserIsInTheMainScreen() {
        mainPage = new MainPage();


    }

    @When("^the user wants to change the profile info$")
    public void theUserWantsToChangeTheProfileInfo() {
        mainPage.goToProfileInfo();
        profileWindow = new ProfileWindow();
        profileWindow.changeProfileInfo(pass);
    }

    @Then("^The service should change the info$")
    public void theServiceShouldChangeTheInfo() {
        assertThat("The user changes its name", profileWindow.getName(), equalTo(ConfigLoader.getValueByKey("newName")));
        assertThat("The user changes its password", profileWindow.getAlert(), equalTo("Tu contraseña se actualizó exitosamente"));
    }


    @Given("^the user selects a category$")
    public void theUserSelectsACategory() {
        mainPage.chooseHomeCategory();
    }

    @And("^the user selects a subcategory$")
    public void theUserSelectsASubcategory() {
        mainPage.chooseSubCategory();
        productsWindow = new ProductsWindow();

    }

    @When("^the user wants to choose a product$")
    public void theUserWantsToChooseAProduct() {
        productsWindow.chooseAProduct();
    }

    @Then("^The product is displayed$")
    public void theProductIsDisplayed() {
        assertThat("The user find a product", productsWindow.getFisrtTitle(), equalTo(productsWindow.getProductTitle()));

    }

    @Given("^the user selects a product from the main page$")
    public void theUserSelectsAProductFromTheMainPage() {
        mainPage.chooseAProduct();

    }

    @When("^the user add the product to the favourite list$")
    public void theUserAddTheProductToTheFavouriteList() {
        mainPage.addToFavoriteList();
    }

    @Then("^The product is displayed on the favourite list$")
    public void theProductIsDisplayedOnTheFavouriteList() {
        String initialTitle = mainPage.getHomePageTitle();
        mainPage.goToFavoriteList();
        favoriteWindow = new FavoriteWindow();
        boolean response = favoriteWindow.isTheProductAdded(initialTitle);
        assertThat("The user add to the favorite List", response, equalTo(true));

    }

    @And("^the user has a picture of the product$")
    public void theUserHasAPictureOfTheProduct() {
        loginWindow.addImage();
    }

    @Given("^the user is in sell-product's steps$")
    public void theUserIsInSellProductSSteps() {
        mainPage.goToPublishSteps();
        sellProduct = new SellProduct();

    }

    @When("^the user wants to publish a product$")
    public void theUserWantsToPublishAProduct() {
        sellProduct.sellProductFirstStep();
        sellProduct.sellProductSecondStep();
        sellProduct.sellProductThirdStep();
    }


    @Then("^A new product is published$")
    public void aNewProductIsPublished() {
        assertThat("The user add a new Post", sellProduct.getPostResponse(), equalTo("Done!"));
    }


    @Given("^the user is logged in with short password$")
    public void theUserIsLoggedInWithShortPassword() {
        pass = Random.generateRandomString(5);
        loginWindow.goToLoginScreen(Random.generateRandomString(5) + "@mail.com", pass);
    }
}
