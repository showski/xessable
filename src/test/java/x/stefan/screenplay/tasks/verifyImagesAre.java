package x.stefan.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.io.IOException;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import x.stefan.steps.validateBrokenImages;

public class verifyImagesAre implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		int brokenImages = 0;
		List<WebElement> image_list = validateBrokenImages.driver.findElements(By.tagName("img"));

		for (int i = 0; i < image_list.size(); i++) {

			try {

				WebElement img = validateBrokenImages.driver.findElement(By.xpath("(//img)[" + (i + 1) + "]"));
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(img.getAttribute("src"));
				HttpResponse response = client.execute(request);

				if (response.getStatusLine().getStatusCode() != 200) {
					brokenImages++;
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		actor.attemptsTo(

				Ensure.that(brokenImages).isEqualTo(0)

		);
	}

	public static Performable notBroken() {
		return instrumented(verifyImagesAre.class);
	}

}
