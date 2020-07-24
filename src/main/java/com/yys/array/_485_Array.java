package com.yys.array;

import com.yys.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class _485_Array {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int max = 0;
        int count = 0;
        for (int i=0;i<length;i++) {
            if (nums[i]==1) {
                count++;
                if (max<count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _485_Array().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }
}
