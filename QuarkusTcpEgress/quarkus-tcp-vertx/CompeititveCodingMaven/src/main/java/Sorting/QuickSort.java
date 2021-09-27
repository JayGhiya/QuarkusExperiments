package Sorting;

public class QuickSort {

    public int[] doQuickSort(int[] array) {
        // Write your code here.

        quickSort(array,0,array.length-1);
        return array;

    }

    public void quickSort(int[] array,int start,int end)
    {
        //find pivot index
        if(start < end) {
            int pivotIndex = findPivot(array, start, end);
            quickSort(array,start,pivotIndex-1);
            quickSort(array,pivotIndex+1,end);

        }

    }


    public int findPivot(int[] array,int start,int end)
    {
        int tempPointer = start;
        int pivotIndex = end;
        for(int i = start;i<end;i++)
        {
            if(array[i] < array[pivotIndex])
            {
                //swap
                int temp = array[i];
                array[i] = array[tempPointer];
                array[tempPointer] = temp;
                tempPointer++;
            }
        }
        //swap tempointer and pivotIndex
        int temp = array[tempPointer];
        array[tempPointer] = array[pivotIndex];
        array[pivotIndex] = temp;

        return tempPointer;
    }

}
