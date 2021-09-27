package Array;

//reference -> https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/

public class MinAndMaxInAArray {

    public int[] getMinAndMax(int[] arr,int sizeOfArr)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < sizeOfArr ;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
            }

            if(arr[i]>max)
            {
                max=arr[i];
            }

        }
        System.out.println("Min is:"+min);
        System.out.println("Max is:"+max);

        return new int[]{min,max};
    }
}
