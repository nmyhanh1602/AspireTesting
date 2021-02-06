package RegisterScenario;

import PageObject.LoginPage;
import PageObject.RegisterPage;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTestcase extends AbstractTest {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeClass

    @Test
    public void startBrowser(){
       // this.driver.get("https://feature-qa.customer-frontend.staging.aspireapp.com/sg/");
       // registerPage.goToRegisterPage();
    }
}
