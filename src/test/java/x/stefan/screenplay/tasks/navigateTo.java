package x.stefan.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class navigateTo implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(
				
				//TBD

		);
	}

	public static Performable brokenImagesPage() {
		return instrumented(navigateTo.class);
	}

}
