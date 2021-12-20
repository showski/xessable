package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import x.stefan.screenplay.ui.internetHomePage;

public class sortResults implements Task {

	public static String sortByValue;

	public sortResults(String sortByValue) {
		sortResults.sortByValue = sortByValue;
	}

	public static String getSortByValue() {
		return sortByValue;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(

				WaitUntil.the(internetHomePage.SORT_BY_LINK, isPresent()),
				WaitUntil.the(internetHomePage.SORT_BY_LINK, isClickable()), 
				Click.on(internetHomePage.SORT_BY_LINK)

		);
		
		try {

			Thread.sleep(4000);

		}

		catch (InterruptedException e) {

		}

		if (sortByValue.equalsIgnoreCase("high to low")) {

			actor.attemptsTo(

					WaitUntil.the(internetHomePage.SORT_HIGH_TO_LOW_LINK, isPresent()),
					WaitUntil.the(internetHomePage.SORT_HIGH_TO_LOW_LINK, isClickable()), 
					Click.on(internetHomePage.SORT_HIGH_TO_LOW_LINK)

			);

		}

		else if (sortByValue.equalsIgnoreCase("low to high")) {

			actor.attemptsTo(

					WaitUntil.the(internetHomePage.SORT_LOW_TO_HIGH_LINK, isPresent()),
					WaitUntil.the(internetHomePage.SORT_LOW_TO_HIGH_LINK, isClickable()), 
					Click.on(internetHomePage.SORT_LOW_TO_HIGH_LINK)

			);

		}
		
		// do not use case not specified
		else if (sortByValue.equalsIgnoreCase("relevance")) {

			actor.attemptsTo(

					WaitUntil.the(internetHomePage.SORT_RELEVANCE_LINK, isPresent()),
					WaitUntil.the(internetHomePage.SORT_RELEVANCE_LINK, isClickable()), 
					Click.on(internetHomePage.SORT_RELEVANCE_LINK)

			);

		}

	}

	public static Performable by(String sortByValue) {
		return instrumented(sortResults.class, sortByValue);
	}

}
