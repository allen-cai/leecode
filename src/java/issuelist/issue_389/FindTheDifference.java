package issuelist.issue_389;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author allen
 * @Date 2020/12/18 17:49
 * @ClassName FindTheDifference
 **/
public class FindTheDifference {


    public static void main(String[] args) {
        String s = "aabbcd";
        String t = "aabbcdd";
        FindTheDifference findTheDifference = new FindTheDifference();

        char theDifference = findTheDifference.findTheDifference(s, t);

        System.out.println(theDifference);

    }

    /**
     * 异或解法
     *
     * 关键点：
     *  通过异或算法的特性找到出现奇数次的字符
     * 相关问题：
     *  查找出现奇数次字符
     *
     *
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {

        char result = t.charAt(t.length()-1);

        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        return (char) result;
    }

    /**
     * 字符和与差的解法
     *
     * 关键点：
     *  利用字符的ascll码与字符可以直接转换的特性，求出两个字符串的和，再相减
     *
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference1(String s, String t) {
        //若s为空
        if (s == null || s.equals("")) {
            return t.charAt(0);
        }

        int resultT = 0;
        int resultS = 0;
        for (int i = 0; i < t.length(); i++) {
            resultT = resultT + t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            resultS= resultS + s.charAt(i);
        }

        return (char) (resultT - resultS);
    }

//    public char findTheDifference(String s, String t) {
//        //若s为空
//        if (s == null || s.equals("")) {
//            return t.charAt(0);
//        }
//
//        //若不为空
//        Map<Character, Integer> charCount = this.getCharCount(t);
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            Integer integer = charCount.get(c);
//            if (integer > 1) {
//                charCount.put(c, integer--);
//            } else {
//                charCount.remove(c);
//            }
//        }
//        Set<Character> characters = charCount.keySet();
//
//        for (Character c : characters) {
//            return c;
//        }
//        return 'a';
//    }

    private Map<Character, Integer> getCharCount(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!result.containsKey(s.charAt(i))) {
                result.put(s.charAt(i), 1);
            } else {
                Integer integer = result.get(s.charAt(i));
                result.put(s.charAt(i), integer++);
            }
        }
        return result;
    }
}
