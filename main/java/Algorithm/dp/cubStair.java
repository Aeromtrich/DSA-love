package Algorithm.dp;

public class cubStair {

    // leecode 70 爬楼梯
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2)
        if (n <= 2) return n;

        int first = 1;  // dp[i-2]
        int second = 2; // dp[i-1]
        int third = 0;  // dp[i]

        for (int i = 3; i <= n; i++) {
            third = first + second;
            // 状态往前滚动
            first = second;
            second = third;
        }

        return second;
    }

    public static void main(String[] args) {
        cubStair s = new cubStair();
        System.out.println(s.climbStairs(5)); // 输出 8
    }

}
