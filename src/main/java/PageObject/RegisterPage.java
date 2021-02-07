package PageObject;

import PageUI.RegisterUI;
import common.components.TextBox;
import javafx.scene.control.ComboBox;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class RegisterPage extends GeneralPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(){
        wait.waitForPageLoad();
        TextBox fullNameTextBox = new TextBox(driver, RegisterUI.fullNameInput);
        TextBox emailTextBox = new TextBox(driver, RegisterUI.emailInput);
        TextBox phoneTextBox = new TextBox(driver, RegisterUI.phoneInput);
        //RegisterUI.roleInCompanyRadio = String.format(RegisterUI.roleInCompanyRadio,"Appointed director");
        Checkbox roleCheckBox = new Checkbox(driver, String.format(RegisterUI.roleInCompanyRadio,"Appointed director"));
        fullNameTextBox.getWebElement();
        fullNameTextBox.enterValue("Hanh");
        emailTextBox.getWebElement();
        emailTextBox.enterValue("ntmhanh123@hotmail.com");
        phoneTextBox.getWebElement();
        phoneTextBox.enterValue("00112233");
        roleTextBox.getWebElement();
       roleTextBox.click();
        return;


    }

}
