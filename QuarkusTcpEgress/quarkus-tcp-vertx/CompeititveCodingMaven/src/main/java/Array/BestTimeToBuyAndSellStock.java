package Array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

    public int findMaximumProfit(int[] stockArray)
    {
        int maximumProfit = 0;
        int minimum = Integer.MAX_VALUE;

        for(int i = 0 ; i < stockArray.length; i++)
        {
            if(stockArray[i] < minimum)
            {
                minimum = stockArray[i];
            }

            if( (stockArray[i] - minimum) > maximumProfit)
            {
                maximumProfit = (stockArray[i] - minimum);
            }

        }
        return maximumProfit;
    }
}
