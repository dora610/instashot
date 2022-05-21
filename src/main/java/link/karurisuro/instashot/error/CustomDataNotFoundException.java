package link.karurisuro.instashot.error;

import lombok.NoArgsConstructor;

public class CustomDataNotFoundException extends Exception {
    public CustomDataNotFoundException(String message) {
        super(message);
    }

    public CustomDataNotFoundException() {
        super("No such element found!!");
    }
}
