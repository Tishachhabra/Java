/*
Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

//slow and fast pointer will be kept at dist of n , when fast reaches null,slow must hve reached node to be deleted
public ListNode removeNthFromEnd(ListNode head, int n) 
{
    ListNode slow=head;
    ListNode fast=head;
  
    for(int i=1;i<=n;i++)                      //slow and fast remain at a distance of n
    fast=fast.next;
    
    if(fast==null)                            //corner case when head is to be removed
    return head.next;
    while(fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next;
    }
    slow.next=slow.next.next;                        //remove slow.next node
    return head;
}
