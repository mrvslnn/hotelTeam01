package Tests.US006;

import org.testng.annotations.Test;
import pages.US006_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC001 {
    pages.US006_Page.QAConcortPage qaConcortPage;

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
        qaConcortPage.roomId.sendKeys("15");
        qaConcortPage.roomSearch.click();

    }
}