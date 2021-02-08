package PageObject;

import PageUI.BusinessUI;
import common.components.Button;
import org.openqa.selenium.WebDriver;

public class BusinessPage extends GeneralPage {
    public BusinessPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueWithOptionCompanyButton(String... values) {
        Button continueButton = new Button(driver, formatLocator(BusinessUI.continueRegisterBusinessButton, values));
        continueButton.getWebElement();
        continueButton.clickButton();
    }
}
