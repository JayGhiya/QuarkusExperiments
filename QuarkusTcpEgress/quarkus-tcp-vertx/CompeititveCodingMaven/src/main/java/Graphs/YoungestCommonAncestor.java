package Graphs;



public class YoungestCommonAncestor {
    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int depthOne = getDepthOfDescendant(topAncestor,descendantOne);
        int depthTwo = getDepthOfDescendant(topAncestor,descendantTwo);
        AncestralTree youngestCommonAncestor = null;
        if(depthTwo>depthOne)
        {
            //get depthtwo to the same level as depthOne
            AncestralTree modifiedDescendant = getToTheSameLevel(descendantTwo,depthTwo,depthOne);
            //now iterate till youngest common ancestor is found
            youngestCommonAncestor =  getYoungestAncestor(modifiedDescendant,descendantTwo);
        }
        else if(depthTwo<depthOne)
        {
            //get depthOne to the same level as depthTwo
            AncestralTree modifiedDescendant = getToTheSameLevel(descendantOne,depthOne,depthTwo);
            //now iterate till youngest common ancestor is found
            youngestCommonAncestor =  getYoungestAncestor(modifiedDescendant,descendantOne);
        }
        else
        {
            //same level
            //iterate till they have a common ancestor
            youngestCommonAncestor =  getYoungestAncestor(descendantTwo,descendantOne);
        }

        return youngestCommonAncestor; // Replace this line
    }

    public static AncestralTree getYoungestAncestor(AncestralTree descendantOne,AncestralTree descendantTwo)
    {
        while(descendantOne.ancestor!=descendantTwo.ancestor)
        {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        return descendantOne.ancestor;
    }

    public static AncestralTree getToTheSameLevel(AncestralTree deeperNode,int startDepth,int targetDepth)
    {
        while(startDepth!=targetDepth)
        {
            deeperNode = deeperNode.ancestor;
            startDepth--;
        }
        return deeperNode;
    }

    public static int getDepthOfDescendant(AncestralTree topAncestralTree,AncestralTree descendantOne)
    {
        int depth = 0;
        while(descendantOne.ancestor!=topAncestralTree)
        {
            depth++;
            descendantOne=descendantOne.ancestor;
        }
        return depth;
    }



}
