package Data;

import java.security.SecureRandom;

public class TokenGeneradorData {


    private static final SecureRandom random = new SecureRandom();

    public String generadorToken(int upper, int lower,  int digits, int special) {

        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String DIGITS = "0123456789";
        String SPECIAL = "!@#$%^&*()_";

        //String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_";


        StringBuilder token = new StringBuilder( upper + lower + digits + special);

        // this for Upper
        for (int i = 0; i < upper; i++) {

            token.append(UPPER.charAt(random.nextInt(UPPER.length())));
        }

        // this for Lower
        for (int i = 0; i < lower; i++) {

            token.append(LOWER.charAt(random.nextInt(LOWER.length())));
        }

        // this for Digits
        for (int i = 0; i < digits; i++) {

            token.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }

        // this for Special
        for (int i = 0; i < special; i++) {

            token.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));
        }

        return shuffleString(token.toString());
    }

    private String shuffleString(String input) {

            char[] characters = input.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                int randomIndex = random.nextInt(characters.length);
                char temp = characters[i];
                characters[i] = characters[randomIndex];
                characters[randomIndex] = temp;
            }
            return new String(characters);


        }

}
