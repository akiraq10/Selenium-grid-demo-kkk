package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class test extends DriverBase {
    @Parameters({"browser"})
    @Test
    public void test1(String browser) throws MalformedURLException {
        WebDriver driver;
        driver= getDriver(browser);
        driver.get("https://google.com");
    }
    @Parameters({"browser"})
    @Test
    public void test2(String browser) throws MalformedURLException {
        WebDriver driver;
        driver= getDriver(browser);
        driver.get("https://google.com");
    }
}
