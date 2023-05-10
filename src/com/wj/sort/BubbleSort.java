package com.wj.sort;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * 基本思想
 * 通过对待排序序列从前往后遍历，依次比较相邻的两个数，若发现逆序则交换。
 * 使值较大的元素从前往后移
 * 时间复杂度 O(n2) 平方阶
 *
 * @author wangjie
 * @date 2020/5/24 23:07
 */
public class BubbleSort extends BaseSort {

    public static void main(String[] args) {
        int arr[] = {8, 0, -1, 1, 2, 20, 3, 5, 6};
        sort(arr);
    }



    static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }



}
