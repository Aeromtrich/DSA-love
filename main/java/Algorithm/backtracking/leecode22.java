package Algorithm.backtracking;

import java.util.*;

// leecode 22 括号生成
class leecode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        
        backtrack(0, 0, n, stack, res);
        return res;
    }
    
    private void backtrack(int openN, int closedN, int n, Stack<Character> stack, List<String> res) {
        // 当左右括号都达到n个时，找到一个有效组合
        if (openN == n && closedN == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        
        // 只有当左括号数量小于n时，才能添加左括号
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n, stack, res);
            stack.pop();
        }
        
        // 只有当右括号数量小于左括号数量时，才能添加右括号
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n, stack, res);
            stack.pop();
        }
    }
}