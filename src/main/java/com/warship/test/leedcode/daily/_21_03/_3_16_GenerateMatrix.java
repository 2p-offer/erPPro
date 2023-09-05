package com.warship.test.leedcode.daily._21_03;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 *
 * eg1:
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * eg2:
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 *
 */
public class _3_16_GenerateMatrix {
    /**
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        collectSingleCircle(res, 1, 0, n);
        return res;
    }

    /**
     * 收集第 index 圈
     * @param container 结果容器
     * @param currentNum 开始数字
     * @param index 第index圈
     * @param n 条件数字 n
     */
    public static void collectSingleCircle(int[][] container,int currentNum,int index,int n) {
        int currentM = index;
        int currentN = index;
        int endM = n - index -1;
        int endN = n - index -1;
        boolean isEnd = false;
        while(true) {
            if(isEnd && currentM == currentN && currentM == index) {
                break;
            }
            container[currentM][currentN] = currentNum ++ ;
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
        collectSingleCircle(container,currentNum,++index,n);
    }




    //-=-=-=-=-=-=  官方题解  -=-=-=-=-=-=-

    public int[][] generateMatrix_Pub(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    matrix[bottom][column] = num;
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
