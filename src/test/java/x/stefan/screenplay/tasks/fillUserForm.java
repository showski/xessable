package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.Random;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import x.stefan.screenplay.actions.helpFunctions;
import x.stefan.screenplay.ui.internetHomePage;

public class fillUserForm implements Task{
	
	Random rd = new Random();
	public float nextFloat() {
		
		return 0;
	}
	
	int zip = (int) (10000 + rd.nextFloat() * 90000);

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(

				WaitUntil.the(internetHomePage.FORM_FIRST_NAME, isVisible()),
				WaitUntil.the(internetHomePage.FORM_FIRST_NAME, isPresent()),
				WaitUntil.the(internetHomePage.FORM_FIRST_NAME, isClickable()),
				Click.on(internetHomePage.FORM_FIRST_NAME),
				Enter.theValue(helpFunctions.generateRandomString(10)).into(internetHomePage.FORM_FIRST_NAME),
				
				WaitUntil.the(internetHomePage.FORM_LAST_NAME, isVisible()),
				WaitUntil.the(internetHomePage.FORM_LAST_NAME, isPresent()),
				WaitUntil.the(internetHomePage.FORM_LAST_NAME, isClickable()),
				Click.on(internetHomePage.FORM_LAST_NAME),
				Enter.theValue(helpFunctions.generateRandomString(10)).into(internetHomePage.FORM_LAST_NAME),
				
				WaitUntil.the(internetHomePage.FORM_EMAIL, isVisible()),
				WaitUntil.the(internetHomePage.FORM_EMAIL, isPresent()),
				WaitUntil.the(internetHomePage.FORM_EMAIL, isClickable()),
				Click.on(internetHomePage.FORM_EMAIL),
				Enter.theValue(helpFunctions.generateRandomString(10) + "@yahoo.com").into(internetHomePage.FORM_EMAIL),
				
				WaitUntil.the(internetHomePage.FORM_PHONE, isVisible()),
				WaitUntil.the(internetHomePage.FORM_PHONE, isPresent()),
				WaitUntil.the(internetHomePage.FORM_PHONE, isClickable()),
				Click.on(internetHomePage.FORM_PHONE),
				Enter.theValue(String.valueOf(zip)+String.valueOf(zip)).into(internetHomePage.FORM_PHONE),
				
				WaitUntil.the(internetHomePage.FORM_TERMS, isVisible()),
				WaitUntil.the(internetHomePage.FORM_TERMS, isPresent()),
				WaitUntil.the(internetHomePage.FORM_TERMS, isClickable()),
				Click.on(internetHomePage.FORM_TERMS)

		);
		
		
	}
	
	public static Performable random() {
		return instrumented(fillUserForm.class);
	}

}
