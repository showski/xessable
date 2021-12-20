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
import x.stefan.screenplay.ui.internetHomePage;

public class iWantThis implements Task{
	
	public static String itemName;
	public static Target ITEM_LOCATOR;

	public iWantThis(String itemName) {
		iWantThis.itemName = itemName;
	}

	public static String getTtemName() {
		return itemName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		ITEM_LOCATOR = Target.the("Locate Item").locatedBy("//div[@data-name='" + itemName + "']//*[contains(@class,'icon-ticket')]");
		
		actor.attemptsTo(

				WaitUntil.the(ITEM_LOCATOR, isPresent()), 
				WaitUntil.the(ITEM_LOCATOR, isClickable()),
				Click.on(ITEM_LOCATOR),
				WaitUntil.the(internetHomePage.CHECK_AVAILABILITY_BUTTON, isVisible())

		);
		
	}
	
	public static Performable item(String itemName) {
		return instrumented(iWantThis.class, itemName);
	}

}
