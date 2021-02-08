package PageObject;

import PageUI.RegisterUI;
import common.components.Button;
import common.components.CheckBox;
import common.components.TextBox;
import common.components.ComboBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends GeneralPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void inputFullName(String value) {
        TextBox fullNameTextBox = new TextBox(driver, RegisterUI.fullNameInput);
        fullNameTextBox.getWebElement();
        fullNameTextBox.enterValue(value);
    }

    public void inputEmail(String value) {
        TextBox emailTextBox = new TextBox(driver, RegisterUI.emailInput);
        emailTextBox.getWebElement();
        emailTextBox.enterValue(value);
    }

    public void inputPhone(String value) {
        TextBox phoneTextBox = new TextBox(driver, RegisterUI.phoneInput);
        phoneTextBox.getWebElement();
        phoneTextBox.enterValue(value);
    }

    public void checkedRole(String value) {
        CheckBox roleCheckBox = new CheckBox(driver, formatLocator(RegisterUI.roleInCompanyRadio, value));
        roleCheckBox.getWebElement();
        roleCheckBox.checkToCheckBox();
    }

    public void selectedWhereHereMe(String value) {
        ComboBox whereHereComboBox = new ComboBox(driver);
        whereHereComboBox.selectedComBoBox(RegisterUI.whereHereAboutUsInput, RegisterUI.whereHereAboutUsList, value);
    }

    public void inputPromoCode(String value) {
        TextBox promoTextBox = new TextBox(driver, RegisterUI.promoCodeInput);
        promoTextBox.enterValue(value);
    }

    public void checkedIAgree() {
        CheckBox iAgreeCheckBox = new CheckBox(driver, RegisterUI.iAgreeCheckbox);
        iAgreeCheckBox.checkToCheckBox();
    }

    public void clickContinueButton() {
        Button continueButton = new Button(driver, RegisterUI.continueButton);
        continueButton.clickButton();
    }

    public BusinessPage clickWoHooButton() {
        Button continueButton = new Button(driver, RegisterUI.woHooContinueButton);
        continueButton.clickButton();
        return new BusinessPage(driver);
    }

    public void inputOTP(){
        TextBox otp = new TextBox(driver);
        otp.inputOTP(RegisterUI.optListInput);
    }
}
