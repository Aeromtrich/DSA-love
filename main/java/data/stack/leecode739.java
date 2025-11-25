package data.stack;

import java.util.Stack;

// leecode 739 每日温度
class leecode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>(); // pair: [temperature, index]
        
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            // 当栈不为空且当前温度高于栈顶温度时
            while (!stack.isEmpty() && currentTemp > stack.peek()[0]) {
                int[] popped = stack.pop();
                int stackTemp = popped[0];
                int stackIndex = popped[1];
                res[stackIndex] = i - stackIndex;
            }
            stack.push(new int[]{currentTemp, i});
        }
        
        return res;
    }
}