/*
Link - https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
*/

Node divide(int N, Node head)
    {
        Node even=null,odd=null,e=null,o=null;
        Node cur=head;
        while(cur!=null)                        //traversal
        {
            if(cur.data%2==0)                   //even
            {
                if(even==null)
                {
                    even=cur;
                    e=cur;
                }
                else
                {e.next=cur; e=cur;}
            }
            else                            //odd
            {
                if(odd==null)
                {
                    odd=cur;
                    o=cur;
                }
                else
                {
                    o.next=cur;
                    o=cur;
                }
            }
            cur=cur.next;
        }
        if(e!=null) e.next=odd;
        if(o!=null) o.next=null;
        if(even!=null) return even;
        return odd;
    }
