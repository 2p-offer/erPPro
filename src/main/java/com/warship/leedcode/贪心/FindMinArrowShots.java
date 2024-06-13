package  com.warship.leedcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (int[] ints, int[] t1) -> {
            if (ints[0] > t1[0]) {
                return 1;
            } else if (ints[0] < t1[0]) {
                return -1;
            } else {
                return -1;
            }
        });

        int res = 1;
        int index = 0;
        int size = points.length;
        int max = points[0][1];
        while (index < size) {
            int[] ints = points[index];
            if (ints[0] > max) {
                res++;
                max = ints[1];
            }
            if (ints[1] < max) {
                max = ints[1];
            }
            index++;
        }
        return res;
    }

    public static int findMinArrowShots_210908(int[][] points) {
        int length = points.length;
        if (length == 0) {
            return 0;
        }
        int ans = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int index = 1;
        int[] tmp = points[0];
        while (index < length) {
            //当前气球可以被当前箭支戳爆
            if (points[index][0] <= tmp[1]) {
                index++;
                continue;
            }
            tmp = points[index];
            ans++;
            index++;
        }

        return ans;

    }


    public static void main(String[] args) {
        int[][] test = new int[4][2];
        test[0] = new int[]{1, 2};
        test[1] = new int[]{3, 4};
        test[2] = new int[]{5, 6};
        test[3] = new int[]{7, 8};

        int minArrowShots = findMinArrowShots(test);
        int minArrowShots2 = findMinArrowShots_210908(test);

        System.out.println(minArrowShots + ".." + minArrowShots2);

    }
}
