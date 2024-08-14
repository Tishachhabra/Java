//Change pointers  

public static Node reverseDLL(Node  head)
{
    Node cur=head;
    Node pre=null;
    Node save;
    while(cur!=null)
    {
        save=cur.next;
        cur.next=pre;
        cur.prev=save;
        pre=cur;
        cur=save; 
    }
    return pre;
}
