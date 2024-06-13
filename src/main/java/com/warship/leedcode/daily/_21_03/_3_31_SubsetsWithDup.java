package  com.warship.leedcode.daily._21_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class _3_31_SubsetsWithDup {


    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        if (nums == null) {
            return res;
        }
        res.add(new ArrayList<>());
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> iList = new ArrayList<>();
//            for(int j = i ;j < nums.length;j ++){
//                iList.add(nums[j]);
//                res.add(new ArrayList<>(iList));
//            }
//        }
//        res.add(new ArrayList<>());

        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
        }


        getList(new ArrayList<>(), nums, 3, 0);

        return res;
    }

    /**
     * @param nums
     * @param sonLength
     * @return
     */
    private static void getList(int[] nums, int sonLength) {
        List<List<Integer>> sonLengthList = new ArrayList<>();
        //pre 循环，记住上一次选择
        int preData = -1;
        int preIndex = -1;

        int jData = -1;
        boolean isJ = true;
        boolean isPre = true;
        List<Integer> sonList = new ArrayList<>();

        for (int i = 0; i < (nums.length - sonLength); i++) { //这层循环代表起始位置从i开始
            for (int pre = i; pre < nums.length; pre++) {
                //先从sonlist 存放 sonLength -1 个元素
                if (sonList.size() == sonLength - 1) {
                    preIndex = pre;
                    break;
                }
                if (isPre || nums[pre] != preData) {
                    sonList.add(nums[pre]);
                    preData = nums[pre];
                    isPre = false;
                }

            }

            for (int j = preIndex; j < nums.length; j++) {
                if (isJ || nums[j] != jData) {
                    List<Integer> jList = new ArrayList<>(sonList);
                    jList.add(nums[j]);
                    sonLengthList.add(jList);
                    jData = nums[j];
                    isJ = false;
                }
            }
            jData = -1;
            isJ = true;
            System.out.println(sonLengthList);

        }
    }


    /**
     * @param nums
     * @param sonLength
     * @return
     */
    private static void getList(List<Integer> sonList, int[] nums, int sonLength, int currentIndex) {
//        List<List<Integer>> sonLengthList = new ArrayList<>();
        int jData = -1;
        boolean isJ = true;
        boolean isPre = true;
        if (currentIndex == nums.length) {
            return;
        }
        for (int pre = currentIndex; pre <= nums.length; pre++) {
            //先从sonlist 存放 sonLength -1 个元素
            if (sonLength == 1 || sonList.size() == sonLength - 1) {
                currentIndex = pre;
                break;
            }
            if (isPre || sonList.size() == 0 || nums[pre] != sonList.get(sonList.size() - 1)) {
                sonList.add(nums[pre]);
                isPre = false;
            }
        }

        for (int j = currentIndex; j < nums.length; j++) {
            if (isJ || nums[j] != jData) {
                List<Integer> jList = new ArrayList<>(sonList);
                jList.add(nums[j]);
                res.add(jList);
                jData = nums[j];
                isJ = false;
            }
        }
        if (!sonList.isEmpty()) {
            sonList.remove(sonList.size() - 1);
        }
        getList(sonList, nums, sonLength, ++currentIndex);

    }


    /**
     * 官方题解
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup_Main(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,res,temp);
        return res;
    }

    public void dfs(int[] nums,int index,List<List<Integer>> res,List<Integer> temp){

        List<Integer> newL = new ArrayList<>();
        for(int x:temp){
            newL.add(x);
        }
        res.add(newL);
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            dfs(nums,i+1,res,temp);
            temp.remove(temp.size() -1 );
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = subsetsWithDup(new int[]{1, 2, 2, 3, 4});
        System.out.println(lists);

    }
}
