/*
  Definition for singly-linked list :-
  public class ListNode 
  {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 */

public ListNode reverseList(ListNode head) 
{
    ListNode cur_node=head;
    ListNode prev=null;
    ListNode saved;
    while(cur_node!=null)
    {
        saved=cur_node.next;
        cur_node.next=prev;
        prev=cur_node;
        cur_node=saved;
    }
    return prev;
}
