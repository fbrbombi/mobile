package com.endava.steps;

import com.endava.windows.OlxFacade;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class OlxSteps {
    protected AndroidDriver androidDriver;

    @Before
    public void setup() {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("app",new File("C:\\Users\\fbombiela\\Desktop" +
                "\\MobileChallenge1\\com.olx.olx_52505_apps.evozi.com.apk").getAbsolutePath());
        desiredCapabilities.setCapability("udid","7f2dde790604");
        desiredCapabilities.setCapability("deviceName","Nexus 6 API 28");
        try {
            androidDriver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        olxFacade=new OlxFacade(androidDriver);
    }

    @After

    public void after(){
        //androidDriver.quit();
    }



    private OlxFacade olxFacade;

    @Given("^the user has an email$")
    public void theUserHasAnEmail() {
        olxFacade.goToMainWindow();
    }

    @When("^the user wants to login$")
    public void theUserWantsToLogin() {
    }

    @Then("^The service should verificate the email$")
    public void theServiceShouldVerificateTheEmail() {

    }
}
