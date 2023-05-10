package com.wj.stack;

/**
 * @author wangjie
 * @date 2020/5/14 22:36
 */
public class ArrayStackDemo {


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        System.out.println("stack.isEmpty() = " + stack.isEmpty());
/*
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(56);
        System.out.println("stack.isEmpty() = " + stack.isEmpty());

        stack.list();

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());*/

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.list();
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.list();
    }

}

class ArrayStack{
    //栈大小
    private int maxSize;
    //
    private int[] stack;
    //栈顶
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack =  new int[maxSize];
    }

    public int size(){
        return top+1;
    }


    /**
     * 存入一个元素
     * @param data
     */
    public void push(int data){
        top++;
        if (maxSize == top) {
            System.err.println("栈已满...");
            return;
        }
        stack[top] = data;
    }

    /**
     * 弹出一个元素
     * @return
     */
    public int pop(){
        if (top == -1) {
            throw new RuntimeException("暂无元素");
        }
        int i = stack[top--];
        stack[top+1]=0;
        return i;
    }


    public int peek(){
        if (top == -1) {
            throw new RuntimeException("暂无元素");
        }
        return stack[top];
    }



    public void list(){
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }


    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isNotEmpty(){
        return top!=-1;
    }

}
