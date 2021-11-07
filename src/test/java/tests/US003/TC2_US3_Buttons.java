package Tests.US003;

import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.Driver;

public class TC2_US3_Buttons  {

    @Test
    public void test2() throws InterruptedException {

        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin();
        Thread.sleep(2000);
        qaConcortPage.buttonsClick();
        Driver.closeDriver();

    }
}
