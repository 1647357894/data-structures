package com.wj.queue;

/**
 * 使用数组模拟环形队列【循环队列】
 *
 * @author wangjie
 * @date 2020/5/6 22:59
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        /**
         * 0%3 = 0
         * 1%3 = 1
         * 2%3 = 2
         * 3%3 = 0
         * 4%3 = 1
         */
        CircleArray queue = new CircleArray(4);
        queue.push(2);
        queue.push(1);
        queue.push(4);
        queue.showQueue();
        System.out.println("queue.isFull() = " + queue.isFull());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
        System.out.println("queue.getHeadData() = " + queue.getHeadData());
        System.out.println("queue.pop() = " + queue.pop());
        System.out.println("queue.pop() = " + queue.pop());
        System.out.println("queue.pop() = " + queue.pop());
        System.out.println("queue.size() = " + queue.size());
        queue.showQueue();
    }


}

class CircleArray {
    /**
     * front 指向队列的第一个元素
     */
    private int front;
    /**
     * rear 队列尾指向队列的最后一个元素的后一位！
     */
    private int rear;
    /**
     * 队列最大值
     */
    private int maxSize;
    /**
     * 存队列的数组
     */
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        // 0 %3 ==0
        return (rear + 1) % maxSize == front;
    }

    /**
     * 添加数据到队列
     * 尾指针往后移
     */
    public void push(int n) {
        //判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满...");
        }
        arr[rear] = n;
        // 必须取模 todo
        rear = (rear + 1) % maxSize;
    }

    /**
     * 弹出队头
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        int tmpVal = arr[front];
        // front++ 不行 todo
        // front 0
        front = (++front) % maxSize;
        return tmpVal;
    }
    /**
     * 显示队列所有数据
     */
    public void showQueue(){

        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }

      /*  for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }*/
        for (int i = front; i < rear; i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    /**
     * 显示队列头数据
     */
    public int getHeadData(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        return arr[front];
    }
    /**
     * 队列有效个数
     */
    public int size() {


        //1 3 0 % 3 = 1
        //2 3 0 % 3 = 2
        return (rear - front + maxSize) % maxSize;
    }


}
