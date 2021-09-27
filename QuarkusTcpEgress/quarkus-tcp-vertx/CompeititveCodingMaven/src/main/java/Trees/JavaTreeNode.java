package Trees;

public class JavaTreeNode {

    //Value of node
    private int key;
    private JavaTreeNode left;
    private JavaTreeNode right;

    public JavaTreeNode(int key, JavaTreeNode left, JavaTreeNode right)
    {
        this.left = left;
        this.right= right;
        this.key = key;
    }


    public JavaTreeNode getLeftNode()
    {
        return this.left;
    }

    public JavaTreeNode getRightNode()
    {
        return this.right;
    }

    public int getKey()
    {
        return this.key;
    }

}
