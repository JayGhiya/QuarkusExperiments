package LinkedList;

import java.util.*;

public class FindLoop {
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList firstPointer = head.next;
        LinkedList secondPointer = head.next.next;

        while(firstPointer!=secondPointer)
        {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }
        firstPointer = head;
        //now loop is found now let us find origin of the loop
        while(firstPointer!=secondPointer)
        {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        return firstPointer;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
