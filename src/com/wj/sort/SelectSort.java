package com.wj.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * 选择排序
 * 属于内部交换法，从欲排序的数据中，按指定的规则选出某一个元素，再依规定交换位置后达到排序目的
 * 选择排序思想
 * 第一次从 arr[0]-arr[n] 中选取最小的值，与arr[0]交换，第二次从arr[1]-arr[n] 中选取最小的值，与arr[1]交换
 * 总共通过n-1次，得到一个按排序码从小到大排序的有序序列
 *
 * 简单来说就是找一个最大值或最小值，然后将其交换到指定位置
 * 性能略优冒泡
 * @author wangjie
 * @date 2020/5/25 22:44
 */
public class SelectSort extends BaseSort {
    public static void main(String[] args) {
        int[] arr = {9,0, 4, 2, 3, 7, 5, 6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //最小值下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找最小值下标
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            //交换位置
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
}
