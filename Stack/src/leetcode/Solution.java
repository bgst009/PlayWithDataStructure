package leetcode;

import java.util.Stack;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Solution.java
 * @createTime 2020年05月24日 10:43:00
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '(') {
                    return false;
                }
                if(c == ']' && topChar != '[') {
                    return false;
                }
                if(c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
