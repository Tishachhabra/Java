/*
Link - https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
*/

//Bruteforce - 2 nested loops,address checks - O(n^2)
//Better Approach - Traverse bigger list and add all nodes to a set. Traverse other list and check if node is in set - O(m+n), Space - O(max(m,n))

int intersectPoint(Node node1, Node node2)
{
  HashSet<Node> set=new HashSet<Node>();
    while(node1!=null)
    {
      set.add(node1);
      node1=node1.next;
    }
    while(node2!=null)
    {
      if(set.contains(node2))
      return node2.data;
      node2=node2.next;
    }
    return -1;
}

//Best Approach - Traverse both lists to know size, traverse bigger list to (count1-count2),then travel both lists together checking common node - O(m+n), Space - O(1)

	int intersectPoint(Node head1, Node head2)
	{
       Node cur1=head1;
       Node cur2=head2;
       int count1=0;
       int count2=0;
       while(cur1!=null)
       {
          ++count1;
          cur1=cur1.next;
       }
       while(cur2!=null)
       {
          ++count2;
          cur2=cur2.next;
       }
       int d=Math.abs(count1-count2);
       if(count1>count2)
       return getIntersection(d,head1,head2);
       else
       return getIntersection(d,head2,head1);
	}

int getIntersection(int d,Node cur1,Node cur2)
{
  for(int i=0;i<d;i++)
  {
    cur1=cur1.next;
  }
  while(cur1!=null && cur2!=null)
  {
    if(cur1==cur2)
    return cur1.data;
    cur1=cur1.next;
    cur2=cur2.next;
  }
  return -1;     
}
