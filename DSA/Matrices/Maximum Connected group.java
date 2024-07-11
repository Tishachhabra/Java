/*
Link - https://www.geeksforgeeks.org/problems/maximum-connected-group/1

Approach :- First pass of matrix to check all separated islands. for every 1 found as matrix ele, call dfs() helper func. dfs() will calc size of curr island (no. of 1s connected) by recursion calls of =top+bottom+left+right+1 (itself). Store base case of unsafe cells. Fill every cell of 1 with whatever islandNo they belong to. After returning size , store islandNo with corresponding size in map.
Second pass to check 0 should be chosen to flip. whenever 0 found make a set to store diff islands (islandNo) , calc potential size & check with finl ans.

*/
class Solution 
{
    int dfs(int[][] grid, int i, int j, int n, int islandNo) 
    {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || grid[i][j] == islandNo) 
            return 0;
        
        grid[i][j] = islandNo;
        int a = dfs(grid, i - 1, j, n, islandNo);
        int b = dfs(grid, i, j - 1, n, islandNo);
        int c = dfs(grid, i + 1, j, n, islandNo);
        int d = dfs(grid, i, j + 1, n, islandNo);
        return a + b + c + d + 1;
    }

    public int MaxConnection(int grid[][]) {
         int n = grid.length;
        int islandNo = 2;  // Start labeling islands from 2 since 0 & 1 cause confusion
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // First pass: identify and label all connected islands with unique numbers and store their sizes in map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, n, islandNo);
                    map.put(islandNo, size);
                    ans = Math.max(ans, size);
                    islandNo++;
                }
            }
        }
        
        // Second pass: check each zero and see if flipping it connects max group
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();     //so as to store diff islands once only
                    if (i > 0 && grid[i - 1][j] > 1) {
                        set.add(grid[i - 1][j]);
                    }
                    if (i < n - 1 && grid[i + 1][j] > 1) {
                        set.add(grid[i + 1][j]);
                    }
                    if (j > 0 && grid[i][j - 1] > 1) {
                        set.add(grid[i][j - 1]);
                    }
                    if (j < n - 1 && grid[i][j + 1] > 1) {
                        set.add(grid[i][j + 1]);
                    }
                    int maxSize = 1;  // Start with 1 to account for the flipped cell itself
                    for (Integer s : set) {
                        maxSize += map.get(s);
                    }
                    ans = Math.max(maxSize, ans);
                }
            }
        }
        return ans;
    }
}
