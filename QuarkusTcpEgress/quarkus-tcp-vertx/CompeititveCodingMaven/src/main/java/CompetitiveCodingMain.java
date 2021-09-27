import Array.*;
import Educative.SlidingWindow.AverageOfAllContigousArrayOfSizeK;
import Educative.SlidingWindow.LongestSubstringWithNoMoreThanKDistinctCharacters;
import Educative.SlidingWindow.NoRepeatSubstring;
import Educative.SlidingWindow.SmallestSubarrayWithAGivenSum;
import Graphs.BoggleBoard;
import Graphs.RiverSizes;
import Heaps.JavaHeap;
import Recursion.Factorial;
import Recursion.PermutationsOfAString;
import Recursion.PermutationsOfArray;
import Sorting.HeapSort;
import Sorting.MergeSort;
import Sorting.QuickSort;
import Sorting.ThreeNumberSort;
import Strings.CaeserCipherEncryptor;
import Strings.LongestPalindromicSubstring;
 import Strings.RunLengthEncoding;
import com.sun.source.tree.CaseTree;
import microsoft.miscelllanous.SimpleSortedUsingStringCompression;
import searching.BinarySearch;
import searching.FindTheMajorityElement;
import searching.SearchInASortedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.youtube.com/watch?v=TnZHaH9i6-0
 */
public class CompetitiveCodingMain {

