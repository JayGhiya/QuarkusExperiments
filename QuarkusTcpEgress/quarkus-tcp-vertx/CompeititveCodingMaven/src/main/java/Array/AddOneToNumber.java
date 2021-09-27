package Array;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :
 *
 * Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */

public class AddOneToNumber {

    public int[] plusOne(int[] A) {

        int start = 0;
        while(A[0]==0 && A.length!=1)
        {
            start=1;
            A = Arrays.copyOfRange(A,start,A.length);
            start = 0;
        }
        for(int i =A.length-1;i>=0;i--) {

            int currDigit = A[i];

            if(currDigit+1 == 10)
            {
                A[i] = 0;

            }
            else
            {
                A[i] +=1;
                //check if there are zeroes before
                return A;
            }

        }

        //still carry is there

        A = new int[A.length+1];
        A[0] = 1;

        for(int i =1;i<A.length;i++)
        {
            A[i] = 0;
        }

        return A;
    }
}
