package com.yys.array;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class SwordOffer53_1 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        //查找左边界
        while (left<=right) {
            int mid = (left + right) >>> 1;
            if (nums[mid]>target) {
                right = mid - 1;
            } else if (nums[mid]<target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int l = left;

        //查找右边界
        left = 0;
        right = nums.length - 1;
        while (left<=right) {
            int mid = (left + right) >>> 1;
            if (nums[mid]>target) {
                right = mid - 1;
            } else if (nums[mid]<target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        int r = right;

        return r - l + 1;

    }

    public static void main(String[] args) {
        int count = new SwordOffer53_1().search(new int[] {5,7,7,8,8,10}, 8);
        System.out.println(count);
    }
}
