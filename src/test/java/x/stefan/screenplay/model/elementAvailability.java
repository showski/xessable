package x.stefan.screenplay.model;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum elementAvailability {

	Available(TRUE), Unavailable(FALSE);

    private Boolean isAvailable;

    elementAvailability(Boolean isAvailable) { this.isAvailable = isAvailable; }

    public static elementAvailability from(Boolean visibility){
        for(elementAvailability elementAvailability : values()) {
            if(visibility == elementAvailability.isAvailable) { return elementAvailability;}
        }
        throw new IllegalArgumentException("Unknown value " + visibility);
    }
}
