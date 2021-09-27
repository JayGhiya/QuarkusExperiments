package Educative.SlidingWindow;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithNoMoreThanKDistinctCharacters {

    //Sliding window pattern
    public static int findLength(String str,int k)
    {
        int windowStart = 0;
        char[] charArray = str.toCharArray();
        int longestSubString = Integer.MIN_VALUE;

        HashMap<Character,Integer> characterSet = new HashMap<>();
        for(int i = 0; i< charArray.length; i++)
        {
            characterSet.put(charArray[i],characterSet.getOrDefault(charArray[i],0)+1);
            while(characterSet.size()>k)
            {
                char element = charArray[windowStart];
                characterSet.put(element,characterSet.get(element)-1);
                if(characterSet.get(element) == 0)
                {
                    characterSet.remove(element);
                }
                windowStart++;
            }

            int currentLength = (i - windowStart)+1;
            if(currentLength>longestSubString)
            {
                longestSubString = currentLength;
            }

        }


    return longestSubString;
    }


}
