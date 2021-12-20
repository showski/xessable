package x.stefan.screenplay.questions;
import static net.serenitybdd.screenplay.questions.ValueOf.the;

import x.stefan.screenplay.model.elementAvailability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class elementAvailable implements Question<elementAvailability> {

	static Target targetItem;

	public elementAvailable(Target targetItem) {
		elementAvailable.targetItem = targetItem;
	}

	public static Target gettargetItem() {
		return targetItem;
	}

	@Override
	public elementAvailability answeredBy(Actor actor) {

		return elementAvailability.from(the(Visibility.of(targetItem).viewedBy(actor)));
	}

	public static Question<elementAvailability> OnPage(Target targetItem) {

		return new elementAvailable(targetItem);
	}

}
