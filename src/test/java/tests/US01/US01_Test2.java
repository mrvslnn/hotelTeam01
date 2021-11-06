package tests.US01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US01Page.US01Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US01_Test2 {

    US01Page us01Page=new US01Page();
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        Assert.assertTrue(us01Page.navbarMenusu.isDisplayed());

    }
}