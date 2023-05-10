package com.wj.sort;

import java.util.Arrays;

/**
 * 基数排序【桶排序】
 * 基数排序基本思想：
 * 1.将所有待比较的数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从低位排序一直到最高位排序完成以后，数列就变成   一个有序序列。
 *
 * @author wangjie
 * @date 2020/6/1 21:26
 */
public class RadixSort {


    public static void main(String[] args) {

        int[] arr = {53, 3, 542, 748, 14, 214};

        System.out.println(12 / 10 % 10);

        radixSort(arr);


    }

    static void radixSort(int[] arr) {

        //定义一个二维数组，表示10个桶
        /**
         * 1.一个二维数组包含10个一位数组
         * 2.为了防止在放入数的时候，数据溢出，则每个一维数组(桶),大小定为arr.length
         * 3.基数排序是经典的空间换时间算法
         */
        int[][] bucket = new int[10][arr.length];
        /**
         *为了记录每个桶里有多少个数据，定义一个一维数组来记录各个桶的每次放入的数据个数
         * bucketElementCounts[0] ,记录的就是bucket[0]桶的放入数据个数
         */
        int[] bucketElementCounts = new int[10];


        int maxVal = 0;
        for (int i = 0; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        // 循环次数 取最大值的长度
        int num = String.valueOf(maxVal).length();

        for (int k = 0, n = 1; k < num; k++, n *= 10) {

            //第一轮【针对每个元素的个位进行排序处理】
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的位值  个十百...
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }


            //按照这个桶的顺序(一维数组的下标依次取出数据，放入到原来的数组)
            int index = 0;
            //遍历每一个桶，并将桶中的数据，放入到原数组
            for (int i = 0; i < bucketElementCounts.length; i++) {
                //如果桶中有数据
                if (bucketElementCounts[i] != 0) {
                    //循环该桶即第i个桶
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketElementCounts[i] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }




      /*  //第一轮【针对每个元素的个位进行排序处理】
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位值
            int digitOfElement = arr[i] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出数据，放入到原来的数组)
        int index = 0;
        //遍历每一个桶，并将桶中的数据，放入到原数组
        for (int i = 0; i < bucketElementCounts.length; i++) {

            //如果桶中有数据
            if (bucketElementCounts[i] != 0) {
                //循环该桶即第i个桶
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr中
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }

        System.out.println(Arrays.toString(arr));


        for (int i = 0; i < arr.length; i++) {
            int bit = arr[i] / 10 % 10;
            bucket[bit][bucketElementCounts[bit]] = arr[i];
            bucketElementCounts[bit]++;
        }

        index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }

        System.out.println(Arrays.toString(arr));


        for (int i = 0; i < arr.length; i++) {
            int bit = arr[i] / 100 % 10;
            bucket[bit][bucketElementCounts[bit]] = arr[i];
            bucketElementCounts[bit]++;
        }

        index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }

        System.out.println(Arrays.toString(arr));*/

    }


}
