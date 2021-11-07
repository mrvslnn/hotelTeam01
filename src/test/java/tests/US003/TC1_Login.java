package tests.US003;

import org.testng.annotations.Test;
import pages.US003_Page.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC1_Login {
    @Test
    public void test1() {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginButton.click();
        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.ikinciLoginButton.click();
        Driver.closeDriver();
    }
}
