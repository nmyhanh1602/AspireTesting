package common.components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TextBox extends Component {
    public TextBox(WebDriver driver, String locator) {
        super(driver, locator);
    }

    public TextBox(WebDriver driver) {
        super(driver);
    }

    public void enterValue(String value) {
        if (value != null)
            enter(value);
    }

    public void pressEnter() {
        pressKey(Keys.ENTER);

    }

    public void enterValue(int value) {
        enter(value);
    }
}
