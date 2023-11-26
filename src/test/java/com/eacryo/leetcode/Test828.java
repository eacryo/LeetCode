package com.eacryo.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class Test828 {
    /**
     * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
     * 828. 统计子串中的唯一字符
     * 以leetcode为例，先只考虑某个字符，比如说c，c把字符串分割成如下几段
     * leet   c    ode，那么考虑包含c且c不重复的子串有这么几种情况：
     * c的左边有0个、1个、2个、3个、4个字符串，c的右边有0到3个字符串
     * 数量为5*4-1
     * 以aaabaaabaaa为例，b把字符串分割成aaa   b   aaa    b    aaa，除b之外有三段
     * 由于只能相邻两段组合在一起（这是肯定的，子串的元素都是挨着的，不能飞过去组成子串）
     * 那么就有3*3+3*3+
     */
    @Test
    public void solution(){
        String s = "LEETCODE";
        System.out.println(uniqueLetterString(s));
    }

    public int uniqueLetterString(String s){
        return 0;
    }


    class Solution828 {
        /**
         * 解法1，尝试直接计算，存在超时问题
         * @param s
         * @return
         */
        public int uniqueLetterString(String s) {
            int count = 0;
            //注意这里外层的两个循环是小于等于s.length()，因为substring这个函数是含左不含右的
            for (int i = 0; i <= s.length(); i++) {
                for (int j = i+1; j <= s.length(); j++) {
                    String sub = s.substring(i,j);
                    Set<Character> setAll = new HashSet<>();
                    Set<Character> setRepeat = new HashSet<>();
                    for (int k = 0; k < sub.length(); k++) {
                        char c = sub.charAt(k);
                        if(setAll.contains(c)){
                            setRepeat.add(c);
                        }
                        else {
                            setAll.add(c);
                        }
                    }
                    count = count + setAll.size() - setRepeat.size();
                }
            }
            return count;
        }
    }

    @Test
    public void test(){
        Solution828 solution828 = new Solution828();
        //下面这个用例超时
        System.out.println(solution828.uniqueLetterString("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU"));
    }

}
