package com.wj.search;

/**
 * 优化嵌套for循环
 *
 * @author wangjie
 * @date 2020/8/30 18:50
 */
public class Test1 {
    private static int count = 0;
    private static int sum = 0;

    private static void f(int i, int j, int k) {
        sum += (i + j + k);
        count++;
    }

    public static void main(String[] args) {


        for (int i = 0; i < 1100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 10; k++) {
                    f(i, j, k);
                }
            }
        }
        System.out.println("sum = " + sum);
        System.out.println(count);
        sum = 0;
        count = 0;
        for (int i = 0; i < 1100; i++) {
            f(i, i % 100, i % 10);
        }
        System.out.println("sum = " + sum * 1000);
        System.out.println(count);
    }
}
