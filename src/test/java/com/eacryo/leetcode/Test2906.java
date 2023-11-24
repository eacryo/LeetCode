package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2906 {

    /**
     * https://leetcode.cn/problems/construct-product-matrix/description/
     */
    class Solution {
        public int[][] constructProductMatrix(int[][] grid) {
            //乘 multipy
            int multipy = 1;
            int outerLength = grid.length;
            int innerLength = grid[0].length;
            int result[][] = new int[outerLength][innerLength];
            for (int i = 0; i < outerLength; i++) {
                //innerLength是内层数组的长度
                for (int j = 0; j < innerLength; j++) {
                    multipy = multipy*grid[i][j];
                }
            }
            for (int i = 0; i < outerLength; i++) {
                for (int j = 0; j < innerLength; j++) {
                    result[i][j] = (multipy/grid[i][j])%12345;
                }
            }
            return result;
        }
    }

    @Test
    public void test(){
        int[][] grid = {{1,2},{3,4}};
        Solution solution = new Solution();
        int result[][] = solution.constructProductMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
