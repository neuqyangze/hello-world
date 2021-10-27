package com.neuqyangze.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s ，请你找出其中不含有重复字符的最长连续子字符串的长度
 * <p/>
 * 使用滑动窗口实现
 */
public class Lols {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcdefga"));
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        // 左、右指针
        int left = 0;
        int right = 0;

        Set<Character> window = new HashSet<>();
        while (right < n) {
            char rightChar = s.charAt(right);
            while (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            // 最大长度对比
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(rightChar);
            right++;
        }

        return maxLen;
    }
}
