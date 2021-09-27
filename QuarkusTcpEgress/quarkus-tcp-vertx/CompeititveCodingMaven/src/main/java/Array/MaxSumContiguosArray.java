package Array;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguosArray {

//kadane's algorithm
    public int maxSubArray(int[] nums) {

        int maxSumSoFar = Integer.MIN_VALUE;

        int currentSum = 0;


        for(int i =0 ; i < nums.length ; i++)
        {

            currentSum += nums[i];

            if(currentSum>maxSumSoFar)
                maxSumSoFar=currentSum;

            if(currentSum<0)
                currentSum=0;

        }



        return maxSumSoFar;

    }
}