package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class Test238 {

    /**
     * 题目让我们不要用除法，这题也不该用除法，因为可能会有0
     * 要求 O(1) 的额外空间复杂度内完成这个题目吗（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     * 那么就只能使用一个int[]数组，做法是首先顺序遍历一次，然后在逆序遍历一次
     */

    /**
     * 这样做会超时
     */
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] result = new int[length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = getLeftMultipy(nums,i)*getRightMultipy(nums,i);
            }
            return result;
        }

        private int getLeftMultipy(int[] nums,int place){
            int initValue = 1;
            for (int i = 0; i < place; i++) {
                initValue = initValue*nums[i];
            }
            return initValue;
        }

        private int getRightMultipy(int[] nums,int place){
            int initValue = 1;
            for (int i = place+1; i < nums.length; i++) {
                initValue = initValue*nums[i];
            }
            return initValue;
        }
    }

    /**
     * 空间为o1的方法
     * 且时间复杂度比上面的更低
     */
    class Solution1{
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] result = new int[length];
            result[0] = 1;
            for (int i = 1; i < length; i++) {
                result[i] = result[i-1] * nums[i-1];//这是最关键的一行
            }
            //第二遍，从后往前遍历
            int right = 1;
            for (int i = length-1; i >= 0 ; i--) {
                result[i] = result[i]*right;
                right = right * nums[i];
            }
            return result;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
//        int[] nums =  {1,2,3,4};
        int[] nums = {-1,1,0,-3,3};
        int[] result = solution.productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    @Test
    public void test1(){
        //测试solution1
        Solution1 solution1 = new Solution1();
//        int[] nums =  {1,2,3,4};
        int[] nums = {-1,1,0,-3,3};
        int[] result = solution1.productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
