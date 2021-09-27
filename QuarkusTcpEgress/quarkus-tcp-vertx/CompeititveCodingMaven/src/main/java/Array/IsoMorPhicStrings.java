package Array;

//asked in bloomberg

/**
 *
 *
 * Write a method to determine if two input strings are an isomorphic pair. Two strings, s1 and s2 are isomorphic pairs if the characters in s1 can be replaced, or remapped to get s2. Remapping a character means replacing all occurrences of it with another character.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Constraints and Assumptions
 *
 * A character can be mapped to itself, or to another character, but not to more than one characters.
 * You can assume that both s1 and s2 will have the same length.
 * The comparisons should be case sensitive - i.e. A != a
 * Target linear time complexity.
 * Examples
 * isPairIsomorphic("css", "dll") -> true
 * isPairIsomorphic("css", "css") -> true
 * isPairIsomorphic("css", "txt") -> false
 */
public class IsoMorPhicStrings {


    public Boolean isPairIsomorphic(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Map<Character,Integer> arr1CharOccurenceMap = new HashMap<>();
        Map<Character,Integer> arr2CharOccurenceMap = new HashMap<>();

        int uniqueCountForCharArray1 = 0;
        int uniqueCountForCharArray2 = 0;

        for( int i =0 ;i <arr1.length;i++)
        {
            if(arr1CharOccurenceMap.containsKey(arr1[i]))
            {
                Integer count = arr1CharOccurenceMap.get(arr1[i]);
                count++;
                arr1CharOccurenceMap.put(arr1[i],count);
            }
            else
            {
                uniqueCountForCharArray1++;
                arr1CharOccurenceMap.put(arr1[i],new Integer(0));

            }
        }

        for(int i =0 ; i< arr2.length;i++)
        {
            if(arr2CharOccurenceMap.containsKey(arr2[i]))
            {
                Integer count = arr2CharOccurenceMap.get(arr2[i]);
                count++;
                arr2CharOccurenceMap.put(arr2[i],count);
            }
            else
            {
                uniqueCountForCharArray2++;
                arr2CharOccurenceMap.put(arr2[i],new Integer(0));
            }

        }

        if(uniqueCountForCharArray1 == uniqueCountForCharArray2)
        {
            if(s1.length() == s2.length())
            {
                return true;
            }

        }

        return false;
    }
}
