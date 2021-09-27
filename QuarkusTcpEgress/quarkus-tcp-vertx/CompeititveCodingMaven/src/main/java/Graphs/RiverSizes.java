package Graphs;

import java.util.*;

//algoexpert
public class RiverSizes {

    public  List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        //let us have a auxillary matrix for storing visited elements
        boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];
        List<Integer> finalRiverSizesList = new ArrayList<>();
        finalRiverSizesList = calculateRiverSizesUsingDFS(matrix,visitedMatrix,finalRiverSizesList);
        return finalRiverSizesList;
    }

    public List<Integer> calculateRiverSizesUsingDFS(int[][] matrix, boolean[][] visitedMatrix, List<Integer> finalRiverSizesList) {
        //iterating over each element of matrix and looking at its left,right,top and bottom
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visitedMatrix[i][j]) {
                    continue;
                }
                findRiverSize(matrix, i, j, visitedMatrix, finalRiverSizesList);

            }
        }
        return finalRiverSizesList;
    }


    public void findRiverSize(int[][] matrix, int i, int j, boolean[][] visitedMatrix, List<Integer> riverSizes) {
        //let us do dfs using stack
        Stack<Integer[]> riverStack = new Stack<>();

        riverStack.add(new Integer[]{i,j});
        int riverSize = 0;
        while(riverStack.size()>0)
        {
            Integer[] element = riverStack.pop();
            i = element[0];
            j = element[1];
            if(visitedMatrix[i][j])
            {
                continue;
            }
            visitedMatrix[i][j] = true;
            if(matrix[i][j] == 0)
            {
                continue;
            }
            riverSize++;
            List<Integer[]> unexploredNodes = getUnexploredNodes(i,j,matrix,visitedMatrix);
            for(Integer[] elementpair : unexploredNodes)
            {
                riverStack.add(elementpair);
            }

        }

        if(riverSize>0)
        {
            riverSizes.add(riverSize);
        }

    }

    public List<Integer[]> getUnexploredNodes(int i, int j,int[][] matrix,boolean[][] visitedMatrix)
    {
        List<Integer[]> unexploredList = new ArrayList<>();

        //check right node
        if( ( (j+1)< matrix[0].length) && (!visitedMatrix[i][j+1]))
        {
            unexploredList.add(new Integer[]{i,j+1});
        }
        //check left node
        if( ((j-1)>-1) && (!visitedMatrix[i][j-1]) )
        {
            unexploredList.add(new Integer[]{i,j-1});

        }
        //check top node
        if( ((i-1)>-1) && (!visitedMatrix[i-1][j]))
        {
            unexploredList.add(new Integer[]{i-1,j});

        }

        //check bottom node
        if( ((i+1)< matrix.length) && (!visitedMatrix[i+1][j]))
        {
            unexploredList.add(new Integer[]{i+1,j});

        }

        return unexploredList;
    }

}
