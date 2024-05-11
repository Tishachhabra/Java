/*
Link -  https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1

Approach - By using bellman ford algo. It first check for disconnected graphs by vis[], each graph bellman() func call - relax all edges n-1 tymes check dis[](shortest distances) & update if smaller weight comes,check last loop same for -ve cycle.
Time complexity - O(V*E) = relaxing loop
*/
class Solution
{
    public boolean bellman(int src,int []dis,int[][] edges,int n)           //fills dis[] shortest distances  and check -ve cycle
    {
        Arrays.fill(dis,Integer.MAX_VALUE);         
        dis[src]=0;                                                     //check for every vertex as src
        for(int i=0;i<n-1;i++)                                          //relax all edges n-1 times
        {
            for(int []edge :edges)
            {
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dis[u]!=Integer.MAX_VALUE && dis[v]>dis[u]+w)
                dis[v]=dis[u]+w;
            }
        }
        for(int[] edge :edges)                                      //last loop to check -ve cycle
        {
            int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dis[u]!=Integer.MAX_VALUE && dis[v]>dis[u]+w)
                return true;                                            //exists
        }
        return false;
    }
    public int isNegativeWeightCycle(int n, int[][] edges)          //check for all subgraphs(can be disconnected) by vis[]
    {
        boolean vis[]=new boolean[n];
        Arrays.fill(vis, false);
        int dis[]=new int[n];
        for(int vertex=0;vertex<n;vertex++)
        {
            if(vis[vertex])
            continue;
            
            if(bellman(vertex,dis,edges,n))
            return 1;
            
            for(int i=0;i<n;i++)
            {
                if(dis[i]!=Integer.MAX_VALUE)
                vis[i]=true;
            }
        }
        return 0;
    }
}
