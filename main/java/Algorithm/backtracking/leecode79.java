package Algorithm.backtracking;

import java.util.HashSet;
import java.util.Set;

// leecode 79 单词搜索 DFS
class leecode79 {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int i, Set<String> path) {
        // 如果已经匹配完所有字符，返回true
        if (i == word.length()) {
            return true;
        }
        
        // 检查边界条件、字符匹配和是否已访问
        if (r < 0 || c < 0 || 
            r >= board.length || c >= board[0].length ||
            word.charAt(i) != board[r][c] ||
            path.contains(r + "," + c)) {
            return false;
        }
        
        // 标记当前位置为已访问
        path.add(r + "," + c);
        
        // 向四个方向递归搜索
        boolean res = dfs(board, word, r + 1, c, i + 1, path) ||
                     dfs(board, word, r - 1, c, i + 1, path) ||
                     dfs(board, word, r, c + 1, i + 1, path) ||
                     dfs(board, word, r, c - 1, i + 1, path);
        
        // 回溯，移除当前位置的访问标记
        path.remove(r + "," + c);
        
        return res;
    }
}