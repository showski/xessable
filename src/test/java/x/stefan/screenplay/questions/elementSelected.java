package x.stefan.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import net.serenitybdd.screenplay.targets.Target;
import x.stefan.screenplay.model.elementSelection;
import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class elementSelected implements Question<elementSelection> {

	static Target element;

	public elementSelected(Target element) {
		elementSelected.element = element;
	}

	public static Target getElement() {
		return element;
	}

	@Override
	public elementSelection answeredBy(Actor actor) {

		return elementSelection.from(the(SelectedStatus.of(element).viewedBy(actor)));
	}

	public static Question<elementSelection> OnPage(Target element) {

		return new elementSelected(element);
	}

}