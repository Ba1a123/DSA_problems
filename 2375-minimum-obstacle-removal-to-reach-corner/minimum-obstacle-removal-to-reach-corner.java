class Solution
{
    public int minimumObstacles(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        
        int[][] visited = new int[rows][cols];
        for (int[] row : visited)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

      
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        
        Deque<int[]> queue = new ArrayDeque<>(); 
        
       
        queue.addFirst(new int[] {0, 0, 0});
        visited[0][0] = 0;

 
        while (!queue.isEmpty())
        {
            int[] curr = queue.pollFirst(); 
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

         
            for (int[] dir : directions)
            {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

       
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols)
                {
                    int nextCost = cost + grid[nextX][nextY]; 

                
                    if (nextCost < visited[nextX][nextY])
                    {
                        visited[nextX][nextY] = nextCost;

                       
                        if (grid[nextX][nextY] == 0)
                        {
                            queue.addFirst(new int[] {nextX, nextY, nextCost});
                        }
                        else 
                        { 
                            queue.addLast(new int[] {nextX, nextY, nextCost});
                        }
                    }
                }
            }
        }

        return visited[rows - 1][cols - 1];
    }
}