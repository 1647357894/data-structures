package com.wj.sparsearray;

import java.io.*;
import java.util.Arrays;

/**
 * 稀疏数组
 *
 * @author wangjie
 * @date 2020/5/5 21:44
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        /**
         * 11 * 11的棋盘  0代表没有棋子  1代表白子 2代表黑子
         */
        int[][] chessArr1 = new int[11][11];
        chessArr1[4][0] = 1;
        chessArr1[2][1] = 1;
        chessArr1[1][3] = 2;
        chessArr1[2][2] = 2;
        chessArr1[3][1] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //转存为稀疏数组
        //1.获取有多少个数不为0
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum);

        //2.创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 行数
        sparseArr[0][0] = chessArr1.length;
        // 列数
        sparseArr[0][1] = chessArr1[0].length;
        // 非0数
        sparseArr[0][2] = sum;

        //3.将值设置到稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] == 0) {
                    continue;
                }
                count++;
                //行
                sparseArr[count][0] = i;
                //列
                sparseArr[count][1] = j;
                //val
                sparseArr[count][2] = chessArr1[i][j];
            }
        }

        //将稀疏数组写入到文件中
        File file = new File("D://tmp//sparseArr.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (int[] row : sparseArr) {
            for (int data : row) {
                bw.write(data + "#");
            }
            bw.newLine();
        }
        bw.close();

        //读取文件中的稀疏数组
        int[][] sparseArr2 = new int[sum + 1][3];
        BufferedReader br = new BufferedReader(new FileReader(file));
        int count2 = 0;
        while (br.ready()) {
            String[] arr = br.readLine().split("#");
            System.out.println(Arrays.toString(arr));
            sparseArr2[count2][0] = Integer.parseInt(arr[0]);
            sparseArr2[count2][1] = Integer.parseInt(arr[1]);
            sparseArr2[count2][2] = Integer.parseInt(arr[2]);
            count2++;
        }
        br.close();

        System.out.println("----------------------读取文件中的稀疏数组start-----------------");
        for (int[] row : sparseArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("----------------------读取文件中的稀疏数组end-----------------");

        //打印稀疏数组
        System.out.println("----------稀疏数组------");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("------------------");

        //将稀疏数组转为棋盘
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        // 打印恢复后的棋盘
        System.out.println("==============打印恢复后的棋盘===============");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
