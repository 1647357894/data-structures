package com.wj.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangjie
 * @date 2020/5/23 21:53
 */
public class RecursionTest {
    public static void main(String[] args) {

        for (int i = 1; i < 5; i++) {
            System.out.println("fbi("+i+") = " + fbi(i));
        }

        //递归调用规则
        /**
         * 1.当程序执行到一个方法时，就会开辟一个独立的空间(栈)
         * 2.每个空间的数据(局部变量),是独立的。 类似闭包  引用类型共享
         */


        //   test(3);
        System.out.println("factorial(3) = " + factorial(3));

        /**
         * 递归重要规则
         * 1.执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
         * 2.方法的值类型变量是独立的，不会互相影响, 引用类型变量，就会共享该变量
         * 3.递归必须向推出条件逼近，否则就会无限递归，出现栈溢出
         * 4.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。
         */
        Queue q = new LinkedList();
        q.offer("");
        q.poll();
    }


    static void test(int num) {
        if (num > 2) {
            test(num - 1);
        }
        System.out.println("num = " + num);
    }

    static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }

    /**
     * 斐波那契额数列
     * @param i
     * @return
     */
    static int fbi(int i){
        if (i <2){
            return i ==0?0:1;
        }
        return fbi(i-1)+fbi(i-2);
    }





}
