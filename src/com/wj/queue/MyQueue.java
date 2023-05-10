package com.wj.queue;

/**
 * @author wangjie
 * @date 2020/9/5 23:28
 */
public class MyQueue {
    private int arr[];
    //队头
    private int front;
    //队尾
    private int rear;

    public MyQueue(int capacity) {
        arr = new int[capacity];
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enQueue(0);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.outPut();
    }

    void enQueue(int element) {

        //判断队列已满公式
        if ((rear + 1) % arr.length == front) {
            throw new RuntimeException("队列已满!");
        }
        arr[rear] = element;
        //重新计算队尾
        rear = (rear + 1) % arr.length;

    }

    int deQueue() {
        //判断队列是否为空 公式
        if (rear == front) {
            throw new RuntimeException("队列为空");
        }
        int deQueueElement = arr[front];
        //重新计算队头位置
        front = (front + 1) % arr.length;
        return deQueueElement;
    }

    void outPut() {
        for (int i = front; i != rear; i = (i + 1) % arr.length) {
            System.out.println(arr[i]);
        }
    }
}
