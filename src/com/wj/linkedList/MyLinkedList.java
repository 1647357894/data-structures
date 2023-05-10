package com.wj.linkedList;

/**
 * @author wangjie
 * @date 2020/9/5 0:00
 */
public class MyLinkedList {
    //头节点
    private Node head;
    //尾节点
    private Node last;
    private int size;

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(3, 0);
        linkedList.insert(6, 1);
        linkedList.insert(9, 2);
        linkedList.outPut();
        linkedList.remove(2);
        linkedList.remove(1);
        linkedList.remove(0);
        linkedList.outPut();
    }

    Node get(int index) {
        checkIndex(index);
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;

    }

    void insert(int data, int index) {
        //判断 index是否在范围内
        checkIndex(index);

        Node node = new Node(data);
        //空链表
        if (size == 0) {
            this.head = node;
            this.last = node;
        } else if (index == 0) {
            //插入头部
            node.next = head;
            head = node;
        } else if (size == index) {
            //插入尾部
            last.next = node;
            last = node;
        } else {
            //插入中间
            Node preNode = get(index - 1);
            node.next = preNode.next;
            preNode.next = node;
        }

        size++;

    }

    private void checkIndex(int index) {
        if ((index < 0 || index > size)) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
    }

    Node remove(int index) {
        checkIndex(index);
        Node removeNode = null;
        if (index == 0) {
            //移除头部
            removeNode = this.head.next;
            this.head = removeNode;
        } else if (index == size) {
            //移除尾部
            //获取尾部前一个元素
            Node preNode = get(index - 1);
            //移除的节点
            removeNode = preNode.next;
            preNode.next = null;
            this.last = preNode;
        } else {
            //移除中间

            Node preNode = get(index - 1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;

        }
        return removeNode;
    }

    void outPut() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println("tmp = " + tmp);
            tmp = tmp.next;
        }

    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}