    public static void main(String args[]) {
        /*RemoveKthNodeFromEnd removeKthNodeFromEnd = new RemoveKthNodeFromEnd();
        //preparing a linkedlist
        LinkedList LinkedList = new LinkedList(0);
        LinkedList.addNewNode(new LinkedList(1)).addNewNode(new LinkedList(1))
                .addNewNode(new LinkedList(3)).addNewNode(new LinkedList(4)).addNewNode(new LinkedList(5))
        .addNewNode(new LinkedList(6))
        .addNewNode(new LinkedList(7))
        .addNewNode(new LinkedList(8))
        .addNewNode(new LinkedList(9))
        ;

        removeKthNodeFromEnd.removeNodeFromEnd(LinkedList,10);*/

        /*QuickSort quickSort = new QuickSort();
        int[] sortedArray = quickSort.doQuickSort(new int[]{9,8,7,8,3,4,2,1});

        for(int element: sortedArray)
        {
            System.out.print(element+" ");
        }*/

//        PascalTriangle pascalTriangle = new PascalTriangle();
//        List<List<Integer>> result = pascalTriangle.generate(2);
//
//        for(List<Integer> currentRow : result)
//        {
//            for(int element: currentRow)
//            {
//                System.out.print(element+" ");
//            }
//            System.out.println("");
//        }
//
        HeapSort heapSort = new HeapSort();
        /*int[] result = heapSort.createMaxHeap(new int[]{1,2,4,6,7,8});
        for(int element: result)
        {
            System.out.print(element+" ");
        }*/

//       int[] result =  heapSort.doHeapSort(new int[]{4,
//               1,
//               5,
//               0,
//               -9,
//               -3,
//               -3,
//               9,
//               3,
//               -4,
//               -9,
//               8,
//               1,
//               -3,
//               -7,
//               -4,
//               -9,
//               -1,
//               -7,
//               -2,
//               -7,
//               4});
//       for(int element: result)
//       {
//           System.out.print(element+" ");
//       }

/*
        Factorial factorial = new Factorial();
        System.out.println(factorial.findFactorialOfANum(5));
*/
//        PermutationsOfAString permutationsOfAString = new PermutationsOfAString();
//        permutationsOfAString.printPermutationsOfaString("ABC");

        /*NextPermutation nextPermutation = new NextPermutation();
        int[] result = nextPermutation.doNextPermutation(new int[]{1,5,8,4,7,6,5,3,1});
        for(int element: result)
        {
            System.out.print(+element+" ");
        }*/

        /*MergeSort mergeSort = new MergeSort();
        int[] finalArray = mergeSort.doMergeSort(new int[]{2,4,1,6,8,5,3,7});
        for(int element: finalArray)
        {
            System.out.print(element+" ");
        }*/

        //System.out.println("Number of counting inversions are:"+ new CountInversionsInAnArray().doCountingOfInversions(new int[]{1, 20, 6, 4, 5}));

     /*   BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        System.out.println("Maximum profit is:"+bestTimeToBuyAndSellStock.findMaximumProfit(new int[]{7,1,4,6,3}));*/


        /*RotateTheMatrix rotateTheMatrix = new RotateTheMatrix();
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] rotatedMatrix = rotateTheMatrix.rotate(matrix);

        for(int i = 0 ; i < rotatedMatrix.length ; i++)
        {
            for(int j =0 ; j < rotatedMatrix[0].length ; j++)
            {
                System.out.print(rotatedMatrix[i][j]+" ");
            }
            System.out.println();
        }*/
        /*int[][] matrix = new int[][]{
                {1,0,0,1,0},
                {1,0,1,0,0},
                {0,0,1,0,1},
                {1,0,1,0,1},
                {1,0,1,1,0}
        };

        RiverSizes riverSizes = new RiverSizes();
        List<Integer> riversizes = riverSizes.riverSizes(matrix);
        for(Integer element: riversizes)
        {
            System.out.print(element+" ");
        }*/

        /*BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.findElementUsingBinarySearch(new int[]{1,4,6,8,9},1));*/

        /*SearchInA2dArrayLeetCode searchInA2dArrayLeetCode = new SearchInA2dArrayLeetCode();
        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println("result is:"+searchInA2dArrayLeetCode.searchMatrix(matrix,13));*/


        /*FindTheMajorityElement findTheMajorityElement = new FindTheMajorityElement();

        System.out.println("majority element is:"+findTheMajorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));*/

        /*String[] stringwords = new String[]{"this","is","not","a","simple","boggle","board","test","REPEATED","NOTRE-PEATED"};

        char[][] board = new char[][]{
                {'t','h','i','s','i','s','a'},
                {'s','i','m','p','l','e','x'},
                {'b','x','x','x','x','e','b'},
                {'x','o','g','g','l','x','o'},
                {'x','x','x','D','T','r','a'},
                {'R','E','P','E','A','d','x'},
                {'x','x','x','x','x','x','x'},
                {'N','O','T','R','E','-','P'},
                {'x','x','D','E','T','A','E'},
        };

        List<String> answer = BoggleBoard.boggleBoard(board,stringwords);

        for(String word:answer)
        {
            System.out.print(word+" ");
        }*/

/*        MajorityElementTwo majorityElementTwo = new MajorityElementTwo();
        List<Integer> result = majorityElementTwo.majorityElement(new int[]{4,2,1,1});

        for(Integer ans:result)
        {
            System.out.print(ans+" ");
        }*/


        /*AverageOfAllContigousArrayOfSizeK averageOfAllContigousArrayOfSizeK = new AverageOfAllContigousArrayOfSizeK();
        for(double ans: averageOfAllContigousArrayOfSizeK.findAverages(5,new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}))
        {
            System.out.print(ans+ " ");
        }*/


/*
        SmallestSubarrayWithAGivenSum smallestSubarrayWithAGivenSum = new SmallestSubarrayWithAGivenSum();
        int output = smallestSubarrayWithAGivenSum.findMinSubArray(7,new int[]{2,1,5,2,3,2});
        System.out.println("output:"+output);
*/
//        System.out.println(""+LongestSubstringWithNoMoreThanKDistinctCharacters.findLength("araaci",2));
    /*    int[][] newArray = new int[][]{{1,4,7,12,15,1000},
                {2,5,19,31,32,1001},
                {3,8,24,33,35,1002},
                {40,41,42,44,45,1003},
                {99,100,103,106,128,1004}};
        int[] result = SearchInASortedMatrix.searchInSortedMatrix(newArray,44);
*/

        /*String encryptedResult = CaeserCipherEncryptor.caesarCypherEncryptor("abc",52);
        System.out.println(encryptedResult+"encryptedResult");
*/

        /*RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        System.out.println("Run length Encoded String is:"+runLengthEncoding.runLengthEncoding(" "));
*/

/*
        List<Integer> exampleArrayList = new ArrayList<>();
        exampleArrayList.add(1);
        exampleArrayList.add(2);
        exampleArrayList.add(3);

        PermutationsOfArray.getPermutations(exampleArrayList);
*/
/*
        NoRepeatSubstring noRepeatSubstring = new NoRepeatSubstring();
        System.out.println("the max length is:"+noRepeatSubstring.findLength("abccde"));
*/
        /*PermutationsOfArray.getPermutations(new ArrayList<>(Arrays.asList(
         1,2,3
        )));*/


        /*ThreeNumberSort threeNumberSort = new ThreeNumberSort();
        int[] result = threeNumberSort.threeNumberSort(new int[]{1,0,0,-1,-1,0,1,1},new int[]{0,1,-1});
        for(int x:result)
        {
            System.out.print(x+" ");
        }*/

        //System.out.println("Current Length:"+LongestPalindromicSubstring.longestPalindromicSubstring("abaxyzzyxf"));

        /*TrappingRainWater trappingRainWater = new TrappingRainWater();
        trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
*/
        /*MaxNonNegativeSubArray maxSumContiguosArray = new MaxNonNegativeSubArray();

        int[] ans = maxSumContiguosArray.maxset(new int[]{ 756898537, -1973594324, -2038664370, -184803526, 1424268980  });

        for(int i = 0; i < ans.length ; i++)
        {
            System.out.print(ans[i]+" ");
        }*/

/*
        AddOneToNumber addOneToNumber = new AddOneToNumber();
        int[] result = addOneToNumber.plusOne(new int[]{1,2,9});
*/
/*

        for(int i = 0; i <result.length;i++)

        {
            System.out.print(result[i]+" ");
        }
*/

       /* MaximumGap maximumGap = new MaximumGap();
        System.out.println("max gap is"+maximumGap.maximumGap(new int[]{3,6,9,1}));
*/

        /*CheckKeyInEverySegment checkKeyInEverySegment = new CheckKeyInEverySegment();
        System.out.println(""+checkKeyInEverySegment.findXinKWindowSize(11,new int[]{4,5,2,4,9,3,1,7,3,11,3},3,3));*/

       /* MinAndMaxInAArray minAndMaxInAArray = new MinAndMaxInAArray();
        minAndMaxInAArray.getMinAndMax(new int[]{12,1234,45,67,1},5);*/

        //kth max/min element
/*
        JavaHeap javaHeap = new JavaHeap();
        javaHeap.convertArrayIntoMinHeap(new int[]{1,3,5,4,6,13,10,9,8,15,17});
*/

/*
        IsoMorPhicStrings isoMorPhicStrings = new IsoMorPhicStrings();
        boolean result = isoMorPhicStrings.isPairIsomorphic("css","dll");
        System.out.println("result is:"+result);
*/

        SimpleSortedUsingStringCompression simpleSortedUsingStringCompression = new SimpleSortedUsingStringCompression();
        System.out.println(simpleSortedUsingStringCompression.compress("aabbbcddddeeeeef"));
    }

}
