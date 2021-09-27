package Sorting;

public class MergeSort {

    public int[] doMergeSort(int []arr)
    {
        int length = arr.length;
        if(length < 2)
        {
            return arr;
        }
        else
        {
            //find mid of array and split
            int mid = length/2;
            int[] leftSubArray = new int[mid];
            //n - mid
            int[] rightSubArray = new int[length - mid];

            //fill leftSubArray
            for(int i = 0 ; i < mid ; i++)
            {
                leftSubArray[i] = arr[i];
            }
            //fill rightSubArray
            int j =0;
            for(int i = mid ; i < length  ; i++)
            {
                rightSubArray[j] = arr[i];
                j++;
            }
            //call MergeSort for again splitting
            doMergeSort(leftSubArray);
            doMergeSort(rightSubArray);
            doMerge(leftSubArray,rightSubArray,arr);

        }

        return arr;


    }

    public void doMerge(int[] leftSubArray,int[] rightSubArray,int[] finalArray)
    {
        int leftSubArrayLength = leftSubArray.length;
        int rightSubArrayLength = rightSubArray.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while( (i<leftSubArrayLength) && (j<rightSubArrayLength))
        {
            if(leftSubArray[i] <= rightSubArray[j])
            {
                finalArray[k] = leftSubArray[i];
                i++;

            }
            else
            {
                finalArray[k] = rightSubArray[j];
                j++;
            }

            k++;
        }
        while(i<leftSubArrayLength)
        {
            finalArray[k] = leftSubArray[i];
            k++;
            i++;
        }
        while(j<rightSubArrayLength)
        {
            finalArray[k] = rightSubArray[j];
            k++;
            j++;
        }

    }
}
