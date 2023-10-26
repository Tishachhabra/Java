/*
Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

public ListNode removeNthFromEnd(ListNode head, int n) 
{
    ListNode slow=head;
    ListNode fast=head;
  
    for(int i=0;i<n;i++)                      //slow and fast remain at a distance of n
    fast=fast.next;
    if(fast==null)
    return head.next;
    while(fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next;
    }
    ListNode ptr=slow.next;                 //remove
    slow.next=ptr.next;
    return head;
}
