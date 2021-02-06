package common.components;

import common.CommonWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class Link extends Component {

    public Link(WebDriver driver, String locator) {
        super(driver, locator);
    }

    public Link(WebDriver driver) {
        super(driver);
    }

    public void clickLink() {
    	CommonWait wait = new CommonWait(driver);
        try {
        	wait.waitUntilToBeClickAble(getWebElement());
            click();
            wait.waitForPageLoad();
        } catch (TimeoutException ex) {
            wait.stopPageLoad();
        }

    }
}
