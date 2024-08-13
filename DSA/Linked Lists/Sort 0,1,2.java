// 1) Sort by converting to ArrayList then Collections.sort()        --- O (nlogn)
// 2) Count then fill - O(2n)
public static Node sortList(Node head) 
    {
        int zero=0,one=0,two=0;
        Node node=head;
        while(node!=null)
        {
            if(node.data==0)
            zero++;
            else if(node.data==1)
            one++;
            else
            two++;
            node=node.next;
        }
        node=head;
        while (zero > 0 ) 
        {
          node.data = 0;
          node = node.next;
          --zero;
        }
        while (one > 0 ) 
        {
          node.data = 1;
          node = node.next;
          --one;
        }
        while (two > 0 ) 
        {
            node.data = 2;
            node = node.next;
            --two;
        }
    return head;
    }

// Best - maintain 3 pointers to manage 3 linkedlists then join by using dummy nodes.
