package issuelist.longest_substring_without_repeating_characters_3;

import java.util.*;

/**
 * @Description
 * @Author allen
 * @Date 2020/12/21 10:30
 * @ClassName LengthOfLongestSubstring
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        int len = LengthOfLongestSubstring.lengthOfLongestSubstring5(s);

        int i = 0;


        System.out.println(len);
    }

    /**
     *  判断字符是否重复出现，花费太多时间与空间
     *  若要优化，可从判断重复入手
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }

        int len = 0;
        Map<Character, Integer> characterSet = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (len >= (s.length() - i)) {
                return len;
            }
            int j = i;
            while (j < s.length() && characterSet.get(s.charAt(j)) == null) {
                characterSet.put(s.charAt(j), 1);
                j++;
            }
            if (len < (j - i)) {
                len = j - i;
            }
            characterSet.clear();
        }
        return len;
    }


    /**
     * 通过空间 交换时间
     * - 循环遍历一次字符串可得到结果
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int max = 0;
        //用来记录当前未重复字符串
        String current = "";
        int n = s.length();
        int i = 0;
        //将字符串转换成字符数组
        char[] chars = s.toCharArray();
        //遍历字符串
        while (n-- != 0) {
            //获取当前字符
            char val = chars[i];
            //获取当前字符在不重复字符串的位置
            int index = current.indexOf(val);
            if (index > -1) {
                max = Math.max(max, current.length());
                current = current.substring(index + 1);
            }
            current += val;
            i++;

        }
        return Math.max(max, current.length());

    }


    /**
     * 官方答案
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring5(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
