//By doubly Linked list

public class myStack 
{
    DLLNode head;
    DLLNode mid;
    DLLNode prev;
    DLLNode next;
    int size;
    void push(int new_data)
  {
        DLLNode new_node = new DLLNode(new_data);
        if (size == 0)                               //if this is the first element
        {
            head = new_node;
            mid = new_node;
        }
        else 
        {
          head.next = new_node;
          new_node.prev = head;
          head = head.next;
          
          if (size % 2 != 0) 
          { mid = mid.next; }
        }
        size++;
  }
 
    int pop()
    {
        int data = -1;
      
        /* Stack underflow */
        if (size == 0) {
            return data;
        }
 
        else{
            data = head.data;
            if (size == 1) {
                head = null;
                mid = null;
            }
            else {                
                head = head.prev;
                head.next = null;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
            size--;
        }
        return data;
    }
 
    int findMiddle()
    {
        if (size == 0) 
        return -1;
      
        return mid.data;
    }
    void deleteMiddleElement()
    {
     //only when if size is not 0 
        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            }
            else if (size == 2) {
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            }
            else {
                mid.next.prev = mid.prev;
                mid.prev.next = mid.next;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
                else {
                    mid = mid.next;
                }
            }
            size--;
        }
    }
