package com.endava.helper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    protected static AndroidDriver androidDriver;
    protected static WebDriverWait androidDriverWait;

    public static void generateDriver(DriverType type) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", ConfigLoader.getValueByKey("path"));
        desiredCapabilities.setCapability("deviceName", ConfigLoader.getValueByKey("deviceName"));
        desiredCapabilities.setCapability("compressXml", "true");
        // desiredCapabilities.setCapability("automationName","uiautomator2");
        String url = "";
        switch (type) {
            case EMULATOR:
                desiredCapabilities.setCapability("udid", ConfigLoader.getValueByKey("udidem"));
                url = ConfigLoader.getValueByKey("URL");
                break;
            case PHONE:
                desiredCapabilities.setCapability("udid", ConfigLoader.getValueByKey("udid"));
                url = ConfigLoader.getValueByKey("URL");

                break;
            case SAUCE:
                desiredCapabilities.setCapability("platformName", ConfigLoader.getValueByKey("platformName"));
                desiredCapabilities.setCapability("platformVersion", ConfigLoader.getValueByKey("platformVersion"));
                desiredCapabilities.setCapability("deviceName", ConfigLoader.getValueByKey("deviceName"));
                desiredCapabilities.setCapability("phoneOnly", "false");
                desiredCapabilities.setCapability("tabletOnly", "false");
                desiredCapabilities.setCapability("privateDevicesOnly", "false");
                desiredCapabilities.setCapability("testobject_api_key", ConfigLoader.getValueByKey("api_key"));
                desiredCapabilities.setCapability("testobject_app_id", "1");

                url = ConfigLoader.getValueByKey("URL3");

                break;
        }
        try {
            androidDriver = new AndroidDriver<MobileElement>(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        androidDriverWait = new WebDriverWait(androidDriver, 20);
    }

    public enum DriverType {
        SAUCE,
        PHONE,
        EMULATOR
    }

}
