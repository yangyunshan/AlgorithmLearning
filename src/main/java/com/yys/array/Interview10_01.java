package com.yys.array;

import java.util.Arrays;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Interview10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] res = new int[m+n];

        int lengthA = A.length;
        int lengthB = B.length;
        for (int i=0;i<m+n;i++) {
            if (i<m) {
                res[i] = A[i];
            } else {
                res[i] = B[i-m];
            }
        }
        Arrays.sort(res);
        A = res;
        System.out.println(A);
    }

    /**
     * 方法 2: 双指针
     * 算法
     * 方法 1 没有利用数组 A 与 B 已经被排序的性质。为了利用这一性质，我们可以使用双指针方法。这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。如下面的动画所示：
     */
    public void solution2(int[] A, int m, int[] B, int n) {
        int posA = 0;
        int posB = 0;
        int[] res = new int[m+n];

        int i=0;
        while (posA<m || posB<n) {
            if (posA==m) {
                res[i] = B[posB];
                posB++;
            }
            else if (posB==n) {
                res[i] = A[posA];
                posA++;
            }
            else if (A[posA]<B[posB]) {
                res[i] = A[posA];
                posA++;
            }
            else {
                res[i] = B[posB];
                posB++;
            }
            i++;
        }
        for (int j=0;j<m+n;j++) {
            A[j] = res[j];
        }
    }

    public static void main(String[] args) {
        new Interview10_01().solution2(new int[] {1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
