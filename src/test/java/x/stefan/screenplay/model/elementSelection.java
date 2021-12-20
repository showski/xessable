package x.stefan.screenplay.model;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum elementSelection {

	Selected(TRUE), NotSelected(FALSE);

    private Boolean isSelected;

    elementSelection(Boolean isSelected) { this.isSelected = isSelected; }

    public static elementSelection from(Boolean status){
        for(elementSelection elementSelection : values()) {
            if(status == elementSelection.isSelected) { return elementSelection;}
        }
        throw new IllegalArgumentException("Unknown value " + status);
    }
}
