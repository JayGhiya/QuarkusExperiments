package Array;

public class TrappingRainWater {

    public int trap(int[] height) {

        int maxLeft[] = new int[height.length];

        int maxRight[] = new int[height.length];

        maxLeft[0] = height[0];
        maxRight[height.length-1] = height[height.length-1];


        //let  us calculate the max left
        for(int i = 1; i<height.length;i++)
        {

            maxLeft[i] = Math.max(height[i],maxLeft[i-1]);


            System.out.print(maxLeft[i]+" ");
        }
        System.out.println();

        //now let us calculate for the right
        for(int i = height.length-2 ; i>-1 ; i--)
        {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);

            System.out.print(maxRight[i]+" ");
        }
        System.out.println();
        //now find min of both - height of current building to find total amount of water stored

        int trappedWater = 0;
        for(int i = 0 ; i < height.length ; i++)
        {
            trappedWater+=(Math.min(maxLeft[i],maxRight[i]) - height[i]);
        }
        System.out.println("trapped water"
                +trappedWater);
        return trappedWater;
    }
}
