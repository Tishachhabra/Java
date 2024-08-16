// Merge recursively the lists by taking 2-2 , merge lists in bottom 

class Solution {
    public static Node merge(Node head1, Node head2) {
      
        // A dummy first node to store the result list
        Node dummy = new Node(-1);

        // Tail points to the last result node to add new nodes to the result
        Node tail = dummy;

        // Iterate till either head1 or head2 does not reach null
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
              
                // Append head1 to the result
                tail.bottom = head1;
                head1 = head1.bottom;
            }
            else {
              
                // Append head2 to the result
                tail.bottom = head2;
                head2 = head2.bottom;
            }

            // Move tail pointer to the next node
            tail = tail.bottom;
        }

        // Append the remaining nodes of the non-null list
        if (head1 != null)
            tail.bottom = head1;
        else 
            tail.bottom = head2;
        
        return dummy.bottom;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        // Recur for next list
        root.next = flatten(root.next);

        // Now merge the current and next list
        root = merge(root, root.next);

        // Return the root
        return root;
    }
}
