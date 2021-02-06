package PageObject;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends GeneralPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    protected void register(String locator){
        goToRegisterPage();
    }

}
