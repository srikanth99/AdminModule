package com.adminuat;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
/**
 * Created by Ahmad on 10/01/2015.
 */
public class Utils  extends BaseClass {
    public static int generateRandomNo()
    {
        Random r = new Random();
        int num = r.nextInt(1000) + 1;
        return num;
    }

    public static boolean isTextPresent(String text)
    {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public static void selectFromDropDownMenu(By element,String text)
    {
        Select select=new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }
}
