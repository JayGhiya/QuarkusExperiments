package Array;

public class NextPermutation {

    public int[] doNextPermutation(int[] nums) {

        //find first a[i] which is following a downward trend
        int i = nums.length-1;
        while( (i>=0) && (nums[i]<=nums[i-1]))
        {
            i--;
        }
        System.out.println("first integer is:"+nums[i-1]);
        //got the number
        if(i>=0)
        {
            int j = nums.length-1;

            while( (j > 0) && (nums[j]<=nums[i-1]))
            {
                j--;
            }
            swap(nums,i-1,j);
        }

        //reverse the array arguments arr,startIndex,endIndex
        reverse(nums,i,nums.length-1);
        return nums;
    }
    private void reverse(int[] arr,int startIndex,int endIndex)
    {
        //apply string reversal logic
        int j = arr.length-1;
        for(int i = startIndex ; i < j ; i++)
        {
            //swap i and the last element
            swap(arr,i,j);
            j--;
        }

    }
    private void swap(int[] arr, int swapOne,int swapTwo)
    {
        int temp = arr[swapOne];
        arr[swapOne] = arr[swapTwo];
        arr[swapTwo] = temp;
    }
}

