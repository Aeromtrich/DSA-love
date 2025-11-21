package Algorithm.dbpointer;

// leecode 11  接雨水
class leecode11 {
    public int maxArea(int[] height) {

        int res = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {

            int width = r - l;
            int h = Math.min(height[l], height[r]);
            int area = width * h;

            res = Math.max(res, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

        }

        return res;
    }
}