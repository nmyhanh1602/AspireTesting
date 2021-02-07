package RegisterScenario;

import PageObject.GeneralPage;
import PageObject.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTestcase extends AbstractTest {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeClass

    @Test
    public void TC_01_RegisterWithValidInfo() {
        this.registerPage = generalPage.goToRegisterPage();
        this.registerPage.register();
    }
}
