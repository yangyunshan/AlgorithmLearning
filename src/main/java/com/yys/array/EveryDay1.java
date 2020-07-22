package com.yys.array;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class EveryDay1 {
    public int minArray(int[] numbers) {
        numbers = reverse(numbers, getIndex(numbers));
        return numbers[0];
    }

    /**
     * 获取数组旋转位置的索引
     * @param numbers
     * @return
     */
    public int getIndex(int[] numbers) {
        int length = numbers.length;
        int index = 0;
        for (int i=1;i<length;i++) {
            if (numbers[i]>=numbers[i-1]) {
                continue;
            } else {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 在指定位置旋转数组
     * @param numbers
     * @param index
     */
    private int[] reverse(int[] numbers, int index) {
        int length = numbers.length;
        int[] newArr = new int[length];
        int j = 0;
        for (int i = index; i < length; i++) {
            newArr[j] = numbers[i];
            j++;
        }
        for (int i=0;i<index;i++) {
            newArr[j] = numbers[i];
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] numners = new int[] {1,3,5};
        System.out.println(new EveryDay1().solution(numners));
    }

    /**************************************************************************************/
    public int solution(int[] numbers) {
        int i = 0;
        int j = numbers.length-1;
        int m = (i+j)/2;
        while (i<j) {
            if (numbers[m]>numbers[j]) {
                i = m+1;
            } else if (numbers[m]<numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}
