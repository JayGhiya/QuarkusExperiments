package Recursion;

//Permutations of a string
public class PermutationsOfAString {

    public void printPermutationsOfaString(String s)
    {
        findPermutations(s,0,s.length()-1);
    }

    private void findPermutations(String s,int left,int right)
    {
        //base case
        if(left == right)
        {
            System.out.println(s);
        }
        else
        {
            for(int i = left;i<=right;i++)
            {
                String result = swap(s,left,i);
                findPermutations(result,left+1,right);
            }
        }
    }

    private String swap(String s,int swapOne,int swapTwo)
    {
        char[] charArr = s.toCharArray();
        char temp = charArr[swapOne];
        charArr[swapOne] = charArr[swapTwo];
        charArr[swapTwo] = temp;
        return String.valueOf(charArr);
    }

}
