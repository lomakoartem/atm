package ua.atm.infrastructure.passwordGenerateAndHash;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by a.lomako on 1/31/2017.
 * Represents a functionality for creating new password for user.
 */
public class PasswordGenerator {

    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM = "0123456789";
    private static final String SPL_CHARS = "!@#$%^&*_=+-/";
    private static final int MIN_LENGTH_OF_PASSWORD = 9;
    private static final int MAX_LENGTH_OF_PASSWORD = 21;

    static Random r = new Random();

    static char[] choices = (ALPHA +
            ALPHA_CAPS +
            NUM +
            SPL_CHARS).toCharArray();

    /**
     * init symbol container
     */
    static Set<String> symbolsContainerSet = new HashSet<String>() {
        {
            add(ALPHA_CAPS);
            add(ALPHA);
            add(NUM);
            add(SPL_CHARS);
        }
    };

    /**
     * gets mandatory fields and concat them with additional
     * @return generated password
     */
    public static char[] generatePswd() {
        int len = generateRandomPasswordLength();
        char[] password = new char[len];
        char[] guaranteedSymbols = getGuaranteedSymbols(symbolsContainerSet);
        char[] remainingSymbols = getRemainingSymbols(password, guaranteedSymbols);
        mergeRemainingAndGuaranteedSymbolsIntoPassword(password, guaranteedSymbols, remainingSymbols);
        shufflePassword(password);
        return password;
    }

    /**
     *
     * @param password
     * @param guaranteedSymbols
     * @return remaining symbols
     */
    private static char[] getRemainingSymbols(char[] password, char[] guaranteedSymbols) {
        int remainingLength = password.length - guaranteedSymbols.length;
        char[] remainingSymbols = getRemainingSymbols(remainingLength, choices);
        return remainingSymbols;
    }

    /**
     * Method merges password with additional and mandatory symbols
     * @param password
     * @param guaranteedSymbols
     * @param remainingSymbols
     */
    private static void mergeRemainingAndGuaranteedSymbolsIntoPassword(char[] password, char[] guaranteedSymbols,
                                                                       char[] remainingSymbols) {
        System.arraycopy(guaranteedSymbols, 0, password, 0, guaranteedSymbols.length);
        System.arraycopy(remainingSymbols, 0, password, guaranteedSymbols.length, remainingSymbols.length);
    }

    /**
     * Generate password length in range
     * @return length of password
     */
    private static int generateRandomPasswordLength() {
        int randomLength = MIN_LENGTH_OF_PASSWORD + (int) (Math.random() * (MAX_LENGTH_OF_PASSWORD - MIN_LENGTH_OF_PASSWORD));
        return randomLength;
    }

    /**
     * takes symbols container and provide array of guarantee symbols
     * @param guaranteedSymbolsContainer
     * @return guarantee symbols
     */
    private static char[] getGuaranteedSymbols(Set<String> guaranteedSymbolsContainer) {
        char[] guaranteedSymbols = new char[guaranteedSymbolsContainer.size()];
        int counter = 0;
        for (String string : guaranteedSymbolsContainer) {
            guaranteedSymbols[counter++] = string.charAt(r.nextInt(string.length()));
        }
        return guaranteedSymbols;
    }

    /**
     *
     * @param requiredLength
     * @param allSymbols
     * @return remaining symbols
     */
    private static char[] getRemainingSymbols(int requiredLength, char[] allSymbols) {
        char[] remainingSymbols = new char[requiredLength];
        for (int i = 0; i < remainingSymbols.length; i++) {
            remainingSymbols[i] = allSymbols[r.nextInt(allSymbols.length)];
        }
        return remainingSymbols;
    }

    /**
     * Gets password and shuffles symbols inside array
     * @param password
     */
    private static void shufflePassword(char[] password) {
        int toBeSwappedWithIndex;
        for (int i = 0; i < password.length - 1; i++) {
            toBeSwappedWithIndex = r.nextInt(i + 1);
            char temp = password[toBeSwappedWithIndex];
            password[toBeSwappedWithIndex] = password[i];
            password[i] = temp;
        }
    }
}