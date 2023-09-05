package com.warship.test.leedcode.daily._21_03;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class _3_30_SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int hang = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) {
                return true;
            }
            if (matrix[i][0] < target) {
                hang = i;
            }
            if (matrix[i][0] > target) {
                break;
            }
        }
        if (hang == -1) {
            return false;
        }
        return searchMatrix(matrix[hang], 0, matrix[hang].length - 1, target);
    }

    private static boolean searchMatrix(int[] matrix, int start, int end, int target) {
        if (end - start <= 1) {
            return matrix[start] == target || matrix[end] == target;
        }
        int mid = (start + end + 1) / 2;
        if (target == matrix[mid]) {
            return true;
        } else if (target > matrix[mid]) {
            return searchMatrix(matrix, mid, end, target);
        } else {
            return searchMatrix(matrix, start, mid, target);
        }
    }


    //-=-=-=-=-= 两次二分查找 [官方题解]-=-=-=

    public boolean searchMatrix_main(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{1, 3};
//        boolean b = searchMatrix(new int[][]{new int[]{1, 3}}, 3);
//        System.out.println(b);
    }
}

