package strive.insist.xiaoaxiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoaxiao on 2019/12/18
 * Description: 无重复字符的最长子串
 *          暴力法：O(n³)，复杂度难以接受
 *          滑动窗口：O(n)
 *                定义一个窗口，记录当前无重复元素的子串及其最长长度，
 *                定义该窗口的首元素以及当前元素
 *                  1.如果当前字符不在该窗口内，则将当前字符也加入到当前窗口中并更新最长长度
 *                  2.如果当前字符在该窗口内，说明当前窗口以当前的首元素向后遍历已经找到重复的元素了，不符合窗口设定
 *                      因此需要将窗口的首元素向后移动一格，继续寻找以当前元素为首地址的最长不重复子串
 *                  3.当当前字符遍历到最后一个元素位置，返回即可
 *                  4.由于直接判断当前元素是否在窗口内有一些困难，因此采用HashSet(O(1)复杂度判断)
 */
public class leetcode3 {
    /**
     * 对每一个i都做一遍查找，时间复杂度O(n³)
     * 思路简单但时间复杂度太高
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for(int i = 0; i<length ;i++){
            Set<Character> set = new HashSet<>();
            set.add(chars[i]);
            for (int j = i+1;j<length;j++){
                if (!set.contains(chars[j])){
                    set.add(chars[j]);
                }else {
                    break;
                }
            }
            int count = set.size();
            if (count > max){
                max = count;
            }
        }
        return max;
    }

    /**
     * 使用滑动窗口的概念
     */
    public int lengthOfLongestSubstring1(String s){
        Set<Character> set = new HashSet<>();
        int head = 0;
        int tail = 0;
        int maxLength = 0;
        while (tail<s.length()){
            if (!set.contains(s.charAt(tail))){
                set.add(s.charAt(tail));
                tail++;
                maxLength = Math.max(maxLength,set.size());
            }else {
                set.remove(s.charAt(head));
                head++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
