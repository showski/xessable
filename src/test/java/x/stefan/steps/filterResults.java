package x.stefan.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import x.stefan.screenplay.tasks.resultsReflectFilter;
import x.stefan.screenplay.tasks.selectActivity;

public class filterResults {
	
	@When("user selects {string} for activity")
	public void user_selects_for_activity(String activityOption) {
		validateBrokenImages.currentActor.attemptsTo(selectActivity.fromSideFilter(activityOption));
	}

	@Then("results should reflect filter selection")
	public void results_should_reflect_filter_selection() {
		validateBrokenImages.currentActor.attemptsTo(resultsReflectFilter.onPage());
	    
	}

}
