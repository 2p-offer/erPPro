package com.warship.test.leedcode.动态规划;

public class _jianzhi_42_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = -101;
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
