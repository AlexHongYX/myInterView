package strive.insist.xiaoaxiao.leetcode;

import java.lang.reflect.Field;
import java.util.Stack;

/**
 * Created by xiaoaxiao on 2019/12/15
 * Description: 回文数-栈
 */
public class leetcode9 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            stack.push(c);
        }
        for (char c:str.toCharArray()){
            if (c!=stack.pop()){
                return false;
            }
        }
        return true;
    }
}
