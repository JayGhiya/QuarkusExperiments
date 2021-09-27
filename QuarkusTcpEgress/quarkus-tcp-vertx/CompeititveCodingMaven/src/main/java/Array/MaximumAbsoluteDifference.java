package Array;

public class MaximumAbsoluteDifference {

    public int maxArr(int[] A) {

        //the algo is to find max of element and index and the min of element and index

        //element + index (find max and min and do max - min that is answer)

        //element - index (find max and min and do max - min that is answer 2)

        //find max of both the answers

        int additionCombination1 = Integer.MIN_VALUE; //max(element + index)
        int additionCombination2 = Integer.MAX_VALUE; // min(element+index)

        int subtractionCombination1 = Integer.MIN_VALUE; //max(element - index)
        int subtractionCombination2 = Integer.MAX_VALUE; //min(element - index)

        for(int i =0 ; i < A.length ; i ++)
        {
            if( (A[i]+i) > additionCombination1)
            {
                additionCombination1 = A[i] + i;
            }

            if( (A[i]+i) < additionCombination2)
            {
                additionCombination2 = A[i] + i;
            }

            if( (A[i]-i) > subtractionCombination1)
            {
                subtractionCombination1 = A[i]-i;
            }

            if( (A[i]-i) < subtractionCombination2)
            {
                subtractionCombination2 = A[i]-i;
            }

        }

        int ans1 = additionCombination1 - additionCombination2;
        int ans2 = subtractionCombination1 - subtractionCombination2;
        return Math.max(ans1,ans2);





    }
}
