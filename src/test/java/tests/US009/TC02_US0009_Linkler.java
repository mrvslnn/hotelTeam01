package tests.US009;

import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC02_US0009_Linkler {

    @Test
    public void test2(){



        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage concortHotelPage = new QAConcortPage();

        concortHotelPage.ilkLoginButton.click();

        concortHotelPage.userNameBox.sendKeys("manager");

        concortHotelPage.passwordBox.sendKeys("Manager1!");
        concortHotelPage.ikinciLoginButton.click();

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.hotelManagementButton.click();
        qaConcortPage.hotelListButton.click();
        qaConcortPage.addHotelButton.click();

        Driver.closeDriver();

    }
}
