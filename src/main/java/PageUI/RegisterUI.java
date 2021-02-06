package PageUI;

public class RegisterUI {
    public static final String fullNameInput = "//input[@name='full_name']";
    public static final String emailInput = "//input[@name='email']";
    public static final String roleInCompanyRadio = "//div[text()='%s']";
    public static final String whereHereAboutUsInput = "//input[@type='search']";
    public static final String promoCodeInput = "//input[@data-cy='register-person-referral-code']";
    public static final String iAgreeCheckbox = "//div[contains(@class,'register-step-person__privacy')]";
    public static final String continueButton = "//button[@type='submit']";
    public static final String accountExistPopup = "//div[@class='q-card' and .//*[normalize-space(text())='Account exists, try login instead!']]";
    public static final String loginInPopupButton = "//div[@class='q-mb-xl']//span[@class='q-focus-helper']";
    public static final String optListInput = "//div[contains(@class,'digit-input__box')]/div";

}
