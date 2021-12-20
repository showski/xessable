package x.stefan.screenplay.model;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ActorFactory {
	
	public static Actor getActor(WebDriver driver)  {

        Actor actor = null;
        
        	actor = new Actor("user");        	


        actor.whoCan(BrowseTheWeb.with(driver));
        return actor;
    }

}
