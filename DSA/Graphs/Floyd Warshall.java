/*
Link - https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
*/

// Make every node intermediate by loop, in each loop check matrix for lesser cost by that intermediate betwen i and j

public void inter(int[][]matrix,int mid)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if((matrix[i][j]==-1 || matrix[i][j]>matrix[i][mid]+matrix[mid][j]) && (matrix[i][mid]!=-1 && matrix[mid][j]!=-1))        // if there was no edge (-1) then definitely update otherwise check for less cost . Check if interm edges exists or not to check
                matrix[i][j]=matrix[i][mid]+matrix[mid][j];
            }
        }
    }
    public void shortest_distance(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        inter(matrix,i);
    }
