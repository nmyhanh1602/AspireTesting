package PageUI;

public class RegisterUI {
    public static final String fullNameInput = "xpath=//input[@name='full_name']";
    public static final String emailInput = "xpath=//input[@name='email']";
    public static final String phoneInput = "xpath=//input[@name='phone']";
    public static final String roleInCompanyRadio = "xpath=//div[text()='%s']";
    public static final String whereHereAboutUsInput = "xpath=//input[@type='search']";
    public static final String whereHereAboutUsList= "xpath=//div[contains(@class,'q-menu')]//div[contains(@class,'q-item__label')]";
    public static final String promoCodeInput = "xpath=//input[@data-cy='register-person-referral-code']";
    public static final String iAgreeCheckbox = "xpath=//div[contains(@class,'q-checkbox__inner')]";
    public static final String continueButton = "xpath=//button[@type='submit']";
    public static final String accountExistPopup = "xpath=//div[@class='q-card' and .//*[normalize-space(text())='Account exists, try login instead!']]";
    public static final String loginInPopupButton = "xpath=//div[@class='q-mb-xl']//span[@class='q-focus-helper']";
    public static final String optListInput = "xpath=//div[contains(@class,'digit-input__box')]/div";
    public static final String pleaseInputOTPTitle = "xpath=//div[contains(@class,'verify-otp__content') and normalize-space(text())='Please enter the 4-digit OTP sent to']";
    public static final String woHooContinueButton= "xpath=//button[.//span[text()='Continue']]";
}
