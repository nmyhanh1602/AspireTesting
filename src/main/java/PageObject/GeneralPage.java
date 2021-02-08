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
		//wait.waitForPageLoad();
		Link loginLink = new Link(driver, LoginUI.registerLink);
		loginLink.clickLink();
		wait.waitForPageLoad();
		return new RegisterPage(driver);
	}
	public String formatLocator(String locator,String... value){
		String formatLocator = String.format(locator,(Object[]) value);
		return formatLocator;
	}
}
