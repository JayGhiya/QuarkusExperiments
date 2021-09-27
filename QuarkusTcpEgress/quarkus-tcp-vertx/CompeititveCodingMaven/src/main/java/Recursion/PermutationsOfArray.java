package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArray {

    public static List<List<Integer>> getPermutations(List<Integer> array)
    {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        //pass in the current array,current permutation,and list of permutations
        getPermutations(array,new ArrayList<Integer>(),permutations);
        return permutations;
    }


    public static void getPermutations(List<Integer> array,List<Integer> currentPermutation
    ,List<List<Integer>> permutations)
    {
        //write stopping condition
        if(array.size() ==0 && currentPermutation.size()>0)
        {
            permutations.add(currentPermutation);
        }
        else
        {
            //loop over array
            for(int i = 0 ; i < array.size();i++)
            {
                //initialize a  new list from current array (and remove one element from it )
                List<Integer> newArray = new ArrayList<Integer>(array);
                newArray.remove(i);
                //now create a new permutation from old permutation
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                getPermutations(newArray,newPermutation,permutations);


            }
        }
    }

}
