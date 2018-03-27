/**
 * Created by jkzhao on 3/27/18.
 */
public class LongestSubstringWithoutRepeatingCharacters {
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
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int count = 0;

        for (int k=0; k<s.length(); k++) {
            //System.out.println("现在从" + k + "开始：");
            int temp = 0;
            for(int i=k+1; i<s.length(); i++) {
                int flag = 0;//0为不重复，1为有重复，结束循环
                for (int j=i-1; j>=k; j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        continue;
                    }else {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    if (i+1 == s.length()) {
                        temp = i - k + 1;
                        count += 1;
                    }
                    continue;
                }
                else {
                    //System.out.println("此时i=" + i + "; k=" + k);
                    temp = i - k;
                    count += 1;
                    break;
                }
            }
            if (count == 0) {
                return s.length();
            }
            if (temp > result) {
                result = temp;
            }
            //System.out.println("==============");
        }

        return result;
    }

    public static void main(String[] args) {
        //String s = "pwwkew";
        //String s = "c";
        //String s = "aue";
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
