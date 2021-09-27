package Educative.SlidingWindow;

public class SmallestSubarrayWithAGivenSum {


    public int findMinSubArray(int S,int[] arr)
    {
        int windowSum = arr[0], minLength = Integer.MAX_VALUE;

        int windowStart = 0;

        int windowEnd = 1;

        boolean foundSum  = Boolean.FALSE;

        for(int i = 0 ;i < arr.length;i++)
        {

            while( (windowSum<S) && (windowEnd<arr.length) )
            {
                windowSum+=arr[windowEnd];
                windowEnd++;
            }
            //now check if length is smaller
            if( (windowEnd-windowStart) < minLength)
            {
                minLength = (windowEnd - windowStart);
            }

            while(windowSum>=S)
            {
                if(windowSum == S)
                {
                    foundSum = Boolean.TRUE;
                }
                windowSum-=arr[windowStart];
                windowStart++;
            }

        }

        if(foundSum)
        {
            return minLength;
        }

        return 0;

    }

}
