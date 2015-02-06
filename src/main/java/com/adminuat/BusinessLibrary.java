package com.adminuat;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by Ahmad on 10/01/2015.
 */
public class BusinessLibrary extends BaseClass {
    public String empid;
    //Login Method
    public void login(String username,String password)
    {
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
    }

    //Logout Method
    public void logout()
    {
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    public void adminCreateEmpLoginDetails(String fname,String lname,String uname,String upassword) {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lname);

        empid = driver.findElement(By.id("employeeId")).getAttribute("value"); //Get the emp id
        System.out.println("Emp id is" + empid);

        driver.findElement(By.id("chkLogin")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("user_name")).clear();
        driver.findElement(By.id("user_name")).sendKeys(uname);
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(upassword);
        driver.findElement(By.id("re_password")).sendKeys(upassword);
        new Select(driver.findElement(By.id("location"))).selectByVisibleText("ASC_London");
        driver.findElement(By.id("btnSave")).click();
       // Assert.assertEquals(fname + " " + lname, driver.findElement(By.cssSelector("h1")).getText());
    }

    public void adminAddSubordinates(String fname, String lname)
    {
        driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).click();
        driver.findElement(By.id("empsearch_id")).clear();
        driver.findElement(By.id("empsearch_id")).sendKeys("0181");
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.linkText("0181")).click();
        driver.findElement(By.linkText("Report-to")).click();
        driver.findElement(By.id("btnAddSubordinateDetail")).click();
        driver.findElement(By.id("reportto_subordinateName_empName")).clear();
        driver.findElement(By.id("reportto_subordinateName_empName")).sendKeys(fname + " " + lname);
        new Select(driver.findElement(By.id("reportto_reportingMethodType"))).selectByVisibleText("Direct");
        driver.findElement(By.id("btnSaveReportTo")).click();
        //Assert.assertEquals("Employee One", driver.findElement(By.linkText("Employee One")).getText());

    }

    public void employeeCheckSupervisor()
    {
        driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b")).click();
        driver.findElement(By.linkText("Report-to")).click();
        //Assert.assertEquals("Bushra Farheen", driver.findElement(By.cssSelector("td.supName")).getText());

    }



}
