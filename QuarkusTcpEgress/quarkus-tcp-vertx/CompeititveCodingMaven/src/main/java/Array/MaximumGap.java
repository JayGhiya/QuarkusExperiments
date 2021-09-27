package Array;

import java.util.Arrays;

/**
 * Level: Hard
 * https://leetcode.com/problems/maximum-gap/
 */
public class MaximumGap {



    public int maximumGap(int[] nums) {
        //Algorithm is like this
        /*
        1) Find the min and max
        2) Find the average interval (max-min/intervals)
        3) Create buckets based on average interval by using (element - min) / averageInterval
        4) Do difference of min of next bucket with max of previous element
        5) collect results of 4 and find max among them and that is the answer
         */

        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ;i++)
        {
            if(nums[i]<min)
            {
                min = nums[i];
            }
            if(nums[i]>max)
            {
                max = nums[i];
            }
        }

        //the average interval
        int avgInterval = (int)Math.ceil((max-min+0.0)/(nums.length-1));

        System.out.println("Average interval is:"+avgInterval);
        //Now create two buckets of length n-1 (one for storing mins and one for storing maxs)
        int[] minBucket = new int[nums.length-1];
        int[] maxBucket = new int[nums.length-1];

        //initializng both arrays
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,Integer.MIN_VALUE);

        //let us place elements in the bucket
        for(int i =0 ; i< nums.length;i++)
        {
            if(nums[i] == min || nums[i] == max) continue;

            int bucketIndex = ((nums[i]-min)/avgInterval);

            minBucket[bucketIndex] = Math.min(nums[i],minBucket[bucketIndex]);
            maxBucket[bucketIndex] = Math.max(nums[i],maxBucket[bucketIndex]);

        }
        //for debug purpose only
        for(int i =0;i< minBucket.length;i++)
        {
            System.out.print(minBucket[i]+" ");
        }
        System.out.println("");
        for(int j=0;j< maxBucket.length;j++)
        {
            System.out.print(maxBucket[j]+" ");
        }

        //now comparing buckets
        //for the first bucket let us keep minimum = actualminimum
        int prev = min;
        int maxGap = 0;
        for(int i =0;  i< minBucket.length;i++  )
        {
            //also make sure do not process max buckets which are not filled
            if(maxBucket[i]==Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap,minBucket[i]-prev);
            prev=maxBucket[i];
        }
        //to check the last gap
        maxGap = Math.max(max-prev,maxGap);

        return maxGap;
    }

}
