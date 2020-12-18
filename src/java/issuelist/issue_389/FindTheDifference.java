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

    public char findTheDifference(String s, String t) {
        //若s为空
        if (s == null || s.equals("")) {
            return t.charAt(0);
        }

        int resultT = 0;
        for (int i = 0; i < t.length(); i++) {
            resultT = resultT + t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            resultT= resultT - s.charAt(i);
        }

        return (char) resultT;
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
