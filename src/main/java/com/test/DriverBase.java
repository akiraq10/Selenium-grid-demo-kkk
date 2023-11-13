package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {
    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList((new ArrayList<DriverFactory>()));
    private static  ThreadLocal<DriverFactory> driverThread;
    @BeforeSuite(alwaysRun = true)
    public static void initWebDriverObject(){
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactory webDriverThread =new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }


    public static WebDriver getDriver() throws MalformedURLException {
        return driverThread.get().getDriver();
    }
    public static WebDriver getDriver(String browser) throws MalformedURLException {
        return driverThread.get().getDriver(browser);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        for(DriverFactory driver : webDriverThreadPool){
            driver.quitDriver();
        }
    }
}
