package pages.US008_Page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class US_008_QAConcortHotelPage {


    public US_008_QAConcortHotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //===================================================//

    @FindBy(id="UserName")
    public WebElement usernameKutusu;

    @FindBy(id="Password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "(//*[text()='Log in'])[2]")
    public WebElement pLoginTusu;

    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement pSelectUser;

    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement pSelectHotelRoom;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement pPrice;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[1]")
    public WebElement pDateStartTakvim;

    @FindBy(xpath = "(//i[@class='fa fa-angle-right'])[3]")
    public WebElement pTakvimSagOk;

    @FindBy(xpath = "(//td[@class='day'])[20]")
    public WebElement pStartDay;

    @FindBy(xpath = "(//td[@class='day'])[25]")
    public WebElement pEndDay;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[2]")
    public WebElement pDateEndTakvim;

    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement pAdultAmount;

    @FindBy(xpath = "//input[@id='ChildrenAmount']")
    public WebElement pChildrenAmount;

    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement pContactNameSurname;

    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement pContactPhone;

    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement pContactEmail;

    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement pNotes;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement pSave;

    @FindBy(className = "bootbox-body")
    public WebElement pBasariliYazisiElementi;






    //===================================================//


}
