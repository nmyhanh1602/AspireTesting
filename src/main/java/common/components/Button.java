package common.components;

import common.CommonWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Button extends Component {

    public Button(WebDriver driver, String locator) {
        super(driver, locator);
    }

    public Button(WebDriver driver) {
        super(driver);
    }

    public void clickButton() throws WebDriverException {
        CommonWait waitU;
        waitU = new CommonWait(driver);
        try {
            click();
            waitU.waitForPageLoad();
        } catch (TimeoutException ex) {
            waitU.stopPageLoad();
        }

    }
}
