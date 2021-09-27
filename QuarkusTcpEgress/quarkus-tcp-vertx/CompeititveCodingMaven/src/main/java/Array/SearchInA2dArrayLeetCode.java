package Array;

import searching.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/search-a-2d-matrix/#
public class SearchInA2dArrayLeetCode {

    public boolean searchMatrix(int[][] matrix, int target) {
        BinarySearch binarySearch = new BinarySearch();
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j=0; j < matrix[0].length; j++)
            {
                //check the last element of the row
                if(target>=matrix[i][0] && target<=matrix[i][matrix[0].length-1])
                {
                    //apply binary search to find if element exists
                    return binarySearch.findElementUsingBinarySearch(matrix[i],target);
                }

                break;


            }
        }
        return false;
    }

}
