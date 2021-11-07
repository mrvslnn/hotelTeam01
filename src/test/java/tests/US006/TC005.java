package tests.US006;

import org.testng.annotations.Test;
import pages.US006_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC005 {
    QAConcortPage qaConcortPage;

    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        qaConcortPage =new QAConcortPage();
        qaConcortPage.login.click();
        qaConcortPage.username.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelRooms.click();
        qaConcortPage.roomPrice.sendKeys("700");
        qaConcortPage.roomSearch.click();

    }
}