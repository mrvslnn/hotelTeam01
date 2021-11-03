package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    // abstract yaparak bu classtan obje uretilmesinin onune geceriz

    // Bir testBase classi sadece extends ile inherit ederek kullanacagiz
    //Dolayisiyala olusturdugumuz driver veriablesi icin protected acces modifieri seciyoruz.


    @BeforeClass
    public void setup (){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);


    }
    @AfterClass
    public void tearDown() {
       //driver.quit();
    }


}
