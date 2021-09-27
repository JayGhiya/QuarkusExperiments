package Educative.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class AverageOfAllContigousArrayOfSizeK {

    List<Double> arrayListForAvergaes = new ArrayList<>();

    public double[] findAverages(int K, int[] arr)
    {
        int sum = 0;
        for(int i = 0 ; i < arr.length ;i++)
        {

            if(arrayListForAvergaes.size() == 0)
            {
                //for the first tme calculate
                for(int j = i ; j<K ;j++)
                {
                    sum+=arr[j];
                }
                arrayListForAvergaes.add( Double.valueOf(sum/(double)K) );
            }
            else {
                //sliding window
                //to check if it is not overflowing
                if( (i + (K - 1)) < arr.length ) {
                    sum -= arr[i - 1];
                    sum += arr[i + (K - 1)];
                    arrayListForAvergaes.add(Double.valueOf(sum /(double) K));
                }
            }
        }


        return arrayListForAvergaes.stream().mapToDouble(d->d).toArray();
    }



}
