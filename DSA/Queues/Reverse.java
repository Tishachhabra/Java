/*
Link=https://www.geeksforgeeks.org/problems/queue-reversal/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
*/

//Use stack as temp data structure to store
public Queue<Integer> rev(Queue<Integer> q)
    {
        Stack<Integer> s=new Stack<Integer>();
        while(q.size()>0)
        {
            s.push(q.poll());
        }
        while(s.size()>0)
        {
            q.offer(s.pop());
        }
        return q;
    }
