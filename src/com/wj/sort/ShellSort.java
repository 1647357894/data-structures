package com.wj.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序也是插入排序，
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序，随着增量逐渐减少，每组包含的关键词越来越多，
 * 当增量减至1时，整个数组被分为一组，算法结束。
 *
 * @author wangjie
 * @date 2020/5/27 22:37
 */
public class ShellSort extends BaseSort {

    public static void main(String[] args) {
        int[] arr = {8, 11, 10, 0, 4, 2, 3, 7, 5, 6};
        shellSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        //new ShellSort().time();
    }

    /**
     * 交换法
     *
     * @param arr
     */
    static void shellSort(int[] arr) {

        //gap 5 2 1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //第一轮排序，将其分为n组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中的所有元素(共n组，每组有m个元素) 步长为n/2
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        swap(arr, j, j + gap);
                    }
                }
            }
        }


/*

        int gap = arr.length / 2;

        //第一轮排序，将其分为5组
        for (int i = gap; i < arr.length; i++) {
            //遍历各组中的所有元素(共5组，每组有2个元素) 步长为5
            for (int j = i - gap; j >= 0; j -= gap) {
                if (arr[j] > arr[j + gap]) {

                    int tmp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = tmp;
                }
            }
        }


        System.out.println(Arrays.toString(arr));



        //第二轮排序，将其分为2组
        gap = arr.length/2/2;
        for (int i = gap; i < arr.length; i++) {
            //遍历各组中的所有元素(共2组，每组有5个元素) 步长为2
            for (int j = i - gap; j >= 0; j -= gap) {
                if (arr[j] > arr[j + gap]) {

                    int tmp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));



        //第三轮排序，将其分为1组
        gap = arr.length/2/2/2;
        for (int i = gap; i < arr.length; i++) {
            //遍历各组中的所有元素(共1组，每组有10个元素) 步长为1
            for (int j = i - gap; j >= 0; j -= gap) {
                if (arr[j] > arr[j + gap]) {

                    int tmp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
*/

    }

    /**
     * 移位法
     *
     * @param arr
     */
    static void shellSort2(int[] arr) {

        //增量gap，并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {

                //插入下标
                int insertIndex = i;
                //待插入的值
                int insertVal = arr[insertIndex];

                //当前的值 和 它共一组的值开始比较，如果当前值比前面的值要小
                if (arr[insertIndex] < arr[insertIndex - gap]) {

                    while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                        //移动
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    //当while循环结束，就给insertVal找到插入的位置
                    arr[insertIndex] = insertVal;
                }


             /*   int insertVal = arr[i];
                int insertIndex = i - 1;

                while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

                    arr[insertIndex + 1] = insertVal;
                    insertIndex--;

                }
                arr[insertIndex + 1] = insertVal;*/
            }

        }
        //  System.out.println(Arrays.toString(arr));

    }

    @Override
    void temp() {
        int[] arr = {8, 11, 10, 0, 4, 2, 3, 7, 5, 6};
        shellSort2(arr);
    }


}

