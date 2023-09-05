package com.warship.test.leedcode.daily._21_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 *示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 */
public class _3_15_SpiralMatrix {
    public static void main(String[] args){
//      int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};

        int[][] matrix = new int[][] {{1,2},{4,5}};
//      int[][] matrix = new int[][] {{1,2,3}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.println(spiralOrder);
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        spSingleCircle(res, matrix, 0);
        return res;

    }

    /**
     * 遍历第index圈
     * @param container 结果收集容器
     * @param matrix 数据源
     * @param index 第index 圈
     */
    public static void spSingleCircle(List<Integer> container, int[][] matrix, int index) {
        int m = matrix.length;
        int n = matrix[0].length;
        int currentM = index;
        int currentN = index;
        int endM = m - index -1;
        int endN = n - index -1;
        boolean isEnd = false;
        while(true) {
            if(isEnd && currentM == currentN && currentM == index) {
                break;
            }
            container.add(matrix[currentM][currentN]);
            if(currentM == currentN && currentM == index) {
                isEnd = true;
            }

            //第一行
            if(currentN < endN && currentM == index) {
                currentN ++;
                continue;
            }
            //最后一列
            if(currentN == endN  && currentM < endM) {
                currentM ++;
                continue;
            }
            //最后一行
            if(currentN > index && currentM == endM && currentM != index) {
                currentN -- ;
                continue;
            }
            //第一列
            if(currentN == index && currentM > index && currentN != endN) {
                currentM --;
                continue;
            }
            break;
        }

        if(endM == index || endN == index || ((endM - index) < 2 )|| ((endN - index) < 2 )) {
            return;
        }
        spSingleCircle(container,matrix,++index);
    }
}
