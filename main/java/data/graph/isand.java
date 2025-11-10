package data.graph;

// leecode 200 岛屿数量

// 	    遍历整个二维网格；
//	2.	每当发现一个 '1'：
//	•	岛屿数量 count++
//	•	然后用 DFS 把它相连的 '1' 都变成 '0'（标记访问过）；
//	3.  遍历完所有格子后，count 就是岛屿数量。
public class isand {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 遇到陆地，开始“沉岛”操作
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // DFS递归函数：淹没当前陆地及相邻陆地
    private void dfs(char[][] grid, int i, int j) {
        // 越界 或 遇到水
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // 标记为“已访问”——把陆地变成水
        grid[i][j] = '0';

        // 上下左右继续扩展
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        isand s = new isand();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(s.numIslands(grid)); // 输出 3
    }
}