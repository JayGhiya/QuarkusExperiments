package math;

//https://leetcode.com/problems/powx-n/
public class Pow {

    public double myPow(double x, int n) {
        //handle if n is positive or negative then convert it to positive

        long nn = n;
        //convert into positive
        if(nn<0)
        {
            nn = -1 * nn;
        }
        //now let us find exponential in logarithm
        //initializing the ans
        double ans = 1;
        while(nn>0)
        {
            if( (nn % 2) == 1)
            {
                ans = ans * x;
                nn--;
            }
            else
            {
                x = x*nn;
                nn/=2;
            }
        }
        if(n<0)
        {
            ans = 1 / ans;
        }
        return ans;

    }
}
