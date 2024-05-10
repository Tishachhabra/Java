/*
Link - https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

Approach- Using priority queue , O(E log V)
Maintain ans smthing(arraylist/sum of weights), inMSTnodes[],keys(represent smallest weight) of all vertices,priority que to maintain edges(vertex, weight ka pair)
*/

//Initialise all keys to max value, pq with src vertex and key 0,inMSTnodes with false. while pq is not empty poll,make inMSTnodes[] true, take all neighbors -(who are not inMST[]) update keys by checking with current weight and then add to pq.


class Solution 
{
    static class Pair                
    {
        int f,s;
        Pair(int f,int s)
        {
            this.f=f;
            this.s=s;
        }
    }
    static int spanningTree(int v, int E, List<List<int[]>> adj)                      // every index contain list of edges from it
    {
        boolean[] inMST = new boolean[v];                                            //nodes chosen for MST
        PriorityQueue<Pair> q=new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b)                                       
                {                                          
                    return a.f - b.f;                                                //compare pairs acc to key
                }
        });
        int sum=0;
        int key[]=new int[v];                                                        //smallest weight
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0]=0;
        q.offer(new Pair(key[0],0));
        
        while(!q.isEmpty())
        {
            Pair min=q.poll();
            int vertex = min.s;
            
            if(inMST[vertex])                                        //already in path (no cycle allowed)
            continue;
            
            inMST[vertex]=true;
            sum+=min.f;                                              // maintain sum of cost for MST
            List<int[]> neigh=adj.get(vertex);                       // extract neighbors 
            for(int[] arr : neigh)
            {
                vertex=arr[0];
                int weight=arr[1];
                if(!inMST[vertex] && key[vertex]>weight)              // those neighbors which are not inMST[] and need to be updated
                {
                    key[vertex]=weight;
                    q.offer(new Pair(key[vertex],vertex));
                }
            }
        }
        return sum;
    }
}
