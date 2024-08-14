// Hashset to fill nodes addresses then traverse, check & put - O(n) and space=O(n)
public static void removeLoop(Node head)
  {
    HashSet<Node> set=new HashSet<Node>();
    Node prev=head;
    Node node=head.next;
    set.add(head);
    while(node!=null)
    {
        if(set.contains(node))
        break;
        set.add(node);
        prev=node;
        node=node.next;
    }
    prev.next=null;
  }

//Floyd detection algo by slow-fast pointers 
// To remove count number of nodes (k) in loop by 2 pointers + put ptr1 at head while other at k nodes after head + find starting of loop + find ending of loop

static void detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) 
            {
                removeLoop(slow, node);
                return;
            }
        }
    }

    // Function to remove loop
    static void removeLoop(Node loop, Node head)
    {
        Node ptr1 = loop;
        Node ptr2 = loop;

        int k = 1;                      //count of nodes in loop
        while (ptr1.next != ptr2) 
        {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (int i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
// they will meet at loop starting node
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node in the loop
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
      //remove loop 
        ptr2.next = null;
    }
