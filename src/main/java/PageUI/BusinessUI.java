package PageUI;

public class BusinessUI {
    public static final String continueRegisterBusinessButton= "xpath=//div[./span[normalize-space(text())='%s']]/following-sibling::button[.//span[text()='%s']]";
    public static final String getStartButton = "xpath=//button[@type='submit' and contains(@class,'q-btn')]";
    public static final String businessNameInput = "xpath=//input[@data-cy='register-business-name']";
    public static final String registerTypeInput = "xpath=//input[@data-cy='register-business-registration-type']";
    public static final String registerNumberInput = "xpath=//input[@data-cy='register-business-registration-number']";
    public static final String registerIndustryInput = "xpath=//input[@data-cy='register-business-industry']";
    public static final String registerSubIndustryInput = "xpath=//input[@data-cy='register-business-sub-industry']";
    public static final String registerSubmitButton = "xpath=//button[@type='submit']";
}
