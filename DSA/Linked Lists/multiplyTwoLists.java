/*
Link- https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article 
*/

//
public long multiplyTwoLists(Node l1,Node l2)
   {
       Node node1=l1;
       Node node2=l2;
       long mod = 1000000007;                                       // The modulo value
       long num1=0,num2=0;
       while(node1!=null)
       {
         num1=(num1*10)%mod+node1.data;
         node1=node1.next;
       }
       while(node2!=null)
       {
         num2=(num2*10)%mod+node2.data;
         node2=node2.next;
       }
        return (num1*num2)%mod;
   }
