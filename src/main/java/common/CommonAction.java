
package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CommonAction {
    private WebDriver driver;
    private JavascriptExecutor js;
    private CommonWait wait;
    private Actions actions;
    private final static long TIMEOUT = 200;

    public CommonAction(WebDriver driver) {
        this.driver = driver;
        init();
    }

    private void init() {
        js = (JavascriptExecutor) driver;
        wait = new CommonWait(driver);
        actions = new Actions(driver);
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollToElement(By by) {
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
        sleep(TIMEOUT);
    }

    public void scrollToElement(WebElement ele) {
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        sleep(TIMEOUT);
    }

    public void scrollToElement(By by, int extraX, int extraY) {
        scrollToElement(by);
        js.executeScript("window.scrollBy(arguments[0],arguments[1])", extraX, extraY);
        sleep(TIMEOUT);
    }

    public void scrollToElement(WebElement ele, int extraX, int extraY) {
        scrollToElement(ele);
        js.executeScript("window.scrollBy(arguments[0],arguments[1])", extraX, extraY);
        sleep(TIMEOUT);
    }

    public void scrollWindow(int pixel) {
        js.executeScript("window.scrollBy(0,arguments[0])", pixel);
    }

    public void scrollWindow(int extraX, int extraY) {
        js.executeScript("window.scrollBy(arguments[0],arguments[1])", extraX, extraY);
        sleep(TIMEOUT);
    }

    public void refreshPage() {
        driver.navigate().refresh();
        wait.waitForPageLoad();
    }

    public void stopPageLoad() {
        js.executeScript("return window.stop");
    }

    public void goToSite(String url) {
        try {
            driver.navigate().to(url);
            wait.waitForPageLoad();
        } catch (TimeoutException ex) {
            wait.stopPageLoad();
        }

    }

    public void mouseClick(WebElement e) {
        actions.moveToElement(e);
        actions.click().build().perform();
    }

    public void mouseClick(WebElement e, int xOffSet, int yOffSet) {
        actions.moveToElement(e, xOffSet, yOffSet);
        actions.click().build().perform();
    }

    public void jsClick(WebElement ele) {
        js.executeScript("arguments[0].click();", ele);
    }

    public void mouseMove(WebElement we) {
        actions.moveToElement(we).build().perform();
    }
}
