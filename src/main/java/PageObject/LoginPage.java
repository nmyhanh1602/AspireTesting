package PageObject;

import PageUI.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}