package issuelist.longest_substring_without_repeating_characters_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author allen
 * @Date 2020/12/21 10:30
 * @ClassName LengthOfLongestSubstring
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = LengthOfLongestSubstring.lengthOfLongestSubstring(s);

        System.out.println(len);
    }

//    public static int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int len = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (set.contains(c)) {
//                if (set.size() > len) {
//                    len = set.size();
//                    set.clear();
//                    set.add(c);
//                }
//                continue;
//            } else {
//                set.add(c);
//            }
//        }
//        return len;
//    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        int len = 0;
        //用来记录上一次重复的位置
        int preIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = preIndex; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - preIndex > len) {
                        len = i - preIndex;
                    }
                    preIndex++;
                    break;
                } else {
                    if (i - j + 1 > len) {
                        len = i - j + 1;
                    }
                }
            }

        }
        return len;
    }

    /**
     * 判断是否重复
     *
     * @param s
     * @param preIndex
     * @param index
     * @return
     */
    public static Boolean checkRepeat(String s, int preIndex, int index) {
        for (int i = preIndex; i < index; i++) {
            if (s.charAt(i) == s.charAt(index)) {
                return true;
            }
        }
        return false;
    }
}
