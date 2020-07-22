package com.yys.array;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class _167_Array {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int length = numbers.length;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if ((numbers[i] + numbers[j])==target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ss = new _167_Array().twoSum(new int[] {2,7,11,15}, 9);
        System.out.println("");
    }

    /**************************************************************************************/

    //注意数组已按照升序进行排列过
    public int[] solution(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length;
        while (i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum<target) {
                i++;
            } else if (sum>target) {
                j--;
            } else {
                return new int[] {i+1,j+1};
            }
        }
        return new int[] {-1,-1};
    }
}
