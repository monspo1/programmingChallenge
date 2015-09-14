/* Number of Island
* 
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
* You may assume all four edges of the grid are all surrounded by water.
*
* Example 1
* 11110
* 11010
* 11000
* 00000
* ==> Answer: 1
* 
* Example 2
* 11000
* 11000
* 00100
* 00011
* ==> Answer: 3
*
//*/
public class Solution {

    public int numOfIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        final int N = grid.length;
        final int M = grid[0].length;
        final boolean visited[][] = new boolean[N][M];
        int count = 0;
    
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    } 
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        } else if (visited[i][j] || grid[i][j] != '1'){
            return;
        }
        
        visited[i][j] = true;
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i, j+1, visited);
    }
}
