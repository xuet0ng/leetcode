package leetcode.a;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class A003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            return window(s);
        }

        private int window(String s) {
            int max = 0;
            Map<Integer, Character> index2CharSubStrMap = new HashMap<>();
            for (int i = 0, j = 0; j < s.length() && i < s.length(); ) {
                if (!index2CharSubStrMap.containsValue(s.charAt(j))) {
                    index2CharSubStrMap.put(j, s.charAt(j));
                    j++;
                } else {
                    index2CharSubStrMap.remove(i);
                    i++;
                }
                max = max > index2CharSubStrMap.size() ? max : index2CharSubStrMap.size();
            }
            return max;
        }
    }
}