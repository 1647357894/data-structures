package com.wj.search;

/**
 * 插值查找：
 * 公式 mid = low + ((key-arr[low])/(arr[high]-arr[low])*(high-low))
 * 根据要查找的key与表中的最大值和最小值比较后的查找方法
 *
 * 与二分查找基本一样，只是换了个公式
 * @author wangjie
 * @date 2020/8/30 21:07
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 12, 18, 30, 42};
        int index = insertSearch(arr, arr.length - 1, 30);
        System.out.println("index = " + index);
    }

    static int insertSearch(int[] arr, int n, int key) {
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            //mid = low + ((key-arr[low])/(arr[high]-arr[low])*(high-low))
            //{1, 5, 12, 18, 30, 42}
            // 查找30
            // mid    0+(30-1)/(42-1)*(5-0) = 0+29/41*5 = 3
            //        4+(30-30)/(42-30)*(5-4) = 4+0/12*1 = 4
            mid = low + (key - arr[low]) / (arr[high] - arr[low]) * (high - low);
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
}
