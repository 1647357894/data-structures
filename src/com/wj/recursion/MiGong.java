package com.wj.recursion;

/**
 * @author wangjie
 * @date 2020/5/23 23:33
 */
public class MiGong {

    public static void main(String[] args) {


        //地图 0可走 1为墙
        int[][] map = new int[7][8];
        for (int i = 0; i < map[0].length; i++) {
            //设置上下围墙
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            //设置左右围墙
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }

        //设置障碍物
        map[2][1] = 1;
        map[3][2] = 1;
        map[5][3] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[2][4] = 1;

        printMap(map);

        setWay(map, 1, 1);
        System.out.println("---------------小球走过后---------------");
        printMap(map);

    }

    /**
     * 递归回溯给小球找路
     * i,j表示从地图哪个位置出发(1,1)
     * 小球到[6][5]位置 结束
     * map[i][j]= 0表示该点没有走过 1为墙 2为通路可以走 3表示该点已经走过，走不通
     * 走迷宫需要一个策略 下右上左，如果该点走不通 再回溯
     *
     * @param map 地图
     * @param i
     * @param j
     * @return true找到路 false无路可走
     */
    private static boolean setWay(int[][] map, int i, int j) {
        printMap(map);
        //已找到路
        if (map[5][6] == 2) {
            return true;
        } else {
            //当前这个点没有走过
            if (map[i][j] == 0) {
                //下右上左
                map[i][j] = 2; //假定该点是可以走通的
               // return setWay(map, i + 1, j) || setWay(map, i, j + 1) || setWay(map, i - 1, j) || setWay(map, i, j - 1) || (map[i][j] = 3) != 3;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j]不等于0 可能是1,2,3
                return false;
            }
        }


    }
static int count = 1;
    private static void printMap(int[][] map) {
        System.out.println("=============start===="+count+++"=========");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%d\t", map[i][j]);
            }
            System.out.println();
        }
        System.out.println("============end==============");
    }
}
