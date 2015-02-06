package com.adminuat;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Ahmad on 10/01/2015.
 */
public class RegressionTestSuite extends BaseTest {
    //--------------------------Test Data------------------------------
    String adminUsername="admin", adminPassword="Insoft12";
    String empUname="EmpName"+Utils.generateRandomNo();
    String empPassword="Password12";
    String empFname="Employee",empLname="EmpLastName";

    BusinessLibrary blib = new BusinessLibrary();

    @Test

    public void empAddSupervisor()
    {
        blib.login(adminUsername,adminPassword); //Admin Login
        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        blib.adminCreateEmpLoginDetails(empFname, empLname, empUname, empPassword);
        Assert.assertEquals(empFname + " " + empLname, driver.findElement(By.cssSelector("h1")).getText());
        blib.adminAddSubordinates(empFname,empLname);
        //Assert.assertEquals(empFname + " " + empLname, driver.findElement(By.linkText("Employee One")).getText());
        blib.logout();
        blib.login(empUname,empPassword);
        blib.employeeCheckSupervisor();
        Assert.assertEquals("Bushra Farheen", driver.findElement(By.cssSelector("td.supName")).getText());
    }


}
