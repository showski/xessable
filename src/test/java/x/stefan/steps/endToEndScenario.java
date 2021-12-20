package x.stefan.steps;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import x.stefan.screenplay.tasks.addAdults;
import x.stefan.screenplay.tasks.addChildren;
import x.stefan.screenplay.tasks.chooseValue;
import x.stefan.screenplay.tasks.enterDate;
import x.stefan.screenplay.tasks.fillUserForm;
import x.stefan.screenplay.tasks.iWantThis;
import x.stefan.screenplay.ui.internetHomePage;

public class endToEndScenario {

	@When("user clicks the {string} button for {string}")
	public void user_clicks_the_button_for(String buttonName, String itemName) {
		validateBrokenImages.currentActor.attemptsTo(iWantThis.item(itemName));

	}

	@When("selects {string} for adults")
	public void selects_for_adults(String numberOfAdults) {
		validateBrokenImages.currentActor.attemptsTo(addAdults.number(numberOfAdults));

	}

	@When("selects {string} for children")
	public void selects_for_children(String numberOfChildren) {
		validateBrokenImages.currentActor.attemptsTo(addChildren.number(numberOfChildren));

	}

	@When("enters {string} for date")
	public void enters_for_date(String dateValue) {
		validateBrokenImages.currentActor.attemptsTo(enterDate.withValue(dateValue));

	}

	@When("clicks on {string} button")
	public void clicks_on_button(String buttonName) {

		if (buttonName.equalsIgnoreCase("Check availability")) {

			validateBrokenImages.currentActor.attemptsTo(

					WaitUntil.the(internetHomePage.CHECK_AVAILABILITY_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.CHECK_AVAILABILITY_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.CHECK_AVAILABILITY_BUTTON, isClickable()), 
					Click.on(internetHomePage.CHECK_AVAILABILITY_BUTTON)

			);
		} else if (buttonName.equalsIgnoreCase("Select your time")) {

			validateBrokenImages.currentActor.attemptsTo(

					WaitUntil.the(internetHomePage.SELECT_YOUT_TIME_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.SELECT_YOUT_TIME_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.SELECT_YOUT_TIME_BUTTON, isClickable()), 
					Click.on(internetHomePage.SELECT_YOUT_TIME_BUTTON)

			);
		} else if (buttonName.equalsIgnoreCase("Next step")) {

			validateBrokenImages.currentActor.attemptsTo(

					WaitUntil.the(internetHomePage.NEXT_STEP_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.NEXT_STEP_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.NEXT_STEP_BUTTON, isClickable()), 
					Click.on(internetHomePage.NEXT_STEP_BUTTON)

			);
		}
		
		else if (buttonName.equalsIgnoreCase("Go to confirmation")) {

			validateBrokenImages.currentActor.attemptsTo(

					WaitUntil.the(internetHomePage.GO_TO_CONFIRMATION_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.GO_TO_CONFIRMATION_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.GO_TO_CONFIRMATION_BUTTON, isClickable()), 
					Click.on(internetHomePage.GO_TO_CONFIRMATION_BUTTON)

			);
		} else if (buttonName.equalsIgnoreCase("Confirm booking")) {

			validateBrokenImages.currentActor.attemptsTo(

					WaitUntil.the(internetHomePage.CONFIRM_BOOKING_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.CONFIRM_BOOKING_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.CONFIRM_BOOKING_BUTTON, isClickable()), 
					Click.on(internetHomePage.CONFIRM_BOOKING_BUTTON)

			);
		}

	}

	@When("chooses {string} from list")
	public void chooses_from_list(String timeValue) {
		validateBrokenImages.currentActor.attemptsTo(chooseValue.fromTable(timeValue));

	}

	@When("fills form using random information")
	public void fills_form_using_random_information() {
		validateBrokenImages.currentActor.attemptsTo(fillUserForm.random());

	}

	@Then("user verifies valiues from previous selection")
	public void user_verifies_valiues_from_previous_selection() {
		
		//tbd
		
		try {

			Thread.sleep(4000);

		}

		catch (InterruptedException e) {

		}

	}

}
