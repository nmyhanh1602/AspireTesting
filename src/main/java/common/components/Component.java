package common.components;

import com.google.inject.internal.cglib.core.$CodeGenerationException;
import common.CommonWait;
import org.openqa.selenium.*;

import java.util.List;

public abstract class Component {
    protected WebDriver driver;
    private String locator;
    private By by;
    private WebElement webElement;


    public Component(WebDriver driver) {
        this.driver = driver;
    }

    public Component(WebDriver driver, String locator) {
        this.driver = driver;
        this.locator = locator;
        by = getBy();
    }

    public By getBy() {
        if (locator.startsWith("css="))
            return By.cssSelector(locator.substring(4));
        else if (locator.startsWith("xpath="))
            return By.xpath(locator.substring(6));
        else if (locator.startsWith("id="))
            return By.id(locator.substring(3));
        return null;
    }

    public By getBy(String locator) {
        this.locator = locator;
        return getBy();
    }

    public WebElement getWebElement() {
        int sleepTime = 200;
        int timeout = 10000;
        int runTime = 0;
        while (true && webElement == null){
            runTime += sleepTime;
            try {
                webElement = driver.findElement(by);
                if ((webElement != null && webElement.isDisplayed()) || runTime > timeout){
                    break;
                }
                sleep(sleepTime);
            } catch (NoSuchElementException ex){
            }

        }
        return webElement;
    }

    public WebElement getWebElement(String locator) {
        by = getBy(locator);
        return getWebElement();
    }

    public List<WebElement> getWebElements() {
        return driver.findElements(by);
    }

    public List<WebElement> getWebElements(String locator) {
        by = getBy(locator);
        return driver.findElements(by);
    }

    public void refresh() {
        by = getBy();
    }

    public void click() {
        getWebElement();
        webElement.click();
    }

    public void click(String locator) {
        getWebElement(locator);
        webElement.click();
    }
    public void click(WebElement element) {
        getWebElement(locator);
        webElement.click();
    }

    public String getText() {
        getWebElement();
        return webElement.getText();
    }

    public String getText(String locator) {
        getWebElement(locator);
        return webElement.getText();
    }

    public String getValue() {
        getWebElement();
        return webElement.getAttribute("value");
    }

    public void enter(String value) {
        getWebElement();
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void enter(int value) {
        enter(String.valueOf(value));
    }

    protected void sendKeys(CharSequence... keysToSend) {
        driver.switchTo().activeElement().sendKeys(keysToSend);
    }

    public void pressKey(Keys key) {
        getWebElement();
        webElement.sendKeys(key);
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void setLocator(String locator) {
        this.locator = locator;
        by = getBy();
    }

    public String getLocator() {
        return locator;
    }

}
