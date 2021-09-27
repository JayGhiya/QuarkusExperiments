package Array;

import java.util.*;

/**
 * Max Non Negative SubArray
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 *
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 *
 * Find and return the required subarray.
 */

public class MaxNonNegativeSubArray {

    public int[] maxset(int[] A) {

        long sum = 0;
        long maxSum=Integer.MIN_VALUE;
        int start = 0;
        int startSubset = 0;
        int[] subset=null;
        int[] subsetTie1= null;

        for(int i = 0; i < A.length ; i++)
        {
            if(A[i]>=0)
            {
                sum+=A[i];
            }
            else
            {
                if(sum>=0)
                {
                    if(sum>maxSum)
                    {
                        subset =  Arrays.copyOfRange(A,start,i);

                        maxSum = sum;
                    }
                    else if(sum==maxSum)
                    {
                        //it is a tie
                        subsetTie1 = Arrays.copyOfRange(A,start,i);
                        if(subsetTie1.length>subset.length)
                        {
                            subset=subsetTie1;
                        }
                        else if(subsetTie1.length==subset.length)
                        {
                            if(startSubset>start)
                            {
                                subset=subsetTie1;
                            }
                        }
                    }
                }
                sum=0;
                startSubset = start;
                start=i+1;
            }

        }
        //for last element
        if(sum>maxSum)
        {
            subset = Arrays.copyOfRange(A,start,A.length);

            maxSum = sum;
        }

        if(subset==null)
        {
            return new int[0];
        }
        return subset;
        //Now find the subset with highest sum
    }

}
