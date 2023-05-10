package com.wj.sort;

import java.util.Arrays;

/**
 * @author wangjie
 * @date 2021/4/9 下午7:05
 */
public class SortTest  extends BaseSort{
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 2, 4};
        //bubbleSort(arr);
        //selectSort(arr);
        //insertSort(arr);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //选择
    //找最小值
    static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //插入
    static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    //冒泡
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    //private static int partition(int[] arr, int left, int right) {
    //    int pivot = right, counter = left;
    //    for (int i = left; i < right; i++) {
    //        if (arr[i] < arr[pivot]) {
    //            int temp = arr[counter];
    //            arr[counter] = arr[i];
    //            arr[i] = temp;
    //            counter++;
    //        }
    //    }
    //    int temp = arr[pivot];
    //    arr[pivot] = arr[counter];
    //    arr[counter] = temp;
    //    return counter;
    //}
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int counter = left;
        for (int i = left + 1; i <= right; i++)
            if (arr[i] < pivot) swap(arr,++counter,i);
        arr[left] = arr[counter];
        arr[counter] = pivot;
        return counter;
    }




}
