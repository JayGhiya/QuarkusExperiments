package Array;

//https://leetcode.com/problems/rotate-image/
public class RotateTheMatrix {

    public int[][] rotate(int[][] matrix) {

        //here let us first find the transpose of matrix and then reverse row by row
        int[][] transposedMatrix = transposeOfAMatrix(matrix);

        //now reverse row by row
        int[][] reverseRowByRow = reverseRowByRow(transposedMatrix);

        return reverseRowByRow;
    }

    public int[][] reverseRowByRow(int[][] matrix)
    {
        for(int i =0; i < matrix.length;i++)
        {
            int reverseIndex = matrix[0].length-1;
            for(int j = 0;j< matrix[0].length/2;j++)
            {
                //swap a[i][j] a[i][reverseIndex]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][reverseIndex];
                matrix[i][reverseIndex] = temp;
                reverseIndex--;
            }

        }

        return matrix;
    }

    public int[][] transposeOfAMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return matrix;

    }
}
