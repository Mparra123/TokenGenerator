package Data;

import java.security.SecureRandom;

public class TokenGeneradorData {

    public String generadorToken(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_";
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            token.append(characters.charAt(random.nextInt(characters.length())));
        }
        return token.toString();
    }

}
