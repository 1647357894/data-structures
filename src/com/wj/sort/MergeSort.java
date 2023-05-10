package com.wj.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序是利用归并的思想实现的排序方法，该算法采用经典的分治策略
 * (分治法将问题分成一些小的问题然后递归求解，而治的阶段则将分的阶段得到的答案“修补”在一起，即分而治之)
 *
 * @author wangjie
 * @date 2020/5/31 17:06
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            //中间索引
            int mid = (left + right) >> 1;
            //向左递归分解
            mergeSort(arr, left, mid);
            //向右递归分解
            mergeSort(arr, mid + 1, right);
            //合并
            merge(arr, left, mid, right);
        }
    }


    /**
     * 合并
     *
     * @param arr   待排序的数组
     * @param left  左边有序序列的的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     */
    static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length];
        //初始化i，左边有序序列的初始索引
        int i = left;
        //初始化j，右边有序序列的初始索引
        int j = mid + 1;
        //指向tmp数组的当前索引
        int t = 0;

        //1 先把左右两边的(有序)的数据按照规则填充到tmp数组
        //直到左右两边的有序序列，有一边处理完为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到tmp数组
            tmp[t++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        //2. 把剩余数据的一边的数据依次全部填充到tmp
        //左边的有序序列还有剩下的元素，就全部填充到tmp
        while (i <= mid) tmp[t++] = arr[i++];

        //右边的有序序列还有剩余的元素，就全部填充到tmp
        while (j <= right) tmp[t++] = arr[j++];


        //3. 将tmp数组的元素拷贝到arr
        t = 0;
        while (left <= right)
            arr[left++] = tmp[t++];


    }
}
