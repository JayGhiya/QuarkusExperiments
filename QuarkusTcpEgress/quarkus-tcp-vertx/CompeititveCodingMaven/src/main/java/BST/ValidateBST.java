package BST;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        // Write your code here.


        return  helperFunc(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean helperFunc(BST tree,int minValue,int maxValue)
    {

        if(tree.value >= maxValue || tree.value< minValue)
        {
            return false;
        }
        //checking for left
        if(tree.left!=null &&  !helperFunc(tree.left,minValue,tree.value))
        {
            return false;
        }
        if(tree.right!=null &&  !helperFunc(tree.right,tree.value,maxValue))
        {
            return false;
        }
        return true;

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
