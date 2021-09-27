package Strings;

public class LongestPalindromicSubstring {

    public static int longestPalindromicSubstring(String str) {

        char[] stringArray = str.toCharArray();
        int longestSubString = 1;

        int oddTempCount = 0;
        int evenTempCount = 0;
        int finalCount  = 0;
        int leftPointer = 0;

        int rightPointer = 0;

        for(int i = 1; i< stringArray.length;i++)
        {
            oddTempCount = 0;
            evenTempCount = 0;
            //let us check if this was a odd string then we would check left and right pointer
            leftPointer = i;
            rightPointer = i;
            while( (leftPointer-1>-1) && (rightPointer+1<stringArray.length) && (stringArray[leftPointer-1] == stringArray[rightPointer+1]) )
            {
                oddTempCount+=2;
                leftPointer--;
                rightPointer++;
            }
            oddTempCount += 1; //one for middle element
            //let us check if this was a even string then we would check current and left
            while( (leftPointer-1>-1) && (rightPointer+1<stringArray.length) && (stringArray[leftPointer-1] == stringArray[rightPointer]) )
            {
                evenTempCount+=2;
                leftPointer--;
                rightPointer++;
            }

            if( (evenTempCount > oddTempCount) && (evenTempCount > finalCount) )
            {
                finalCount = evenTempCount;
            }

            else if ((evenTempCount < oddTempCount) && (evenTempCount < finalCount))
            {
                finalCount = oddTempCount;
            }

            if(finalCount>longestSubString)
            {
                longestSubString = finalCount;
            }

        }
        return longestSubString;
    }


}
