// Take lists as elements and merge sort the array

class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
  {
        if (lists == null || lists.length == 0) 
        {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end)                                                     //base case when 1 is left to sort
        {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode leftList = mergeLists(lists, start, mid);
        ListNode rightList = mergeLists(lists, mid + 1, end);
        
        return merge(leftList, rightList);
    }

    static Node merge(Node left,Node right)
    {
        if(left==null)
        return right;
        if(right==null)
        return left;
        Node result=null;
        
        if(left.data<=right.data)
        {
            result=left;
            result.next = merge(left.next, right);
        }
        else
        {
            result=right;
            result.next = merge(left, right.next);
        }
        return result;
    }
}
