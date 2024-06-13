package  com.warship.leedcode.shuzu;

import java.util.ArrayList;
import java.util.List;

public class _442_FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        int tmp;
        for (int i = 0; i < length; i++) {
            tmp = nums[i] > length ? nums[i] - length : nums[i];
            if (nums[tmp - 1] > length) {
                res.add(tmp);
            } else {
                nums[tmp - 1] += length;
            }

        }
        return res;
    }

    public List<Integer> findDuplicates_(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        int tmp;
        for (int i = 0; i < length; i++) {
            tmp = Math.abs(nums[i]);
            if (nums[tmp - 1] < 0) {
                res.add(tmp);
            } else {
                nums[tmp - 1] *= -1;
            }

        }
        return res;
    }


    public static void main(String[] args) {
        _442_FindDuplicates test = new _442_FindDuplicates();
        List<Integer> duplicates = test.findDuplicates_(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(duplicates);
    }
}
