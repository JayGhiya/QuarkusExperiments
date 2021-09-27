package searching;

public class BinarySearch {

    public boolean findElementUsingBinarySearch(int[] sortedArray,int element)
    {
        return doBinarySearch(0, sortedArray.length-1,element,sortedArray);
    }

    public boolean doBinarySearch(int start,int end,int element,int[] sortedArray) {
        if (end >= start) {

            int mid = start + (end-start) / 2;

            // If the element is present at the middle itself
            if (sortedArray[mid] == element)
                return true;

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (sortedArray[mid] > element)
                return doBinarySearch(start, mid - 1, element, sortedArray);

            // Else the element can only be present in right
            // subarray
            return doBinarySearch(mid + 1, end, element, sortedArray);
        }

        return false;

    }
}
