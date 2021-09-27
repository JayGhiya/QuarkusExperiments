package Trees;

public class DifferentTraversalsForTree {

    //left,root,right
    public void doInorderTraversal(JavaTreeNode root)
    {
        //Stopping condition for recursion
        if(root == null)
        {
            return;
        }

        doInorderTraversal(root.getLeftNode());
        System.out.println(root.getKey()+" ");
        doInorderTraversal(root.getRightNode());
    }

    //root,left,right
    public void doPreorderTraversal(JavaTreeNode root)
    {
        if(root==null)
            return;

        System.out.println(root.getKey()+" ");
        doPreorderTraversal(root.getLeftNode());
        doPreorderTraversal(root.getRightNode());
    }

    //left,right,root
    public void doPostorderTraversal(JavaTreeNode root)
    {
        if(root==null)
            return;

        doPostorderTraversal(root.getLeftNode());
        doPostorderTraversal(root.getRightNode());
        System.out.print(root.getKey()+" ");


    }
}
