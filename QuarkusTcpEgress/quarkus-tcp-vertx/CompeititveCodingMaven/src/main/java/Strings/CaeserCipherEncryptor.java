package Strings;

/**
 * Given a non empty string of lowercase letters and a non-negative integer representing a key write a function that
 * returns a new string obtained by shifting every letter in the inout string by k positions
 * in the alphabet where k is the key.
 *
 * Note that letters should wrap around the alphabet in other words the
 * letter z shifted by one returns the letter a.
 */

public class CaeserCipherEncryptor {


    public static String caesarCypherEncryptor(String str, int key) {


        char[] newShiftedCharArray = new char[str.length()];

        int index = 0;
        for (char currentChar : str.toCharArray()) {
            //get the byte code of the character
            int current = currentChar;
            int shiftedByte = (current + key) ;
            while (shiftedByte>122)
                shiftedByte = (shiftedByte % 122)+96;
            newShiftedCharArray[index] = (char) shiftedByte;
            index++;

        }


        return new String(newShiftedCharArray);
    }
}
