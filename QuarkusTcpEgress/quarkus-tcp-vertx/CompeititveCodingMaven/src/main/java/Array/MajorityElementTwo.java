package Array;


import java.util.ArrayList;
import java.util.List;

//leet code majority element 2
//Boyor moore voting algorithm (majority element > n/3)
public class MajorityElementTwo {

    public List<Integer> majorityElement(int[] nums) {

        //as number has to be greater than n/3 there can be at max two majority elements and at minimum 1 element

        //let us initialize maximum integers
        //TODO: error if numbers are kept -1
        int majorityOne = -1;
        int majorityTwo = -1;
        int countOne = 0;
        int countTwo = 0;

        List<Integer> finalResult = new ArrayList<>();

        for(int number:nums)
        {
            if(number == majorityOne) countOne++;
            else if(number == majorityTwo) countTwo++;
            else if(countOne == 0) {
                majorityOne = number;
                countOne++;
            }
            else if(countTwo == 0) {
                majorityTwo = number;
                countTwo++;
            }
            else
            {
                countOne--;
                countTwo--;
            }
        }
        int majoritybenchmark = Math.floorDiv (nums.length,3);

        //now as countone and counttwo can decrease while encounteering other
        //numbers so need to do a second pass

        countOne = 0;
        countTwo = 0;

        for(int num : nums)
        {
            if(majorityOne!=-1 && majorityOne == num)
            {
                countOne++;
            }
            else if(majorityTwo!=-1 && majorityTwo == num)
            {
                countTwo++;
            }

        }

        if(countOne>Math.floorDiv(nums.length,3))
        {
            finalResult.add(majorityOne);
        }
        if(countTwo>Math.floorDiv(nums.length,3))
        {
            finalResult.add(majorityTwo);
        }

        return finalResult;
    }

}
