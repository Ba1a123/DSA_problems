class Solution {
    private int[][] memo; 
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n]; 
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        return findMinPath(grid, 0, 0);
    }
    
    private int findMinPath(int[][] grid, int i, int j) {
    
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i > grid.length - 1 || j> grid[0].length - 1 ) {
            return Integer.MAX_VALUE;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
      
        int down = Integer.MAX_VALUE;
      
            down = findMinPath(grid, i + 1, j);
        
        int right = Integer.MAX_VALUE;
            right = findMinPath(grid, i, j + 1);
        
        
    
        memo[i][j] = grid[i][j] + Math.min(down, right);
        
        return memo[i][j];
    }
}
