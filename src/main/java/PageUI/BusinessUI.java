package PageUI;

public class BusinessUI {
    public static final String continueRegisterBusinessButton= "//div[./span[normalize-space(text())='%s']]/following-sibling::button[.//span[text()='%s']]";
    public static final String getStartButton = "//button[@type='submit' and contains(@class,'q-btn')]";
    public static final String businessNameInput = "//input[@data-cy='register-business-name']";
    public static final String registerTypeInput = "//input[@data-cy='register-business-registration-type']";
    public static final String registerNumberInput = "//input[@data-cy='register-business-registration-number']";
    public static final String registerIndustryInput = "//input[@data-cy='register-business-industry']";
    public static final String registerSubIndustryInput = "//input[@data-cy='register-business-sub-industry']";
    public static final String registerSubmitButton = "//button[@type='submit']";
}
