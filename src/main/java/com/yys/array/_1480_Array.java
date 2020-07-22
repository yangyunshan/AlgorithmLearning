package com.yys.array;

/**
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */
public class _1480_Array {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i=0;i<length;i++) {
            if (i<=0) {
                result[i] = nums[i];
            } else {
                result[i] = nums[i] + result[i-1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ss = new _1480_Array().runningSum(new int[] {1,2,3,4});
        System.out.println();
    }
}


