/*
Link - https://www.geeksforgeeks.org/problems/ancestors-in-binary-tree/1

// Intuition : whenever target found it has to return with that info(boolean flag) , so at every node cur check with either subtrees if returned boolean is true then add cur data into arr
*/

class Solution 
{
    boolean found=false;
    public boolean func(Node cur,int target,ArrayList<Integer> arr)     //boolean func to know if found target
    {
        if(cur==null) return false;                 //negative case 
        
        if(cur.data==target)                        //target found
        {
            return true;
        }
        if(func(cur.left, target,arr) || func(cur.right, target,arr))   //wherever found it needs to be added
        {
            arr.add(cur.data);
            return true;
        }
        return false;               //not found from either subtrees
        
    }
    public ArrayList<Integer> Ancestors(Node root, int target) 
    {
        if(root.data==target)                       //base case
        return new ArrayList<Integer> ();           //return empty arr if root is the target
        ArrayList<Integer> arr=new ArrayList<>();
        func(root,target,arr);
        return arr;
    }
}
