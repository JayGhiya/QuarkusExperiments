package Array;

public class CountInversionsInAnArray {


    public int doCountingOfInversions(int[] array)
    {
        //apply merge sort logic
        int inversionCount = 0;
        return doMergeSort(array,inversionCount);
    }

    public int doMergeSort(int[] array,int inversionCount)
    {
        if(array.length<2)
        {
            return inversionCount;
        }

        //find the mid
        int mid = array.length/2;

        int[] leftSubArray = new int[mid];
        int[] rightSubArray = new int[array.length-mid];

        //fill both the arrays
        for(int i = 0 ;i  < leftSubArray.length ; i++)
        {
            leftSubArray[i] = array[i];
        }
        int j = 0;
        for(int i = mid ;i  < array.length ; i++)
        {
            rightSubArray[j] = array[i];
            j++;
        }

        //do  sort of left
        inversionCount = doMergeSort(leftSubArray,inversionCount);
        //do  sort of right child
        inversionCount = doMergeSort(rightSubArray, inversionCount);
        //and then merge
        inversionCount = doMerge(leftSubArray,rightSubArray,array,inversionCount);
        return inversionCount;
    }

    public int doMerge(int[] leftArray,int[] rightArray,int[] finalArray,int inversionCount)
    {
        int i = 0 ;
        int j = 0;
        int k = 0;

        while( (i < leftArray.length) && (j < rightArray.length)) {

            if (leftArray[i] < rightArray[j]) {
                finalArray[k] = leftArray[i];
                i++;
            }
            else
            {
                finalArray[k] = rightArray[j];
                j++;
                inversionCount++;
            }
            k++;

        }

        while(i< leftArray.length)
        {
            finalArray[k] = leftArray[i];
            i++;
            k++;

        }

        while(j< rightArray.length)
        {
            finalArray[k] = rightArray[j];
            j++;
            k++;
        }

        return inversionCount;
    }

}

