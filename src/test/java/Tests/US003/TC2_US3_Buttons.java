package Tests.US003;

import org.testng.annotations.Test;

public class TC2_US3_Buttons {

    @Test
    public void test2(){

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.concortHotelLogin();

        qaConcortPage.hotelManagementButton.click();
        qaConcortPage.hotelListButton.click();
        qaConcortPage.addHotelButton.click();

    }
}
