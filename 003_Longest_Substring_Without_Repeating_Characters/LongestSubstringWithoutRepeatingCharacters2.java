import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jkzhao on 3/27/18.
 */
public class LongestSubstringWithoutRepeatingCharacters2 {
    /**
     * 3. Longest Substring Without Repeating Characters
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

     time complexity: O(n)
     space complexity: O(n)

     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {//hashmap做法
        if (s == null || s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res=0;
        for (int i=0, j=0; i<s.length(); i++){ //i代表遍历这个字符串，j代表不重复的起点
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
                //System.out.println("此时j=" + j);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-j+1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {//hashset做法
        if (s == null || s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res=0;
        for (int i=0, j=0; i<s.length(); i++){ //i代表遍历这个字符串，j代表不重复的起点
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
                i--;
            } else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size()); //集合的大小即为不重复的子串的长度
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //String s = "pwwkew";
        //String s = "c";
        String s = "aue";
        //String s = "abcabcbbcdef";
        System.out.println(lengthOfLongestSubstring2(s));
    }

}
