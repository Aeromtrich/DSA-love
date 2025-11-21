package Algorithm.dp;

import java.util.*;

public class triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // 基础情况
        if (numRows == 0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // 每一行有 i+1 个元素
            for (int j = 0; j <= i; j++) {
                // 每行的第一个和最后一个元素都是 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 其他元素由上一行相邻两个数相加
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }

    // 测试方法
    public static void main(String[] args) {
        triangle s = new triangle();
        List<List<Integer>> result = s.generate(5);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}