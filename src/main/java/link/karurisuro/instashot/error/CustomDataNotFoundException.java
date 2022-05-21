package link.karurisuro.instashot.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomDataNotFoundException extends Exception {
    public CustomDataNotFoundException(String message) {
        super(message);
    }
}
