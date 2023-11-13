package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private WebDriver webDriver;
    //Singleton Design Pattern
    WebDriver getDriver() throws MalformedURLException {
        if(webDriver == null){
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");

            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/"),
                    capabilities);
            return webDriver;


        }
        return webDriver;
    }
    WebDriver getDriver(String browserName) throws MalformedURLException {
        if(webDriver == null){

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if(browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                capabilities.setCapability("browserName", browserName);
            }else {
                WebDriverManager.firefoxdriver().setup();
                capabilities.setCapability("browserName",browserName);
            }

            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/"),
                    capabilities);
            return webDriver;


        }
        return webDriver;
    }
    void quitDriver(){
        if (webDriver !=null){
            webDriver.quit();
            webDriver =null;
        }
    }
}
