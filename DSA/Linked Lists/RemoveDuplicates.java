/*
Link - https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
*/

public Node removeDuplicates(Node head) 
{
   HashSet<Integer> set=new HashSet<Integer>();          //HashSet to maintain unique elements
   Node prev=null;
   Node cur=head;
   while(cur!=null)
   {
     if(set.contains(cur.data))
     {
         prev.next=cur.next;                             //If found in HashSet , delete
     }
     else
     {
        set.add(cur.data);                              // If not found, add in set
        prev=cur;
     }
     
     cur=cur.next;
   }
   return head;
}
