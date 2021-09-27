package Educative.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {


    public  int findLength (String str){
         int maxLength = 0;
         int windowStart = 0;
         Map<Character,Integer> hashmap = new HashMap<>();
          char[] charArray = str.toCharArray();

         for(int windowEnd =0;windowEnd<str.length();windowEnd++)
         {
             //get the character
             char element =  charArray[windowEnd];


             //check if present in hashmap or not
             if(hashmap.containsKey(element))
             {
                //change windowStart
                 //tricky
                 windowStart = Math.max(windowStart ,  hashmap.get(element)+1 ) ;
             }
             //if not
             //increment windowEnd and calculate maxlength
             hashmap.put(element,windowEnd);

             maxLength = Math.max(maxLength,windowEnd-windowStart+1);


         }

        return maxLength;

    }


}
