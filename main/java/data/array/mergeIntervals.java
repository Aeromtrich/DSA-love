package data.array;

import java.util.*;

class mergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 先按每个区间的起始位置排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = output.get(output.size() - 1);  // 上一个合并区间
            int[] current = intervals[i];

            int lastEnd = last[1];
            int start = current[0];
            int end = current[1];

            if (start <= lastEnd) {
                // 有重叠，更新右边界
                last[1] = Math.max(lastEnd, end);
            } else {
                // 无重叠，直接添加新区间
                output.add(current);
            }
        }

        // 转为二维数组返回
        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = new mergeIntervals().merge(intervals);
        System.out.println(Arrays.deepToString(merged));
    }
}