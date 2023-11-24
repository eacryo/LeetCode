package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Test2824 {

    /**
     * 题目：https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/
     */

    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            int count = 0;
            if(nums.size()==1){
                //只有一个元素时肯定没有符合要求的ij值
                return count;
            }
            for (int i = 0; i < nums.size(); i++) {
                int currentNumsI = nums.get(i);
                for (int j = i+1; j < nums.size(); j++) {
                    int currentNumsJ = nums.get(j);
                    if(currentNumsI+currentNumsJ<target){
                        count++;
                    }
                }
            }
            return count;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(-1,1,2,3,1);
        //java数组在等号右边用的是花括号
        //Integer[] a = {-1,1,2,3,1};
       list.addAll(list1);
//       list.forEach(e-> System.out.println(e));
        System.out.println(solution.countPairs(list1,2));
        System.out.println(solution.countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3),-2));

    }
}
