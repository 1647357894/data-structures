package com.wj.search;

/**
 * 线性查找
 *
 * @author wangjie
 * @date 2020/6/1 23:34
 */
public class SeqSearch {

    public static void main(String[] args) {

        int[] arr = {45, 2, 3, 4};
        //int index = seqSearch(arr, 45);
        int index = seqSearch2(arr,arr.length-1, 45);
        System.out.println("index = " + index);

    }

    /**
     * @param num
     * @return 找到就返回下标，未找到返回-1
     */
    static int seqSearch(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 线性查找
     *
     * @param arr 数组
     * @param n   从哪开始查找
     * @param key 查找的值
     * @return
     */
    static int seqSearch2(int[] arr, int n, int key) {
        int i = n;
        //假如要查找的元素位于0的话，使用这种方法就会有问题。
        //没查找到也返回0
        arr[0] = key;
        while (arr[i] != key) {
            i--;
        }
        return i;
    }

}
