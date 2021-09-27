package LinkedList;

public class RemoveKthNodeFromEnd {



    public void removeNodeFromEnd(LinkedList head, int k)
    {
        // Write your code here.
        LinkedList firstPointer = head;
        LinkedList secondPointer = head;

        for(int i = 0 ; i < k ; i ++)
        {
            secondPointer = secondPointer.next;
        }

        if(secondPointer == null)
        {
            head.value  = head.next.value;
            head.next = head.next.next;
            return;
        }
        while(secondPointer.next!=null)
        {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        firstPointer.next = firstPointer.next.next;

    }


}
