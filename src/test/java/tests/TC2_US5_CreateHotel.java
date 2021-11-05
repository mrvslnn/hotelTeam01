package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_005_QAConcortHotelPage;
import utilities.ConfigReader;
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


    }
}
