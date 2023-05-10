package com.wj.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**中缀表达式转为后缀表达式
 * @author wangjie
 * @date 2020/5/18 23:41
 */
public class PolandNotation {
    public static void main(String[] args) {
        // (30+4)*5-6  ==>30 4 + 5 6 - *

        List<String> list = parseSuffixExpressionList("1+((2+3)*4)-5");
        System.out.println("list = " + list);

        Stack<Integer> stack = new Stack<>();
        for (String item : list) {
            if (isOper(item)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(cal(num1, num2, item.charAt(0)));
            } else {
                stack.push(Integer.parseInt(item));
            }
        }
        System.out.println(stack.pop());


        //1+((2+3)*4)-5
        /**
         *  从左向右遍历，遇到数字输出，符号入栈，(左括号入栈，没有遇到)右括号就不出栈，
         * 运算符入栈前比较优先级
         * 当前运算符和栈顶运算符相比
         * 【当前运算符】优先级高的话直接入栈
         * 当前运算符优先级低或等于栈顶运算符 将栈顶运算符弹出  直到栈里的运算符优先级大于当前运算符优先级或栈为空。
         * 结束
         *
         * 中缀转后缀
         *
         * 1+((2+3)*4)-5
         * 表达式 1
         * 符号栈 +
         *
         * 1+((2+3)*4)-5
         * 表达式 1
         * 符号栈 +(
         *
         * 1+((2+3)*4)-5
         * 表达式 1
         * 符号栈 +((
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2
         * 符号栈 +((
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2
         * 符号栈 +((+
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3
         * 符号栈 +((+
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 +
         * 符号栈 +(
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 +
         * 符号栈 +(*
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 + 4
         * 符号栈 +(*
         *
         *
         * 碰到右括号 出栈
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 + 4 *
         * 符号栈 +
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 + 4 * +
         * 符号栈 -
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 + 4 * + 5
         * 符号栈 -
         *
         * 1+((2+3)*4)-5
         * 表达式 1 2 3 + 4 * + 5 -
         *  符号栈
         */

    }

    /**
     * 将中缀表达式转为后缀表达式
     *
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpressionList(String str) {
        //中缀表达式集合
        List<String> ls = new ArrayList<>();
        for (char c : str.toCharArray()) {
            ls.add(String.valueOf(c));
        }

        //符号栈
        Stack<String> s1 = new Stack<>();
        //存储中间结果
        List<String> s2 = new ArrayList<>();

        for (String item : ls) {
            //数字直接加入到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (s1.empty() || "(".equals(item)) {
                s1.push(item);

            }//右括号
            else if (item.equals(")")) {
                // 如果是右括号 ，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号遗弃
              /*  if (priority(item) < priority(s1.peek())) {
                    s1.push(item);
                }*/
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();// 将 ( 弹出s1栈，消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转入到 与s1中新的栈顶运算符比较
                while (s1.size() != 0 && priority(s1.peek()) <= priority(item)) {
                    s2.add(s1.pop());
                }
                //还需将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入到s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;

    }

    /**
     * 计算方法
     *
     * @param c1
     * @param c2
     * @param oper
     * @return
     */
    static int cal(int c1, int c2, int oper) {
        int r = 0;
        switch (oper) {
            case '+':
                r = c1 + c2;
                break;
            case '-':
                r = c2 - c1;
                break;
            case '*':
                r = c1 * c2;
                break;
            case '/':
                r = c2 / c1;
                break;
            default:
        }
        return r;
    }

    /**
     * 判断是否是操作符
     *
     * @param c
     * @return
     */
    static boolean isOper(String c) {
        List<String> opers = Arrays.asList("+", "-", "*", "/");
        return opers.contains(c);
    }

    /**
     * 数字越小优先级越大
     *
     * @param oper
     * @return
     */
    static int priority(String oper) {
        if ("*".equals(oper) || "/".equals(oper)) {
            return 0;
        } else if ("+".equals(oper) || "-".equals(oper)) {
            return 1;
        } else {
            return 2;
        }
    }

/*
*
* 中转后  9+(3-1)×3+10÷2   9 3 1-3*+10 2/+    9 3 1 - 3 * + 10 2 / +
*
* 表达式 9
* 符号栈
*
 * 表达式 9
 * 符号栈 +
 *
 * 表达式 9
 * 符号栈 +(
 *
 * 表达式 9 3
 * 符号栈 +(
 *
 * 表达式 9 3
 * 符号栈 +(-
 *
 * 表达式 9 3 1
 * 符号栈 +(-
 *
 * 表达式 9 3 1 -
 * 符号栈 +
 *
 * 当前运算符【*】优先级高于栈顶运算符【+】 入栈
 * 表达式 9 3 1 -
 * 符号栈 + *
 *
 * 表达式 9 3 1 - 3
 * 符号栈 + *
 *
 *
 * 当前运算符【+】优先级低于栈顶运算符【*】 出栈 直到优先级小于等于自己
 *  先加上出栈的运算符 最后加上当前运算符
 * 表达式  9 3 1 - 3 * +
 * 符号栈 +
 *
 * 表达式  9 3 1 - 3 * + 10
 * 符号栈  +
 *
 * 当前运算符【/】 优先级高于栈顶符号【+】 入栈
 * 表达式 9 3 1 - 3 * + 10
 * 符号栈 + /
 *
 * 表达式 9 3 1 - 3 * + 10 2 / +
 * 符号栈
 * */
}
