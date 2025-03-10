//Tortoise Hare method : slow-fast pointers


public ListNode middleNode(ListNode head) 
    {
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null)    //'AND' condition
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
