/*
Link-https://www.geeksforgeeks.org/problems/sort-a-linked-list/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
*/

class Solution
{
    static Node mergeSort(Node head)
    {
        if(head==null || head.next == null)
        return head;
        
        Node middle=split(head);
        Node nextofmiddle=middle.next;
        middle.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(nextofmiddle);
        head=merge(left,right);
        return head;
    }
    static Node split(Node head)
    {
        if (head == null)
            return head;
        Node slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right)
    {
        if(left==null)
        return right;
        if(right==null)
        return left;
        Node result=null;
        Node head;
        
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
