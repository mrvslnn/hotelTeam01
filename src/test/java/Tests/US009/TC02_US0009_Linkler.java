package Tests.US009;

import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.Driver;

public class TC02_US0009_Linkler {

    @Test
    public void test2(){

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.concortHotelLogin();

        qaConcortPage.hotelManagementButton.click();
        qaConcortPage.hotelListButton.click();
        qaConcortPage.addHotelButton.click();

        Driver.closeDriver();

    }
}
