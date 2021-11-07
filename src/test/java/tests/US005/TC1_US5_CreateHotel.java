package tests.US005;

import org.testng.annotations.Test;
import pages.US005_Page.US_005_QAConcortHotelPage;
import utilities.TestBaseRapor;

public class TC1_US5_CreateHotel extends TestBaseRapor {
    @Test
    public void RoomCreateTest() throws InterruptedException {
        extentTest=extentReports.createTest("Login Methodundan sayfalar cekildi ");

        US_005_QAConcortHotelPage US005QaConcortHotelPage = new US_005_QAConcortHotelPage();
        US005QaConcortHotelPage.ConcortHotelLogin();

        extentTest.info("Başarılı şekilde bigiler cekildi");


    }
}
