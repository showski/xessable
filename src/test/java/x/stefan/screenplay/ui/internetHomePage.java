package x.stefan.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class internetHomePage {
	
	public static Target SORT_BY_LINK = Target.the("Sort By Link").locatedBy("//button[@data-id='sort-deals']");
	public static Target SORT_LOW_TO_HIGH_LINK = Target.the("Sort By Low To High").locatedBy("//div[@class='bestelstraat-container']//div[contains(@class,'dropdown-menu')]//span[contains(text(),'Price low to high')]//..");
	public static Target SORT_HIGH_TO_LOW_LINK = Target.the("Sort By High to Low").locatedBy("//div[@class='bestelstraat-container']//div[contains(@class,'dropdown-menu')]//span[contains(text(),'Price high to low')]//..");
	public static Target SORT_RELEVANCE_LINK = Target.the("Sort By Relevance").locatedBy("//div[@class='bestelstraat-container']//div[contains(@class,'dropdown-menu')]//span[contains(text(),'Relevance')]//..");
	public static Target CHECK_AVAILABILITY_BUTTON = Target.the("Check Availability Button").locatedBy("//button[contains(text(),'Check availability')]");
	public static Target SELECT_YOUT_TIME_BUTTON = Target.the("Select Your Time Button").locatedBy("//button[contains(text(),'Select your time!')]");
	public static Target NEXT_STEP_BUTTON = Target.the("Next Step Button").locatedBy("(//button[contains(text(),'Next step')])[2]");
	public static Target GO_TO_CONFIRMATION_BUTTON = Target.the("Go To Confirmation Button").locatedBy("//button[contains(text(),'Go to confirmation')]");
	public static Target CONFIRM_BOOKING_BUTTON = Target.the("Confirm Booking Button").locatedBy("//span[contains(text(),'Confirm booking')]//..//..//button");
	public static Target ADULT_INCREACE_BUTTON = Target.the("Adult Increace Button").locatedBy("//div[@id='classification-picker-adult']//button[contains(@class,'increase')]");
	public static Target CHILD_INCREACE_BUTTON = Target.the("Child Increace Button").locatedBy("//div[@id='classification-picker-child']//button[contains(@class,'increase')]");
	public static Target DATE_FIELD = Target.the("Date Field").locatedBy("//div[@id='datefilter']//input[@type='text']");
	
	//user form
	public static Target FORM_FIRST_NAME = Target.the("Form First Name").locatedBy("//input[@name='first_name']");
	public static Target FORM_LAST_NAME = Target.the("Form Last Name").locatedBy("//input[@name='last_name']");
	public static Target FORM_EMAIL = Target.the("Form Email").locatedBy("//input[@name='email']");
	public static Target FORM_PHONE = Target.the("Form Phone").locatedBy("//input[@name='tel']");
	public static Target FORM_TERMS = Target.the("Form Terms").locatedBy("//input[@name='terms']//..//span");
}
