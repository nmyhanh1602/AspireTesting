package common.components;

import PageUI.RegisterUI;
import common.CommonWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBox extends Component {
    public TextBox(WebDriver driver, String locator) {
        super(driver, locator);
    }

    public TextBox(WebDriver driver) {
        super(driver);
    }

    CommonWait wait = new CommonWait(driver);

    public void enterValue(String value) {
        if (value != null)
            enter(value);
    }

    public void pressEnter() {
        pressKey(Keys.ENTER);

    }

    public void inputOTP(String optLocatorList) {
        WebElement otpTitle = getWebElement(RegisterUI.pleaseInputOTPTitle);
        wait.waitUntilVisibilityOf(otpTitle);
        List<WebElement> otpList;
        otpList = getWebElements(optLocatorList);
        for (int i = 0; i < otpList.size(); i++) {
            int num = i + 1;
            switch (num){
                case 1: sendKeys(Keys.NUMPAD1);
                case 2: sendKeys(Keys.NUMPAD2);
                case 3: sendKeys(Keys.NUMPAD3);
                case 4: sendKeys(Keys.NUMPAD4);
            }
        }
    }

    public void enterValue(int value) {
        enter(value);
    }
}
