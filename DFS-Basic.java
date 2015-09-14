public class Solution {
    
    public void someMethod(int a) {
        // ...
    } 
    
    private void dfs(char[][] mat, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) {
            return;
        } else if (visited[i][j] || mat[i][j] != '1') {
            return;
        }
    
        visited[i][j] = true;
        dfs(mat, i - 1, j, visited);
        dfs(mat, i + 1, j, visited);
        dfs(mat, i, j - 1, visited);
        dfs(mat, i, j + 1, visited);
    }
}