package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class chooseValue implements Task {

	public static String timeValue;
	public static Target ITEM_LOCATOR;

	public chooseValue(String timeValue) {
		chooseValue.timeValue = timeValue;
	}

	public static String getTimeValue() {
		return timeValue;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		ITEM_LOCATOR = Target.the("Locate Item").locatedBy(
				"//div[@id='time-selector-content']//div[contains(text(),'" + timeValue + "')]//..//..//input//..");

		actor.attemptsTo(

				WaitUntil.the(ITEM_LOCATOR, isVisible()), 
				WaitUntil.the(ITEM_LOCATOR, isPresent()),
				WaitUntil.the(ITEM_LOCATOR, isClickable()), 
				Click.on(ITEM_LOCATOR)

		);

	}

	public static Performable fromTable(String timeValue) {
		return instrumented(chooseValue.class, timeValue);
	}

}
