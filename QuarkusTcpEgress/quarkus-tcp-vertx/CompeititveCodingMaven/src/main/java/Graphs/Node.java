package Graphs;

import java.util.List;

public class Node {
    private String name;

    private List<Node> children;

    //constructor
    public Node(String name)
    {
        this.name = name;
    }

    public Node addChild(String name)
    {
        this.children.add(new Node(name));
        return this;
    }

    public List<String> doDFS(List<String> arr)
    {
        arr.add(this.name);
        for(int i = 0 ; i < children.size() ; i++)
        {
            children.get(i).doDFS(arr);
        }
        return arr;
    }



}
