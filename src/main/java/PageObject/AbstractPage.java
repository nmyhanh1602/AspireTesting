package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    private static final int TIMEOUT_INTERVAL_UNIT = 30;
    private WebDriver driver;
    private String locator;
    private By by;
    private WebElement webElement;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    protected void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }
    public AbstractPage(){

    }
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
        this.js = ((JavascriptExecutor) driver);
    }

    public AbstractPage(WebDriver driver, String locator) {
        this.driver = driver;
        this.locator = locator;
        wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
        js = ((JavascriptExecutor) driver);
    }

    /*
     *  init components
     */

    public By getBy(String locator) {
        if (locator.startsWith("css="))
            return By.cssSelector(locator.substring(4));
        else if (locator.startsWith("xpath="))
            return By.xpath(locator.substring(6));
        else if (locator.startsWith("id="))
            return By.id(locator.substring(3));
        return null;
    }

    public WebElement getWebElement() {
        webElement = this.driver.findElement(by);
        return webElement;
    }

    public WebElement getWebElement(String locator) {
        this.by = getBy(locator);
        return getWebElement();
    }
    public void waitUntilVisibilityOf(WebElement element) throws TimeoutException {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Wait until element displayed and clickable
     *
     * @param element element to be checked
     * @throws TimeoutException
     */

    public void waitUntilToBeClickAble(WebElement element) throws TimeoutException {
        waitUntilVisibilityOf(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void click() throws WebDriverException {
        getWebElement();
        webElement.click();
    }

    public void click(String locator) {
        getWebElement(locator);
        webElement.click();
    }
    public void waitForPageLoadCompleted() {
        waitForPageLoad(TIMEOUT_INTERVAL_UNIT);
    }

    /**
     * Wait until the page is fully loaded
     *
     * @param timeout
     */

    public void waitForPageLoad(int timeout) throws TimeoutException {
        new WebDriverWait(driver, timeout).until((ExpectedCondition<Boolean>)
                d -> js.executeScript("return document.readyState").toString().equals("complete"));
    }
    public void stopPageLoad() {
        js.executeScript("return window.jsErrors");
        js.executeScript("return window.stop");
    }
    public void clickLink(String locator) {
        try {
            waitUntilToBeClickAble(getWebElement(locator));
            click(locator);
            waitForPageLoadCompleted();
        } catch (TimeoutException ex) {
            stopPageLoad();
        }

    }
    public void sendKeys(String locator, String value) {
        getWebElement(locator);
        webElement.clear();
        webElement.sendKeys(value);
    }

}
