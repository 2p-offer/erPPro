package  com.warship.leedcode.daily._21_05;

import java.util.*;

public class _5_02_LeastBricks {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> container = new HashMap<>();

        int tmp = 0;
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> wa = wall.get(i);
//            int size = wa.size() > 1 ? wa.size() - 1 : wa.size();
            for (int j = 0; j < wa.size() - 1; j++) {
                tmp += wa.get(j);
                int a = container.getOrDefault(tmp, 0);
                container.put(tmp, a + 1);
            }
            tmp = 0;
        }
        if (container.values().size() == 0) {
            return wall.size();
        }
        tmp = Integer.MIN_VALUE;
        for (int val : container.values()) {
            tmp = Math.max(tmp, val);
        }
        return wall.size() - tmp;

    }

    public static void main(String[] args) {
        _5_02_LeastBricks test = new _5_02_LeastBricks();
//        Integer[][] tmp = new Integer[][]{{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
        Integer[][] tmp = new Integer[][]{{1}, {1}, {1}};

        List<List<Integer>> wall = new ArrayList<>();
        for (Integer[] t : tmp) {
            wall.add(Arrays.asList(t));
        }
        System.out.println("lsit:" + wall);
        int i = test.leastBricks(wall);
        System.out.println(i);

    }
}
