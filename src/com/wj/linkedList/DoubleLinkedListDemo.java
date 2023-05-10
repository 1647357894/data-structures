package com.wj.linkedList;

/**
 * @author wangjie
 * @date 2020/5/11 23:10
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
      /*  list.add(new HeroNode2(1,"aa","ab"));
        list.add(new HeroNode2(2,"aab","ab3"));
        list.add(new HeroNode2(3,"aan","ab4"));
        list.list();
        System.out.println("update-------");
        list.update(new HeroNode2(3,"abc","666"));
        list.list();
        System.out.println("-------------");
        list.del(1);
        list.list();*/

        list.addOrder(new HeroNode2(1,"aa","ab"));
        list.addOrder(new HeroNode2(3,"aan","ab4"));
        list.addOrder(new HeroNode2(2,"aab","ab3"));
        list.list();


    }
}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0, "", "");

    void add(HeroNode2 node) {
        HeroNode2 tmp = this.head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = node;
        node.pre = tmp;
    }

    public void addOrder(HeroNode2 node){
        HeroNode2 tmp = this.head;
        while (true) {
            if (tmp.next == null) {
                break;
            }

            if (tmp.next.no > node.no) {
                node.pre = tmp;
                node.next = tmp.next;
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = node;


    }


    public void del(int no) {

        HeroNode2 tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == no) {
                tmp.next = tmp.next.next;
                tmp.next.next.pre = tmp;
                break;
            }
        }

    }

    public void update(HeroNode2 node) {
        HeroNode2 tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == node.no) {
                node.next = tmp.next.next;
                node.pre = tmp;
                tmp.next = node;
                break;
            }
            tmp = tmp.next;
        }
    }

    public void list() {
        HeroNode2 tmp = head.next;
        while (true) {
            if (tmp == null) {
                break;
            }
            System.out.println("tmp = " + tmp);
            tmp = tmp.next;
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode2 next;
    //前一个节点
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
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
