package com.adminuat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ahmad on 10/01/2015.
 */
public class BaseTest  extends BaseClass {
    @BeforeClass
    public static void setup()
    {
       driver= new FirefoxDriver();
        driver.get("http://insoftt.trial47.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void stopBrowser()
    {
        driver.quit();
    }


}
