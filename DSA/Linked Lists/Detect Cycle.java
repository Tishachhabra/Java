/*
Link - https://leetcode.com/problems/linked-list-cycle/
*/

//Bruteforce : HashMap tracking address freq
public boolean hasCycle(ListNode head) 
{
    HashMap<ListNode,Integer> map=new HashMap<>();            //stores addresses and 1 as frequency,when it add up, cycle is there
    ListNode node=head;
    while(node!=null)                                        //non-cyclic
    {
        if(map.containsKey(node))                             //if address has occurred previously
        break;
        else
        map.put(node,1);
      
        node=node.next;
    }
    if(node==null)
    return false;
    else
    return true;
}

//Best : Two pointers - slow & fast (Floyd's Cycle-Finding Algorithm)
//Employs 2 pointers moving at different speeds. If there is a cycle, the fast pointer will eventually catch up to the slow pointer, confirming cycle.

public boolean hasCycle(ListNode head) 
{
    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast && slow!=null)
        return true;
    }
    return false;
}
