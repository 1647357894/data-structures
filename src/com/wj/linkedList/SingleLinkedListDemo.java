package com.wj.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表
 *
 * @author wangjie
 * @date 2020/5/10 22:39
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

      /*  HeroNode n1 = new HeroNode(1, "n1", "nn");
        HeroNode n2 = new HeroNode(2, "n2", "nnn");
        HeroNode n3 = new HeroNode(3, "n3", "nnnn");
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.list();
        System.out.println("-----------del---------");
        list.del(1);
        list.list();

        System.out.println("---------update---------");
        list.update(new HeroNode(2, "nn2", "jack"));
        list.list();*/

        System.out.println("addOrder------------");

        HeroNode n1 = new HeroNode(1, "n1", "n");
        HeroNode n2 = new HeroNode(2, "n2", "nn");
        HeroNode n3 = new HeroNode(3, "n3", "nnn");
        HeroNode n4 = new HeroNode(4, "n4", "nnnn");
        list.addOrder(n4);
        list.addOrder(n2);
        list.addOrder(n1);
        list.add(0, n3);
        list.list();
        System.out.println("list.size() = " + list.size());

        System.out.println("list.getLast(2) = " + list.getLast(2));
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(0) = " + list.get(1));
        System.out.println("list.get(0) = " + list.get(2));
        //System.out.println("list.get(0) = " + list.get(-1));
        List<String> list1 = new ArrayList<>();
        //list1.add()
        list.reversList(list.head);
        list.list();
 

    }


}

class SingleLinkedList {

    /**
     * head 头节点不动，不存放具体数据
     */
    HeroNode head = new HeroNode(0, "", "");

    /**
     * 尾插法
     * 添加节点到单链表
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next指向新的节点
     *
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode tmp = head;
        while (true) {
            // next 等于null 代表是最后一个节点
            if (tmp.next == null) {
                break;
            }
            //不是最后一个节点，将tmp往后移
            tmp = tmp.next;
        }

        // 将节点最后一个节点的next域指向新加入的节点
        tmp.next = node;
    }

    /**
     * 指定下标插入数据
     *
     * @param index
     * @param node
     */
    public void add(int index, HeroNode node) {


        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index);


        //这里没直接用next 元素， 因为需要考虑索引为0
        HeroNode tmp = head;
        int i = -1;
        while (tmp != null) {
            //找到该节点
            if (i == index - 1) {
                node.next = tmp.next;
                tmp.next = node;
                break;
            }
            i++;
            tmp = tmp.next;
        }

    }

    /**
     * 升序排序添加节点
     *
     * @param node
     */
    public void addOrder(HeroNode node) {

        HeroNode tmp = head;
        while (true) {
            //最后一个节点
            if (tmp.next == null) {
                break;
            }
            //找到比新加入的节点大的节点。
            if (tmp.next.no > node.no) {
                break;
            }
            tmp = tmp.next;
        }

        //新节点的next
        node.next = tmp.next;
        //将
        tmp.next = node;


    }

    /**
     * 删除指定编号的元素
     *
     * @param no
     */
    public void del(int no) {
        HeroNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == no) {
                tmp.next = tmp.next.next;
                break;
            }
        }

    }

    /**
     * 移除指定下标的元素
     *
     * @param index
     */
    public void remove(int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index);
        int i = -1;
        HeroNode tmp = head;
        while (tmp.next != null) {
            if (i == index - 1) {
                HeroNode node = tmp.next;
                tmp.next = node.next;
                node.next = null;
            }
            i++;
            tmp = tmp.next;
        }

    }
    public void clearList() {
      this.head.next  =null;
    }


    /**
     * 获取指定索引的数据
     *
     * @param index
     */
    public HeroNode get(int index) {

        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        HeroNode tmp = head.next;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                return tmp;
            }
            i++;
            tmp = tmp.next;

        }
        throw new RuntimeException("not find");

    }

    public void update(HeroNode node) {
        HeroNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == node.no) {
                node.next = tmp.next.next;
                tmp.next = node;
                break;
            }
        }
    }

    public void list() {
        HeroNode tmp = head.next;
        while (tmp != null) {
            System.out.println("tmp = " + tmp);
            tmp = tmp.next;
        }
    }

    /**
     * 获取有效节点数
     *
     * @return
     */
    public int size() {

        //或者  HeroNode tmp = this.head.next;
        // count = 0;

        HeroNode tmp = this.head;
        //因为第一个tmp是head头节点，不计算
        int count = -1;
        while (true) {
            //head节点第一次进来初始化为0
            count++;
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        return count;

    }

    //查找单链表中的倒数第 k 个结点
    public HeroNode getLast(int k) {
        HeroNode tmp = this.head;
        // 正数第N个
        //i = 4 - 2 +1;
        //i = 4 - 1 +1;
        int i = size() - k + 1;
        for (int j = 1; j <= i; j++) {

            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 反转单链表
     */
    public void reversList(HeroNode head) {
        //定义一个辅助变量
        HeroNode cur = head.next;
        HeroNode reversHead = new HeroNode(0, "", "");
        HeroNode next = null;
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reversHead的最前端
        while (cur != null) {
            //先暂时保存当前的节点的下一个节点，因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reversHead.next;
            //将cur 连接到新的链表上
            reversHead.next = cur;
            //让cur后移
            cur = next;
        }
        //将head.next 指向reversHead.next 实现单链表反转
        head.next = reversHead.next;
    }

}

/**
 * 节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName=" + nickName + "}";
    }
}
