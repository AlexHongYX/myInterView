package strive.insist.xiaoaxiao.leetcode;

import java.util.Stack;

/**
 * Created by xiaoaxiao on 2020/1/1
 * Description: 二进制求和
 */
public class leetcode67 {
    /**
     * 不需要在意两个字符串的长度
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        String one = reverse(a);
        String two = reverse(b);

        char[] aChars = one.toCharArray();
        char[] bChars = two.toCharArray();
        int i =0,j=0;
        int jin = 0;
        StringBuilder sb = new StringBuilder();
        while (i<aChars.length&&j<bChars.length){
            int val = (aChars[i]-48)+(bChars[i]-48)+jin;
            if (val<2){
                sb.append(val);
                jin = 0;
            }else {
                sb.append(val%2);
                jin = val/2;
            }
            i++;
            j++;
        }
        while (i<aChars.length){
            int val = (aChars[i]-48)+jin;
            if (val<2){
                sb.append(val);
                jin = 0;
            }else {
                sb.append(val%2);
                jin = val/2;
            }
            i++;
        }
        while (j<bChars.length){
            int val = (bChars[j]-48)+jin;
            if (val<2){
                sb.append(val);
                jin = 0;
            }else {
                sb.append(val%2);
                jin = val/2;
            }
            j++;
        }
        if (jin==1){
            sb.append(jin);
        }
        return reverse(sb.toString());
    }

    private static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            stack.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 直接遍历求解，若当前i已经不存在则不需要相加，若j已经不存在则不需要相加
     *      循环中多套一层判断
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // 设置进位的值
        int jin = 0;
        for (int i = a.length()-1,j = b.length()-1;i>=0||j>=0;i--,j--){
            int sum = jin;
            if (i>=0){
                sum += a.charAt(i)-'0';
            }
            if (j>=0){
                sum += b.charAt(j)-'0';
            }
            sb.append(sum%2);
            jin = sum/2;
        }
        if (jin==1){
            sb.append(jin);
        }
        return sb.reverse().toString();
    }


        public static void main(String[] args) {
        System.out.println(addBinary1("100","110010"));
    }
}
