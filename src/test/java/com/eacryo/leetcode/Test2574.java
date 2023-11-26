package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2574 {
    /**
     * https://leetcode.cn/problems/left-and-right-sum-differences/description/
     * 此题和238类似
     */
    class Solution2574 {
        public int[] leftRightDifference(int[] nums) {
            int length = nums.length;
            int[] result = new int[length];
            if (length == 1){
                return new int[]{0};
            }
            int right = 0;
            result[0] = 0;
            for (int i = 1; i < length; i++) {
                result[i] = result[i-1] + nums[i-1];
            }
            for (int i = length -1; i >= 0 ; i--) {
                result[i] = result[i] - right > 0?result[i] - right:-(result[i] - right) ;
                right = right + nums[i];
            }
            return result;
        }
    }

    @Test
    public void test(){
        Solution2574 solution2574 = new Solution2574();
        int[] nums = {10,4,8,3};
        int[] result = solution2574.leftRightDifference(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(result[i]);
        }
    }
}
