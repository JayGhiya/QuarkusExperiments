package LinkedList;

public class LinkedList {
    public int value;
    public LinkedList next = null;

    public LinkedList(int value) {
        this.value = value;
    }

    public LinkedList addNewNode(LinkedList newNode)
    {
        this.next = newNode;
        return this.next;
    }
}