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

public class addChildren implements Task {

	public static String numberOfChildren;

	public addChildren(String numberOfChildren) {
		addChildren.numberOfChildren = numberOfChildren;
	}

	public static String getNumberOfChildren() {
		return numberOfChildren;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		for (int i = 0; i < Integer.parseInt(numberOfChildren); i++) {

			actor.attemptsTo(

					WaitUntil.the(internetHomePage.CHILD_INCREACE_BUTTON, isVisible()),
					WaitUntil.the(internetHomePage.CHILD_INCREACE_BUTTON, isPresent()),
					WaitUntil.the(internetHomePage.CHILD_INCREACE_BUTTON, isClickable()),
					Click.on(internetHomePage.CHILD_INCREACE_BUTTON)

			);
		}

	}

	public static Performable number(String numberOfChildren) {
		return instrumented(addChildren.class, numberOfChildren);
	}

}
