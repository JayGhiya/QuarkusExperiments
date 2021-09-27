package microsoft.miscelllanous;
/*

Problem statement

        Write a method to compress a sorted string by replacing instances of characters repeated 2 or more times with the with the character followed by the number of times it is repeated. Note that this glorified "compression" is not useful in reducing the size of the string unless a character is repeated at least 2 times, since "a1" consumes more space than "a".

        Constraints and Assumptions

        The input string is already sorted.
        Case should be considered when compressing the string - i.e. compress("AAAaaa") -> "A3a3".
        Shoot for constant space complexity.

        Examples

        compress("AAAAaaabbbbbcccc") --> A4a3b5c4
        compress("aabbbbccc") --> a2b4c3
        compress("abc") --> abc

*/

import java.util.HashMap;
import java.util.Map;

public class SimpleSortedUsingStringCompression {
    /**
     * Compresses a sorted string by replacing adjacent identical
     * characters with their cardinality if it's >= 2.
     *
     * @param input Sorted string input.
     * @return Compressed string output.
     */
    public String compress(String input) {

        StringBuilder stringBuilder = new StringBuilder();

        int accumulator = 0;

        for(int i = 0 ; i < input.length();i++)
        {
            if(i>0 && input.charAt(i)!=input.charAt(i-1))
            {
                   stringBuilder.append(input.charAt(i-1));
                   if(accumulator>1)
                       stringBuilder.append(accumulator);
                   accumulator=1;
            }
            else {
                accumulator++;
            }
        }

        stringBuilder.append(input.charAt(input.length()-1));
        if(accumulator>1)
            stringBuilder.append(accumulator);

        return stringBuilder.toString();
    }

}
