package tests.US005;

import org.testng.annotations.Test;
import pages.US005_Page.US_005_QAConcortHotelPage;
import utilities.Driver;

public class TC2_US5_CreateHotel {
    @Test
    public void RoomCreateTest() throws InterruptedException {

        US_005_QAConcortHotelPage US005QaConcortHotelPage = new US_005_QAConcortHotelPage();
        US005QaConcortHotelPage.ConcortHotelLogin();

        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        US005QaConcortHotelPage.hotelManagementLinki.click();
        US005QaConcortHotelPage.hotelListLink.click();
        US005QaConcortHotelPage.addHotelLink.click();
        Driver.closeDriver();


    }
}
