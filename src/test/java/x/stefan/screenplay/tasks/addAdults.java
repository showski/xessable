package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import x.stefan.screenplay.ui.internetHomePage;

public class addAdults implements Task {

	public static String numberOfAdults;

	public addAdults(String numberOfAdults) {
		addAdults.numberOfAdults = numberOfAdults;
	}

	public static String getNumberOfAdults() {
		return numberOfAdults;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		for (int i = 0; i < Integer.parseInt(numberOfAdults); i++) {

			actor.attemptsTo(

					WaitUntil.the(internetHomePage.ADULT_INCREACE_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.ADULT_INCREACE_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.ADULT_INCREACE_BUTTON, isClickable()),
					Click.on(internetHomePage.ADULT_INCREACE_BUTTON)

			);
		}

	}

	public static Performable number(String numberOfAdults) {
		return instrumented(addAdults.class, numberOfAdults);
	}

}
