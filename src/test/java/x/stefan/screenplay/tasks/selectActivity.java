package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class selectActivity implements Task{
	
	public static String activityOption;
	public static Target ITEM_LOCATOR;

	public selectActivity(String activityOption) {
		selectActivity.activityOption = activityOption;
	}

	public static String getActivityOption() {
		return activityOption;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		ITEM_LOCATOR = Target.the("Locate Item").locatedBy("//div[@id='activityfilter']//input[@data-name='" + activityOption + "']");

		actor.attemptsTo(

				WaitUntil.the(ITEM_LOCATOR, isPresent()), 
				WaitUntil.the(ITEM_LOCATOR, isClickable()),
				Click.on(ITEM_LOCATOR)

		);
		
	}
	
	public static Performable fromSideFilter(String activityOption) {
		return instrumented(selectActivity.class, activityOption);
	}

}
