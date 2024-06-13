package  com.warship.leedcode.daily._21_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 73. 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 1:
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 2:
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 */
public class _3_21_SetZeroes {
    public void setZeroes(int[][] matrix) {
        List<Integer> rowslist = new ArrayList<>();
        List<Integer> colslist = new ArrayList<>();
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if (matrix[i][j] == 0) {
                    rowslist.add(i);
                    colslist.add(j);
                }
            }
        }
        for (int i = 0; i < rowslist.size(); i++) {
            int row = rowslist.get(i);
            for (int j = 0; j < collen; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int i = 0; i < colslist.size(); i++) {
            int col = colslist.get(i);
            for (int j = 0; j < rowlen; j++) {
                matrix[j][col] = 0;
            }
        }
    }
}
