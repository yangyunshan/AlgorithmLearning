package com.yys.array;

import java.util.*;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class _268_Array {
    public int missingNumber(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int length = nums.length + 1;
        for (int i=0;i<length;i++) {
            temp.add(i);
        }
        for (int j=0; j<nums.length; j++) {
            temp.remove(new Integer(nums[j]));
        }
        return temp.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new _268_Array().missingNumber(new int[] {3,0,1}));
    }

    /*****************************************************************************************/

    //如果数组是有序的，那么就很容易知道缺失的数字是哪个了。
    //
    //算法
    //
    //首先我们对数组进行排序，随后我们可以在常数时间内判断两种特殊情况：0 没有出现在数组的首位，以及 nn 没有出现在数组的末位。如果这两种特殊情况都不满足，那么缺失的数字一定在 0 和 nn 之间（不包括两者）。此时我们可以在线性时间内扫描这个数组，如果某一个数比它前面的那个数大了超过 1，那么这两个数之间的那个数即为缺失的数字。
    public int solusion1(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[length-1] != length) {
            return length;
        }
        for (int i=0;i<length;i++) {
            int expectedNum = nums[i] -1;
            if ((nums[i] - expectedNum)>1) {
                return i-1;
            }
        }
        return -1;
    }

    /***********************************************************************************/
    //我们可以直接查询每个数是否在数组中出现过来找出缺失的数字。如果使用哈希表，那么每一次查询操作都是常数时间的。
    public int solution2(int[] nums) {
        int length = nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i=0;i<length+1;i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
