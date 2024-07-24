// Naive - O (n^2) : at every node call getMax() from left subtree and getMin() from right subtree then check current is in range + recursion to subtrees
// Best - O (n) : maintain range to every cur node in recursion + check range + left & right subtree condition

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) 
    {
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isBSTUtil(Node root,int min,int max)
    {
        if(root==null)
        return true;
        
        if(root.data<min || root.data>max)
        return false;
        
        return (isBSTUtil(root.left,min,root.data-1) && isBSTUtil(root.right,root.data+1,max) );
    }
}
