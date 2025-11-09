package Algorithm.dp;

// leecode 198 打家劫舍
public class robHouse {

    public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // [rob1, rob2, n, n+1, ...]
        for (int n : nums) {  // n就是当前房间
            int temp = Math.max(n + rob1, rob2);  // 偷当前房间  // 不偷当前房间
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }


    public static void main(String[] args) {
        // 测试打家劫舍
        int[] houses1 = {1,2,3,1};
        int[] houses2 = {2,7,9,3,1};
        int[] houses3 = {2,1,1,2};

        System.out.println("\n打家劫舍测试:");
        System.out.println("输入: [1,2,3,1], 输出: " + robHouse.rob(houses1)); // 应该输出 4
        System.out.println("输入: [2,7,9,3,1], 输出: " + robHouse.rob(houses2)); // 应该输出 12
        System.out.println("输入: [2,1,1,2], 输出: " + robHouse.rob(houses3)); // 应该输出 4
    }

}

