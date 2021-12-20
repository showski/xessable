package x.stefan.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import x.stefan.screenplay.tasks.sortResults;
import x.stefan.screenplay.tasks.verifyResults;

public class sortBy {
	
	@When("user selects {string} for result sorting")
	public void user_selects_for_result_sorting(String sortByValue) {
		
		validateBrokenImages.currentActor.attemptsTo(sortResults.by(sortByValue));
	    
	}

	@Then("results should be displayed in correct order")
	public void results_should_be_displayed_in_correct_order() {
		
		validateBrokenImages.currentActor.attemptsTo(verifyResults.sortedBy());
	    
	}


}
