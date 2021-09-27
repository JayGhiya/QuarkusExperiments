package Heaps;


//Heap is special type of binary tree (there are can be two heaps  - min heap and max heap)
//They are represented as level order traversal in an array
//Parent node can be found for current index in array by (i-1)/2
//Left node can be found for current index in array by 2*i+1
//Right node can be found for current index in array by 2*i+2
public class JavaHeap {


    private void heapify(int[] array,int size,int i)
    {
        //assume largest is current element
        int largest = i;
        //check if left is larger than largest
        int leftNode = (2*i)+1;
        int rightNode = (2*i)+2;
        if( (leftNode<size) && (array[leftNode]>array[largest]))
        {
            largest=leftNode;
        }

        if( (rightNode<size) && array[rightNode]>array[largest])
        {
            largest=rightNode;
        }

        //Now Swap
        if(largest!=i)
        {
            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;

            //now heapify also subtree
            heapify(array,array.length,largest);
        }

    }


    public void convertArrayIntoMinHeap(int[] arr)
    {
        //find the last non-leaf node as leaf node already follow properties of heap

        //parent node of last leaf node is last non-leaf node
        int lastNonLeafNode = (arr.length)/2 - 1;
        System.out.println("last non leaf node is:"+lastNonLeafNode);
        for(int i = lastNonLeafNode;i>=0;i--)
        {
            heapify(arr,arr.length,i);
        }

        //Print the heapified array
        for(int i =0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }




}
