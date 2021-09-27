package Educative.SlidingWindow;

import java.util.HashMap;

/*
Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.
 */
public class FruitsIntoBasket {


        public int findLength(String str){

            char[] arr = str.toCharArray();

            int windowStart = 0;
            int maxNumberOfFruitsInTwoBaskets = Integer.MIN_VALUE;
            HashMap<Character,Integer> hashMap = new HashMap<>();

            for(int i = 0 ; i < arr.length;i++ )
            {
                hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
                if(hashMap.size()>2)
                {
                    //remove until there are 2 fruits - start shrinking
                    hashMap.put(arr[windowStart],hashMap.get(arr[windowStart])-1);
                    if(hashMap.get(arr[windowStart])==0)
                    {
                        hashMap.remove(arr[windowStart]);
                    }
                    windowStart++;
                }

                int currNumberOfFruits = i - windowStart +1;
                if(currNumberOfFruits>maxNumberOfFruitsInTwoBaskets)
                    maxNumberOfFruitsInTwoBaskets=currNumberOfFruits;

            }
            return maxNumberOfFruitsInTwoBaskets;

        }
}
