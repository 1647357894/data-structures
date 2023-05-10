package com.wj.linkedList;

/**
 * @author wangjie
 * @date 2020/5/13 22:03
 */
public class Josefu {
    public static void main(String[] args) {
        CircleSingleLinkList list = new CircleSingleLinkList();
        list.addBoy(5);
        list.show();
        list.countBoy(1,3,5);
    }
}

/**
 * 设编号为 1，2，… n 的 n 个人围坐一圈，约定编号为 k（1<=k<=n）的人从 1 开始报数，数到 m 的那个人出列，
 * 它的下一位又从 1 开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此 产生一个出队编号的序列。
 */
class CircleSingleLinkList {
    /**
     * 创建第一个first节点，当前节点没有编号
     */
    private Boy first;

    /**
     * 添加节点，形成环形链表
     *
     * @param
     */
    public void addBoy(int nums) {
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            //创建节点
            Boy boy = new Boy(i);
            //第一个节点
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                //形成链
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    public void show() {
        Boy cur = first;
        while (true) {
            System.out.println("第 = " + cur.getNo() + " node");
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * 根据用户输入，计算出boy出圈顺序
     * @param startNo 第几个boy开始
     * @param countNum 数几下
     * @param nums 有多少个boy
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //辅助指针
        Boy helper = this.first;

        //将helper设置为最后一个节点
        while (helper.getNext() != first) {
            //说明指向最后一个小孩节点
            helper = helper.getNext();
        }
        //报数前，先让first 和 helper移动 k-1次
        // 第几个人开始报数 如 第二个人  2-1==1 移动一次
        for (int j = 0; j < startNo-1; j++) {
                first = first.getNext();
                helper = helper.getNext();
        }

        //开始报数时，让 first helper 指针同时移动 m-1次，然后出圈。
        while (helper != first) {
            // 判断是否只有一个节点
            //countNum 数几次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //出圈
            System.out.printf("node %d 出圈\n", first.getNo());

            //将first指向node节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
    }


}

class Boy {
    private int no;
    //下一个节点
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
