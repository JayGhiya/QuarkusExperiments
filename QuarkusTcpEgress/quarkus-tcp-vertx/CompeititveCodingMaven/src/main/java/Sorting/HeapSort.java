package Sorting;

public class HeapSort {

    public int[] doHeapSort(int[] arr)
    {
        //a heap is a complete binary tree //first let us create a max heap and then do delete operation
        int[] maxHeap = createMaxHeap(arr);
        //now do deletion one by one to get sorted arr
        return deletionOfMaxHeap(maxHeap);
    }


    public int[] createMaxHeap(int[] arr)
    {
        int[] maxHeap = new int[arr.length];
        maxHeap[0] = arr[0];

        for(int i = 1 ; i < arr.length ; i++)
        {
            //algorithm is insert at the last. then go from down to up to find out if the it is following max heap
            if(arr[i] == 8)
            {
                System.out.print("Debug this");
            }
            maxHeap[i] = arr[i];
            int parent = Math.floorDiv(i-1,2);
            int tempPointer = i;
            while( (parent>-1) && maxHeap[parent] < maxHeap[tempPointer] )
            {
                //continue swapping
                int temp = maxHeap[parent];
                maxHeap[parent] = maxHeap[tempPointer];
                maxHeap[tempPointer] = temp;
                tempPointer = parent;
                if(parent % 2 == 0)
                parent = Math.floorDiv(parent, 2)-1;
                else parent = Math.floorDiv(parent, 2);



            }
        }
        return maxHeap;

    }

    public int[] deletionOfMaxHeap(int[] maxHeap)
    {
        int lastElement = maxHeap.length-1;

        while(lastElement>0)
        {
            //deletion in heap always happens at root node
            //swapping root and last node
            int temp = maxHeap[0];
            maxHeap[0] = maxHeap[lastElement];
            maxHeap[lastElement] = temp;
            lastElement--;
            //Now readjusting the whole heap to become once again maxHeap
            int j = 0;
            while( ((((2*j)+1)<=lastElement) || ((((2*j)+2) <= lastElement))) && (maxHeap[j] < Math.max(maxHeap[(2*j)+1], maxHeap[(2*j)+2])))
            {
                //now compare parent with its bigger child
                if(((((2*j)+1)<=lastElement) && ((((2*j)+2) <= lastElement)))) {
                    if ( (maxHeap[(2 * j) + 1] >= maxHeap[(2 * j) + 2]))
                    {
                        //swap with parent
                        int temp2 = maxHeap[j];
                        maxHeap[j] = maxHeap[(2 * j) + 1];
                        maxHeap[(2 * j) + 1] = temp2;
                        j = (2 * j) + 1;
                    }
                else
                    {
                        int temp2 = maxHeap[j];
                        maxHeap[j] = maxHeap[(2 * j) + 2];
                        maxHeap[(2 * j) + 2] = temp2;
                        j = (2 * j) + 2;
                    }
                }
                else if((((2*j)+1)<=lastElement) && (maxHeap[(2*j)+1] > maxHeap[j]))
                {
                    int temp2 = maxHeap[j];
                    maxHeap[j] = maxHeap[(2*j)+1];
                    maxHeap[(2*j)+1] = temp2;
                    j = (2*j)+1;

                }
                else if((((2*j)+2)<=lastElement) && maxHeap[(2*j)+2] > maxHeap[j])
                {
                    int temp2 = maxHeap[j];
                    maxHeap[j] = maxHeap[(2*j)+2];
                    maxHeap[(2*j)+2] = temp2;
                    j = (2*j)+2;
                }
                if(j ==0)
                {
                    break;
                }


            }
        }
        return maxHeap;
    }


}
