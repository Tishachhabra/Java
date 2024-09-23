public void reorderList(ListNode head) 
    {
        ListNode slow=head,fast=head,temp=head;
      while(fast.next!=null && fast.next.next!=null)        //middle of list
      {
          fast=fast.next.next;
          slow=slow.next;
      }  
      ListNode next=null,prev=null,current=slow;            //reverse
      while(current!=null)
      {
          next=current.next;
          current.next=prev;
          prev=current;
          current=next;
      }
      ListNode p=temp,q=prev;                              //temp is orig head , prev is reversed list head
      while(prev!=null && temp!=null)                      //changing pointers
      {                 
          p=p.next;                
          q=q.next;
          temp.next=prev;
          prev.next=p;   
          temp=p;    
          prev=q;
      }
    }
