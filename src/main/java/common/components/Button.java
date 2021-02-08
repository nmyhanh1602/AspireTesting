package common.components;

import common.CommonWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Button extends Component {

    public Button(WebDriver driver, String locator) {
        super(driver, locator);
    }

    public Button(WebDriver driver) {
        super(driver);
    }

    CommonWait wait = new CommonWait(driver);

    public void clickButton() throws WebDriverException {
        WebElement element = getWebElement();
        wait.waitUntilToBeClickAble(element);
        click();
    }
}
