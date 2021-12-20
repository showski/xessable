package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
import static x.stefan.screenplay.model.elementAvailability.Available;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import x.stefan.screenplay.questions.elementAvailable;

public class resultsReflectFilter implements Task {

	public static Target ITEM_LOCATOR;
	public static Target GET_TEXT_LOCATOR;
	public static String textValue;

	@Override
	public <T extends Actor> void performAs(T actor) {

		ITEM_LOCATOR = Target.the("Locate Item")
				.locatedBy("//div[contains(@class,'deal-card')]//h3[text()='" + selectActivity.activityOption + "']");

		actor.should(

				seeThat(elementAvailable.OnPage(ITEM_LOCATOR), is(Available))

		);

		GET_TEXT_LOCATOR = Target.the("Locate Item Text").locatedBy("//div[contains(@class,'deal-card')]//h3");

		textValue = Text.of(GET_TEXT_LOCATOR).viewedBy(actor).asString();

		actor.attemptsTo(

				Ensure.that(textValue).isEqualToIgnoringCase(selectActivity.activityOption)

		);

	}

	public static Performable onPage() {
		return instrumented(resultsReflectFilter.class);
	}

}
