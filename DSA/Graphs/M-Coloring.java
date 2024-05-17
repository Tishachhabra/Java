/*
Link - https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
*/

//Main function will call graphcolor function for every vertex. graphcolor func will try for every color on that every vertex, if that is safe then go for next otherwise backtrack and loop for next color.

class solve 
{
    static boolean isSafe(boolean graph[][],int n,int v,int c,int []color)
    {
        for(int i=0;i<n;i++)
        if(graph[v][i] && color[i]==c)          //if an edge caught check whether that node has the same color
        return false;
        
        return true;
    }
    static boolean graphcolor(boolean graph[][], int m, int n,int v,int []color)
    {
        if(v==n)
        return true;                            //every vertex has got its color
        
        for(int c=1;c<=m;c++)
        {
            if(isSafe(graph,n,v,c,color))
            {
                color[v]=c;
                if(graphcolor(graph,m,n,v+1,color))
                return true;
                color[v]=0;                     //backtrack,further no confg found, have to chnge color
            }
        }
        return false;                           //all color tried but no confg found
    }
    public boolean graphColoring(boolean graph[][], int m, int n) 
    {
        int color[]=new int[n];
        Arrays.fill(color,0);
        
        for(int i=0;i<n;i++)            //for every vertex
        if(!graphcolor(graph,m,n,i,color))    //no solution
        return false;
        
        return true;                    //possible and been found
    }
}
