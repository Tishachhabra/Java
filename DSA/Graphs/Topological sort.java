/*
Link- https://www.geeksforgeeks.org/problems/topological-sort/1

By both DFS & BFS. Below is BFS approach by queue. indegree is calculated of all nodes, whose are zeros they are appended to queue, while it's not empty one node is popped, its neighbours indeg-- ,those becoming zero are added to queue 
*/


class Solution
{
    static int[] fill( ArrayList<ArrayList<Integer>> adj)                  //fill indegree array
    {
        int []indeg=new int[adj.size()];
        for(ArrayList<Integer> arr : adj)
        {
            for(int i:arr)
            {
                indeg[i]++;
            }
        }
        return indeg;
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        List<Integer> ans=new ArrayList<>(v);
        Queue<Integer> q=new LinkedList<Integer>();
        int indeg[]=fill(adj);
        for(int i=0;i<indeg.length;i++)
        {
            if(indeg[i]==0)
            q.add(i);
        }
        while(!q.isEmpty())
        {
            int i=q.poll();
            ans.add(i);
            ArrayList<Integer> arr=adj.get(i);
            for(int n : arr)
            {
                indeg[n]--;
                if(indeg[n]==0)
                q.add(n);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();                    //to convert arraylist to array with primitive type
    }
}
