package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import x.stefan.screenplay.ui.internetHomePage;

public class enterDate implements Task{
	
	public static String dateValue;
	public static Target ITEM_LOCATOR;

	public enterDate(String dateValue) {
		enterDate.dateValue = dateValue;
	}

	public static String getDateValue() {
		return dateValue;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		
		actor.attemptsTo(

				WaitUntil.the(internetHomePage.DATE_FIELD, isVisible()),
				WaitUntil.the(internetHomePage.DATE_FIELD, isPresent()),
				WaitUntil.the(internetHomePage.DATE_FIELD, isClickable()),
				Click.on(internetHomePage.DATE_FIELD)

		);
		
		ITEM_LOCATOR = Target.the("Locate Item").locatedBy("//div[@class='dayContainer']//span[text()='" + dateValue + "']");
		
		actor.attemptsTo(

				WaitUntil.the(ITEM_LOCATOR, isVisible()),
				WaitUntil.the(ITEM_LOCATOR, isPresent()),
				WaitUntil.the(ITEM_LOCATOR, isClickable()),
				Click.on(ITEM_LOCATOR),
				WaitUntil.the(ITEM_LOCATOR, isNotVisible())

		);
		
	}
	
	public static Performable withValue(String dateValue) {
		return instrumented(enterDate.class, dateValue);
	}

}
