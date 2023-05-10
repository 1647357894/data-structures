package com.wj.sort;

import java.util.Arrays;

/**
 * 快速排序是冒泡排序的一种改进
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部份的所有数据都比另一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 *
 * @author wangjie
 * @date 2020/5/29 21:59
 */
public class QuickSort extends BaseSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 4, 2, 3, 7, 5, 6};
//        quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

       /* System.getenv().forEach((k,v) ->{
            System.out.println(k+":"+v);
        });*/
    }

    static void quickSort(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;

        //中轴
        int pivot = arr[(left + right) / 2];

        int tmp = 0;
        //while循环的目的是让比左pivot值小放到左边
        // 比pivot大的放在右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l>=r 说明pivot左右两边的值，已经按照左边全部是小于等于pivot值，右边全部是大于大于pivot值
            if (l >= r) {
                break;
            }

            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            //如果交换完后，发现这个arr[l]==pivot值相等 r--,前移
            if (arr[l] == pivot) {
                r--;
            }

            //如果交换完后，发现arr[r]==pivot值，相等l++,后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //如果l==r，必须l++,r--,否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }


    }


    static void quickSort2(int[] arr, int startIndex, int endIndex) {
        if (startIndex>=endIndex) {
            return;
        }
        //得到基准元素的位置
        int pivotIndex = partition(arr,startIndex,endIndex);
        //根据基准元素，分成两部分进行递归排序
        //左
        quickSort2(arr,startIndex,pivotIndex-1);
        //右
        quickSort2(arr,pivotIndex+1,endIndex);
    }

    /**
     * 分治(单边循环法)
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) swap(arr,++mark,i);
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


}
