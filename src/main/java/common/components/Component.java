package common.components;

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

	/*
	 *  init components
	 */

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
        webElement = driver.findElement(by);
        return webElement;
    }

    public WebElement getWebElement(String locator) {
        by = getBy(locator);
        return getWebElement();
    }

    public List<WebElement> getWebElements() {
        return driver.findElements(by);
    }
	
	/*
	 *  Actions
	 */

    public void refresh() {
        by = getBy();
    }

    public void click() throws WebDriverException {
        getWebElement();
        webElement.click();
    }

    public void click(String locator) {
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

    public String getInnerText() {
        getWebElement();
        return webElement.getAttribute("innerText");
    }

    public String getAttribute(String attribute) {
        getWebElement();
        return webElement.getAttribute(attribute);
    }

    public void enter(String value) {
        getWebElement();
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void enter(int value) {
        enter(String.valueOf(value));
    }

    public void pressKey(Keys key) {
        getWebElement();
        webElement.sendKeys(key);
    }

    public boolean isChecked() {
        getWebElement();
        return webElement.isSelected();
    }

    public int getSize() {
        return driver.findElements(by).size();
    }

    public boolean isPresent() {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isDisplay() {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
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
