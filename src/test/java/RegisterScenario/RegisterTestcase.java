package RegisterScenario;

import Data.DataTesting;
import PageObject.BusinessPage;
import PageObject.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTestcase extends AbstractTest {
    WebDriver driver;
    RegisterPage registerPage;
    BusinessPage businessPage;

    @BeforeClass

    @Test
    public void TC_01_RegisterWithValidInfo() {
        String fullName = DataTesting.getRandomFullName();
        String email = DataTesting.getRandomEmail();
        String phone = DataTesting.getRandomNumber();
        String role = "Appointed director";
        String whereHereMe = "Facebook";
        String promoCode ="123456";
        this.registerPage = generalPage.goToRegisterPage();
        this.registerPage.inputFullName(fullName);
        this.registerPage.inputEmail(email);
        this.registerPage.inputPhone(phone);
        this.registerPage.checkedRole(role);
        this.registerPage.selectedWhereHereMe(whereHereMe);
        //this.registerPage.inputPromoCode(promoCode);
        this.registerPage.checkedIAgree();
        this.registerPage.clickContinueButton();

        this.registerPage.inputOTP();
        businessPage = this.registerPage.clickWoHooButton();
        this.businessPage.clickContinueWithOptionCompanyButton("Yes, my business is registered in Singapore with ACRA","Continue");

    }
}
