package Array;

public class TransposeOfAMatrix {

    public int[][] TransposeOfAMatrix(int[][] matrix )
    {
        for(int i = 0 ; i < matrix.length;i++)
        {
            for(int j = i+1 ; j <matrix[0].length;j++)
            {
                if(i!=j)
                {
                    //swap a[i][j] and a[j][i]
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
return matrix;

    }


}
