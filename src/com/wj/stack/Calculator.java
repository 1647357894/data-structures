package com.wj.stack;

/**栈实现综合计算  中缀表达式
 * @author wangjie
 * @date 2020/5/17 20:18
 */
public class Calculator {

    public static void main(String[] args) {
        //11
        String expression = "1002+30*4/2-2-1000";
//          expression = "(1002+30)*4/2-2-1000";
        //数栈
        ArrayStack numStack = new ArrayStack(10);
        //操作符栈
        ArrayStack operStack = new ArrayStack(10);


        StringBuffer sb = new StringBuffer();
        int index = -1;
        // 扫描表达式
        for (char c : expression.toCharArray()) {
            index++;

            if (isOper(c)) {
                if (operStack.isEmpty() || priority(c) < priority(operStack.peek())) {
                    operStack.push(c);
                } else if (priority(c) >= priority(operStack.peek())) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    int oper = operStack.pop();
                    numStack.push(cal(num1, num2, oper));
                    operStack.push(c);
                }
            } else {

                sb.append(c);
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(sb.toString()));
                } else {
                    if (isOper(expression.substring(index +1, index + 2).charAt(0)))
                    {
                        numStack.push(Integer.parseInt(sb.toString()));
                        sb = new StringBuffer();
                    }
                }
            }
        }

        //顺序的从数栈和符号栈pop出相应的数和符号
        while (operStack.isNotEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = operStack.pop();
            numStack.push(cal(num1, num2, oper));

        }

        System.out.println(numStack.pop());


    }

    /**
     * 判断是否是操作符
     *
     * @param c
     * @return
     */
    static boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * 数字越小优先级越大
     *
     * @param oper
     * @return
     */
    static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 0;
        } else if (oper == '+' || oper == '-') {
            return 1;
        } else {
            return 2;
        }
    }

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

}
