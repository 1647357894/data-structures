package com.wj.search;

/**
 * 二分查找，前提是有序的
 * 公式  mid = (low+high)/2
 * @author wangjie
 * @date 2020/6/1 23:37
 */
public class BinarySearch {

    public static void main(String[] args) {


        int[] arr = {1, 5, 12, 18, 30, 42};
        int index = binarySearch2(arr, 0,arr.length - 1, 30);
        System.out.println("index = " + index);
    }


    static int binarySearch(int[] arr, int num) {
        return binarySearch(arr, 0, arr.length - 1, num);
    }

    static int binarySearch(int[] arr, int left, int right, int num) {

        //找不到结束递归
        if (left > right) {
            return -1;
        }

        //中间值  右移1位 代表除以2
        int mid = (left + right) >>> 1;
        //往右
        if (num > arr[mid]) {
            return binarySearch(arr, mid + 1, right, num);

        }//向左
        else if (num < arr[mid]) {
            return binarySearch(arr, left, mid - 1, num);
        } else {
            //找到了
            return mid;
        }


    }

    private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


    static int binarySearch2(int[] arr, int fromIndex, int toIndex,
                             long key) {
        int low = fromIndex;
        int high = toIndex;
        int mid = 0;
        while (low <= high) {
            //(low + high)/2
            mid = (low + high) / 2;
            //在左边
            if (key < arr[mid]) {
                //将高位向左偏移
                high = mid - 1;
            }
            //在右边
            else if (key > arr[mid]) {
                //将低位向右偏移
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        //[-1,0,3,5,9,12]   9
        while (left <= right) {
            // 3     1        6   -   1     / 2
            // 4     2        6   -   2     / 2
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            // 目标值小于中间值，减小右边界值
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

}
