package Tests.US005;

import org.testng.annotations.Test;
import pages.US005_Page.US_005_QAConcortHotelPage;

public class TC1_US5_CreateHotel {
    @Test
    public void RoomCreateTest() throws InterruptedException {

        US_005_QAConcortHotelPage US005QaConcortHotelPage = new US_005_QAConcortHotelPage();
        US005QaConcortHotelPage.ConcortHotelLogin();


    }
}
