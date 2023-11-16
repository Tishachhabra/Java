/*
Link - https://www.codingninjas.com/studio/problems/flatten-the-multi-level-linked-list_839810?leftPanelTabValue=SOLUTION
*/

//Traverse and save child nodes in arraylist,when reach tail attach child node from arraylist - O(n), Space - O(n)
public static Node flattenMultiLinkedList(Node head) 
{
    Node node=head;
		ArrayList<Node> next_row=new ArrayList<Node>();
		while(node!=null || (!next_row.isEmpty()))
		{
			if(node.child!=null)
			next_row.add(node.child);
			if(node.next==null && !next_row.isEmpty())
			{
				node.next=next_row.get(0);
				next_row.remove(0);
			}
			node=node.next;
		}
		return head;
}

//2 ptrs- cur & tail , reach tail of frst row,search for child of cur,if found attach and update tail
public static Node flattenMultiLinkedList(Node head) 
{
  Node cur=head;
  Node tail=cur;
  while(tail.next!=null)
  {	tail=tail.next;	}

  while(cur!=null)
  {
    if(cur.child!=null)
    {
      tail.next=cur.child;
      Node tmp=cur.child;
      while(tmp.next!=null)
      {
        tmp=tmp.next;
      }
      tail=tmp;
    }
    cur=cur.next;
  }
  return head;
}

