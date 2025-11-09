package com.data.array;

import org.junit.Test;

public class mergeTwoSortedArray {

    // leecode  合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                --i;
                --k;
            } else {
                nums1[k] = nums2[j];
                --j;
                --k;
            }
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            --j;
            --k;
        }


    }


    // leecode 283 移动零  双指针法
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        while (r < n) {
            if (nums[r] != 0) {
                swap(nums, l , r);
                l ++;
            }
            r ++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}


