package PageUI;

public class PersonalInfoUI {
    public static final String selectListMonthButton = "//div[@class='q-date__view q-date__calendar']//div[@class='relative-position overflow-hidden flex flex-center col']//button";
    public static final String selectMonthButton = "//div[contains(@class,'q-date__main')]//button[.//text()='%s']";
    public static final String selectYearButton = "//div[contains(@class,'q-date__main')]//span[@class='block' and text()='%s']";
    public static final String selectDateButton = "//div[contains(@class,'q-date__calendar-days-container')]//span[@class='block' and text()='%s']";
    public static final String previousListYearButton = "//div[contains(@class,'col-auto')]/button[.//i[contains(@class,'fa-chevron-left')]]";
    public static final String nationalityComboBox = "//input[@placeholder='Select any of the following']";
    public static final String genderComboBox = "//input[@data-cy='kyc-gender']";
    public static final String productInterestComboBox = "//input[@data-cy='person-edit-purposes']";
    public static final String submitButton = "//button[.//span[text()='Submit']]";
    public static final String selectedListProduct  = "//div[@class='q-virtual-scroll__content']//div[text()='%s']";
}
