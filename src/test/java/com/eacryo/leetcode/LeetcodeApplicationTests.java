package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void contextLoads() {
    }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @return string字符串
         */
        public String maxDictionaryOrder (String s) {
            // write code here

            String result = "";
            while (s.length()>=1){
                char max = s.charAt(0);
                int place = 0;
                for (int i = 1; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if(c>max){
                        max = c;
                        place = i;
                    }
                }
                s = s.substring(place+1,s.length());
                result = result + max;
            }

            return result;
        }
    }


    @Test
    public void test1(){
        //"cmbchina"  —— na 找到n最大，把n右边的拿出来，只剩下a，所以na
        //"aabcbccacbbcbaaba"   "cccccbba" 可以重复   找到c最大，把从左到右第一个c拿出来，剩下bccacbbcbaaba，再把最大的c拿出来，剩下cacbbcbaaba，
        //从左到右，可以拿他本身和比他小的，但不能拿比他大的
        //如果全都是a，比如aaaaaa，则结结果一定是a
        String s = "cmbchina";
        Solution solution = new Solution();
        System.out.println(solution.maxDictionaryOrder(s));


    }



    public class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean magicString (String s) {
            // write code here
            if (s == null){
                return false;
            }
            while ( !s.equals(s.replace("cm",""))){
                s = s.replace("cm","");
            }
            if (s.equals("")){
                return true;
            }
            else {
                return false;
            }
        }
    }


    @Test
    public void test2(){
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.magicString("cm"));
        System.out.println(solution1.magicString("a"));
        System.out.println(solution1.magicString("m"));
        System.out.println(solution1.magicString(null));
    }




}
