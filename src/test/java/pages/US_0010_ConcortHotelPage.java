package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_0010_ConcortHotelPage {
    public US_0010_ConcortHotelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Log in")
    public WebElement LoginLinki;
    @FindBy(id="UserName")
    public WebElement usernameBox;
    @FindBy(id="Password")
    public WebElement passwordBox;
    @FindBy(id="btnSubmit")
    public WebElement LoginButonu;
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementButonu;
    @FindBy(xpath ="/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[2]/a")
    public WebElement HotelRoomsButonu;
    @FindBy(xpath ="//span[text()='List Of Hotelrooms']" )
    public WebElement ListOfHotelRoomsYazisi;
    @FindBy(id="lkpHotels")
    public WebElement IDHotelDropDownu;
    @FindBy(id="lkpGroupRoomTypes")
    public WebElement IDGroupRoomTypeDropDownu;
    @FindBy(xpath ="(//select[@class='form-control form-filter input-sm'])[3]")
    public WebElement IsAvailableDropDownu;
    @FindBy(className = "margin-bottom-5")
    public WebElement ListofHotelRoomsSearchButonu;
    @FindBy(xpath = "(//button[@class= 'btn btn-sm red filter-cancel'])")
    public WebElement ListofHotelRoomsClearButonu;



}
