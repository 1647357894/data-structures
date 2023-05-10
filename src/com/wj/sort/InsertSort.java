package com.wj.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 基本思想：把n个待排序的元素看成是一个有序表和无序表，开始时有序表只包含一个元素
 * 无序表中有n-1个元素，排序过程中从无序表中取出第一个元素，将它与有序表中的元素依次比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表。
 *
 * @author wangjie
 * @date 2020/5/26 23:52
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args) {
        int[] arr = {1, 8, 4, 2, 3, 7, 5, 6};
        insertSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /**
     * 从数组的第二个数开始循环，将选中的元素与之前的元素一一比较，如果选中的元素小于之前的元素，则将之前的元素后移，最后再将选中的元素放在合适的位置。
     * 在这个算法执行的过程中，总是保持索引i之前的数组是升序排列的。
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //当前插入值
            int insertVal = arr[i];
            int insertIndex = i - 1; //即arr[1]前面这个数的下标

            //给insertVal找到插入的位置
            //1.insertIndex >= 0 保证数组不越界
            //2. insertVal < arr[insertIndex] 表示还没找到对应的位置
            //3. 需要将 arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //将往后移动一位
                arr[insertIndex + 1] = arr[insertIndex];
                //继续往前比较  往前移一位
                insertIndex--;
            }
            System.out.println("insertVal = " + insertVal);
            arr[insertIndex + 1] = insertVal;
        }
    }

}
