package com.wj.recursion;

/**
 * @author wangjie
 * @date 2020/5/24 15:12
 */
public class Queue8 {
    /**
     * 定义有多少个皇后
     */
    int max = 8;
    /**
     * 定义数组，保存皇后放置的位置 如 {0,4,7,5,2,6,1,3}
     */
    int[] arr = new int[max];

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);


    }

    /**
     * 查看放置的第n个皇后是否和前面摆放的冲突
     *
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1. arr[i]==arr[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(arr[n]-arr[i]) 表示判断第n个皇后是否和第i个皇后是否在同一个斜线
            //n=1 放置第2列 1 n=1 arr[1]=1
            // Math.abs(1-0)==1 Math.abs(arr[n]-arr[i])=Math.abs(1-0)=1

            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }


    private void check(int n) {
        //n==8 8个皇后已经摆好
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            arr[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            //不冲突
            if (judge(n)) {
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行arr[n]=i;即将第n个皇后，放置在本行的后移一个位置
        }
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }


    class Time1 {
        /**
         * 时间频度
         * <p>
         * 忽略常数项 2n+20 和 2n 随着n的变大，执行曲线无限接近，20可以忽略
         * 忽略低次项 2n^2+3n+10 和 2n^2 随着n的变大，执行曲线无线接近，3n+10可以忽略
         * 忽略系数 5n^2+7n和3n^2+2n, 随着n的变大，执行曲线重合，这种情况下可以忽略5和3
         */
        void demo() {
            int total = 0;
            int end = 100;
            //T(n)=n+1
            for (int i = 0; i <= end; i++) {
                total += i;
            }

            //T(n)=1
            total = (1 + end) * end / 2;
        }

        /**
         * 时间复杂度
         * 1. O(1) 常数阶
         * 2. O(logn) 对数阶
         * 3. O(n) 线性阶
         * 4. O(nlog2n) 线性对数阶
         * 5. O(n^2) 平方阶
         * 6. O(n^3) 立方阶
         * 7. O(n^k) k次方阶
         * 8. O(2^n) 指数阶
         */


        /**
         * 常数阶 O(1)
         * 无论代码有多少行，只要是没有循环等复杂结构，那这个代码的时间复杂度就是 O(1)
         */
        void demo1() {
            int a = 1;
            int b = 1;
            System.out.println(a);
        }

        /**
         * 对数阶O(log2n)
         * 在循环里面，每次都将i乘以2，乘完之后，i距离n越来越近。
         * 假设循环x次后，i大于n，推出循环。也就是说2的x次方等于n，那么x=log2n也就是说当循环log2n次以后，这个代码就结束了。
         * 因此这个代码的时间复杂度为O(log2n).O(log2n)的这个2时间上是根据代码变化的。i*=3; 则是 O(log3n)
         * <p>
         * 如果N=a^x (a>0,a!=1), 即a的x次方等于N(a>0,且a!=1),那么数x叫做以a为底n的对数(logarithm),
         * 记作x=logaN.其中，a叫做对数的底数，N叫做真数，x叫做“以a为底N的对数”
         * <p>
         * log(2) 8 = 3
         * 2^3 =8
         * <p>
         * log(3) 9 = 2
         * 3^2 = 9;
         */

        void demo2() {
            int i = 1;
            int n = 100;
            while (i < n) {
                //2是底数
                i *= 2;
            }
        }

        /**
         * 线性阶 O(n)
         * 这个循环会执行n遍,因此它消耗的时间是随着n的变化而变化的，
         * 因此此类代码都可以用O(n)来表示它的时间复杂度
         */
        void demo3() {
            int n = 10;
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
        }


        /**
         * 线性对数阶 O(nlogN)
         * 线性对数阶就是将时间复杂度为 O(logn)[对数阶]的代码循环N遍
         * 那么它的时间复杂度就是n * O(logN)，也就是O(nlogN)
         */
        void demo4() {
            int n = 10;
            int i;
            for (int m = 0; m < n; m++) {
                i = 1;
                while (i < n) {
                    i *= 2;
                }
            }
        }

        /**
         * 平方阶 O(n^2)
         * 如果把O(n)的代码在嵌套循环一遍，它的时间复杂度就是 O(n*n) 即O(n^2)
         * 如果将其中一层循环的n改成m,那它的时间复杂度就变成了O(m*n)
         */
        void demo5(){
            int n = 5;
            for (int i = 0; i < n; i++) {
                for (int m = 0; m < n; m++) {
                    System.out.println(i);
                }
            }
        }
        /**
         * 立方阶 O(n^3)
         */
        /**
         * k次方阶 O(n^k)
         */

        /**
         * 指数阶 O(2^n)
         */



    }

}
