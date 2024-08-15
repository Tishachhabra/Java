*/
Link-https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
*/

//Make pivot,traverse from beg,if smaller than pivot,swap with prev,atlast swap prev with pivot
class GfG
{
    public static Node quickSort(Node node)
    {
        Node head=node;
        while(node.next!=null)
        {
            node=node.next;
        }
        Node tail=node;
        sort(head,tail);
        return head;
    }
    public static void sort(Node head,Node tail)
    {
        if(head==tail || head==null)
        return;
        Node pivot=partition(head,tail);
        sort(head,pivot);
        sort(pivot.next,tail);
    }
    public static Node partition(Node head,Node tail)
    {   
        Node pivot=head;
        Node prev=head;
        Node cur=head.next;
        while(cur!=null)
        {
            if(cur.data<pivot.data)
            {
                int temp=prev.next.data;
                prev.next.data=cur.data;
                cur.data=temp;
                prev=prev.next;
            }
            cur=cur.next;
        }
        int temp=prev.data;                        //swap pivot with prev
        prev.data=pivot.data;
        pivot.data=temp;
        return prev;
    }
}
