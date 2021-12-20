package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import x.stefan.steps.validateBrokenImages;

public class verifyResults implements Task {

	public static int amount;
	public static String strAmount;
	public static float fltAmount;
	public static Target ITEM_LOCATOR;

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		try {

			Thread.sleep(4000);

		}

		catch (InterruptedException e) {

		}

		List<WebElement> price = validateBrokenImages.driver
				.findElements(By.xpath("//div[@class='deal-card']//p[@class='price-pp']"));

		if (sortResults.sortByValue.equalsIgnoreCase("high to low")) {

			if (price.size() != 0) {
				
				amount = 0;

				for (int i = 0; i < price.size(); i++) {

					ITEM_LOCATOR = Target.the("Locate Item")
							.locatedBy("(//div[@class='deal-card']//p[@class='price-pp'])[" + (i + 1) + "]");
					strAmount = Text.of(ITEM_LOCATOR).viewedBy(actor).asString().trim();
					strAmount = strAmount.split(" ")[0].replaceAll("€", "").trim();
					fltAmount = Float.valueOf(strAmount);

					if (amount != 0) {

						actor.attemptsTo(

								Ensure.that(Math.round(fltAmount))
										.isLessThan(amount)

						);

					}

					amount = Math.round(fltAmount);

				}
			}

		} else if (sortResults.sortByValue.equalsIgnoreCase("low to high")) {

			if (price.size() != 0) {
				
				amount = 0;

				for (int i = 0; i < price.size(); i++) {

					ITEM_LOCATOR = Target.the("Locate Item")
							.locatedBy("(//div[@class='deal-card']//p[@class='price-pp'])[" + (i + 1) + "]");
					strAmount = Text.of(ITEM_LOCATOR).viewedBy(actor).asString().trim();
					strAmount = strAmount.split(" ")[0].replaceAll("€", "").trim();
					fltAmount = Float.valueOf(strAmount);

					if (amount != 0) {

						actor.attemptsTo(

								Ensure.that(Math.round(fltAmount))
										.isGreaterThan(amount)

						);

					}

					amount = Math.round(fltAmount);

				}
			}
		}

	}

	public static Performable sortedBy() {
		return instrumented(verifyResults.class);
	}

}
