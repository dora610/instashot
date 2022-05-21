package link.karurisuro.instashot.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomParameterConstraintException extends Exception {
    public CustomParameterConstraintException(String message) {
        super(message);
    }
}
