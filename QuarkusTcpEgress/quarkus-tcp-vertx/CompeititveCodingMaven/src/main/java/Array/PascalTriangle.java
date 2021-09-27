package Array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        if(numRows == 0)
        {
            return  new ArrayList<>();
        }
        //initializing an List
        List<List<Integer>> pascalList = new ArrayList<List<Integer>>();

        //initialzing first Lis
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        pascalList.add(firstList);

        if(numRows == 1)
        {
            return pascalList;
        }

        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(1);
        pascalList.add(secondList);

        for(int i = 1 ; i < numRows-1 ; i++)
        {
            List<Integer> tempPascalList = new ArrayList<>();
            tempPascalList.add(1);
            int tempPointer = 1;
            List<Integer> previousList = pascalList.get(i);
            while(tempPointer < i+1)
            {
                int currElement = previousList.get(tempPointer-1) + previousList.get(tempPointer);
                tempPascalList.add(currElement);
                tempPointer++;
            }
            tempPascalList.add(1);
            pascalList.add(tempPascalList);
        }

    return pascalList;

    }

}
