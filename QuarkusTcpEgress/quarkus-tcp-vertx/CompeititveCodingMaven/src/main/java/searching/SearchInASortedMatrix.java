package searching;

public class SearchInASortedMatrix {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {



        int rowIndex = 0;
        int columnIndex = matrix[0].length-1;
        boolean elementNotExists = false;

        while(elementNotExists == false)
        {
            int element = matrix[rowIndex][columnIndex];
            if(element==target)
            {
                return new int[]{rowIndex,columnIndex};
            }
            else if(element > target)
            {
                if(columnIndex-1>-1)
                columnIndex--;
                else
                    elementNotExists=true;
            }
            else if(element<target)
            {
                if(rowIndex+1< matrix.length)
                rowIndex++;
                else
                    elementNotExists=true;
            }


        }
        return new int[]{-1,-1};
    }
}