package common.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends Component {
    private WebElement element;

    public CheckBox(WebDriver driver, String locator) {
        super(driver, locator);
    }

    public CheckBox(WebDriver driver) {
        super(driver);
    }

    public void checkToCheckBox() {
        element = getWebElement();
        if (!element.isSelected()) {
            element.click();
        }
    }
}
