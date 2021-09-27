package Recursion;

public class Factorial {


    public int findFactorialOfANum(int number)
    {
        if(number == 1)
        {
            return number;
        }
        int result = number * findFactorialOfANum(number-1);
        return result;
    }
}
