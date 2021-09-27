package Sorting;

public class ThreeNumberSort{

    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        //variable for swap
        int temp;
        int firstElement = order[0];
        int lastElement = order[2];
        //element to swap with
        int firstIdx = 0;

        //first pass for placing firstElementFirst
        for(int i = 0 ; i < array.length; i++)
        {
            if(array[i]==firstElement)
            {
                //swap time
                temp = array[i];
                array[i] = array[firstIdx];
                array[firstIdx] = temp;
                firstIdx++;
            }

        }
        //element to swap with
        int lastIdx = array.length-1;
        for(int j=array.length-1; j>=0;j--)
        {
            if(array[j]==lastElement)
            {
                //swap time
                temp = array[j];
                array[j] = array[lastIdx];
                array[lastIdx] = temp;
                lastIdx--;
            }
        }

        return array;
    }




}
