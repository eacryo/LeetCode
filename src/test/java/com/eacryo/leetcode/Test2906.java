package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2906 {

    /**
     * Solution不用看，直接看下面的Solution1
     * https://leetcode.cn/problems/construct-product-matrix/description/
     * 此题前置为238
     */
    class Solution {
        public int[][] constructProductMatrix(int[][] grid) {
            //乘 multipy 这里如果用int类型的话，某一些测试用例会长度溢出
            long multipy = 1;
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
                    result[i][j] = (int)((multipy/grid[i][j])%12345);
                    //这里第一次修改的时候写成(int)(multipy/grid[i][j])%12345了，导致结果有问题
                    /**
                     * 重要！！我之前的想法是算出一个总的乘积去除以grid[i][j]再取余，这样的做的话总的乘积会超出long的范围
                     * 对于(multipy/grid[i][j])%12345，并不能把取余的操作移动到括号里面变成(multipy%12345)/(grid[i][j]%12345)，这两种情况是不相等的
                     * 这题正确的做法是result[i][j] = (ij左边的乘积*ij右边的乘积)%12345 ，这种情况下取余的操作可以移动到括号里面
                     * 我把第二种方法更新到solution2里面
                     */
                }
            }
            return result;
        }
    }

    /**
     * 类似238的解法，先顺序遍历一次再倒序遍历一次
     * 注意，取余操作是幂等的，因此可以在操作的过程中对grid数组里面的元素直接取余
     */
    class Solution1{
        public int[][] constructProductMatrix(int[][] grid) {
            int multipyLeft = 1; //左边的乘积
            int multipyRight = 1; //右边的乘积
            int outerLength = grid.length;
            int innerLength = grid[0].length;
            int result[][] = new int[outerLength][innerLength];
            //第一遍遍历
            //这里二维数组实在是不好理解，如果实在想不到的话，可以把二维转成一维数组再思考，得出结果后重新转变成二维数组
            for (int i = 0; i < outerLength; i++) {
                for (int j = 0; j < innerLength; j++) {
                    result[i][j] = multipyLeft;
                    multipyLeft = (multipyLeft * (grid[i][j]%12345))%12345;
                }
            }
            //第二遍遍历
            for (int i = outerLength-1; i >=0; i--) {
                for (int j = innerLength-1; j >=0; j--) {
                    result[i][j] = (multipyRight*result[i][j])%12345;
                    multipyRight = (multipyRight* (grid[i][j]%12345))%12345;
                }
            }
            return  result;
        }

    }

    @Test
    public void test(){
        int[][] grid = {{1,2},{3,4}};
//        int[][] grid =  {{12345},{2},{1}};
        //int[][] grid = {{4,3,9},{3,9,10},{9,7,8},{8,4,7},{6,1,3}}; //错误用例1，multipy没用long导致的
//        int[][] grid = {{10,20},{18,16},{17,14},{16,9},{14,6},{16,5},{14,8},{20,13},{16,10},{14,17}}; //实测long也不够，途中出现了溢出
        Solution1 solution = new Solution1();
        int result[][] = solution.constructProductMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
        //System.out.println(Integer.MAX_VALUE); //2147483647
        System.out.println(Long.MAX_VALUE); //9223372036854775807
    }

    @Test
    public void testSoultion1(){
        Solution1 solution1 = new Solution1();
//        int[][] grid = {{1,2},{3,4}};
//        int[][] grid = {{3,2,5},{6,4,3},{6,3,1}};
        int[][] grid = {{414750857},{449145368},{767292749}};
        int result[][] = solution1.constructProductMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
