package x.stefan.steps;

import org.openqa.selenium.WebDriver;

import x.stefan.screenplay.model.ActorFactory;
import x.stefan.screenplay.tasks.verifyImagesAre;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

public class validateBrokenImages {
	
	static Actor currentActor;
	
    @Managed
	public static WebDriver driver;
	
	@Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }	
	
	@Given("^the user opens the test home page$")
	public void the_user_opens_the_internet_home_page() {
		
		currentActor = ActorFactory.getActor(driver);
		currentActor.attemptsTo(Open.url("https://test.briqstaging.net"));
		
	}
	
	@Then("^user verifies images on page are not broken$")
	public void user_verifies_images_on_page_are_not_broken() {
		
		currentActor.attemptsTo(verifyImagesAre.notBroken());
		
	}
	

}
