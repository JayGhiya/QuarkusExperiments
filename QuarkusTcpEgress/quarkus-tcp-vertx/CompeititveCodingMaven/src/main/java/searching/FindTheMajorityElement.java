package searching;

//https://leetcode.com/problems/majority-element/
public class FindTheMajorityElement {

    //moore's voting algorithm
    public int majorityElement(int[] nums) {
        //keep a count variable
        //keep a element variable
        int count = 0;
        int element = 0;
        for ( int  i = 0 ; i < nums.length;i++)
        {
            if(count == 0)
            {
                element = nums[i];
            }
            if(element == nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return element;
    }

}
