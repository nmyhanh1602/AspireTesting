package PageObject;

import PageUI.LoginUI;
import common.CommonAction;
import common.CommonWait;
import common.components.Label;
import common.components.Link;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GeneralPage {
	protected WebDriver driver;
	protected CommonWait wait;
	protected CommonAction action;

	public GeneralPage(WebDriver driver) {
		this.driver = driver;
		wait = new CommonWait(driver);
    	action = new CommonAction(driver);
	}

	public RegisterPage goToRegisterPage() {
		Link loginLink = new Link(driver, LoginUI.registerLink);
		wait.waitUntilToBeClickAble(loginLink.getWebElement());
		loginLink.clickLink();
		wait.waitForPageLoad();
		return new RegisterPage(driver);
	}
}
