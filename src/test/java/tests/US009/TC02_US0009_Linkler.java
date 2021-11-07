package Tests.US009;

import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.Driver;

public class TC02_US0009_Linkler {

    @Test
    public void test2() throws InterruptedException {

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin();
        Thread.sleep(2000);
        qaConcortPage.buttonsClick();
        Driver.closeDriver();

    }
}
