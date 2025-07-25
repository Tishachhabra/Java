/*
Minimization prblm - BFS required 
1) Init visited[] , que , steps =0, add starting position, mark visited true
2) While q has some - calc cur level size,for loop - poll,chcek if eq to target ; if yes then return steps ; if not then see children 
3) for loop (8 potential next moves) - calc newR and newC ; if valid & not visited then add to que
4) after each queue level - steps++

*/

class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        boolean[][] visited = new boolean[N + 1][N + 1];
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        Queue<int[]> q = new LinkedList<>();
      
        q.offer(new int[]{KnightPos[0], KnightPos[1]});
        visited[KnightPos[0]][KnightPos[1]] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();                                               // process all positions at this step level ; for calc steps
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];

                if (x == TargetPos[0] && y == TargetPos[1]) return steps;        //process dequeued item

                for (int d = 0; d < 8; d++) {                                    //add children
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 1 && ny >= 1 && nx <= N && ny <= N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            steps++; // Increase level after processing all current-level nodes
        }

        return -1;
    }
}
