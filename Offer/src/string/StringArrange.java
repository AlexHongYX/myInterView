package string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by xiaoaxiao on 2020/5/6
 * Description: 字符串全排列
 */
public class StringArrange {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        if (str.length() >= 1){
            PermutationHelper(str.toCharArray(),0,list);
        }

        Collections.sort(list);

        return list;
    }

    private void PermutationHelper(char[] chars,int beginIndex,ArrayList<String> list){
        if (beginIndex == chars.length-1){
            list.add(String.valueOf(chars));
        }else {
            for (int i = beginIndex; i < chars.length; i++) {
                if (i == beginIndex || chars[i]!=chars[beginIndex]){
                    char[] newChars = swap(chars,i,beginIndex);

                    PermutationHelper(newChars,beginIndex+1,list);
                }
            }
        }
    }

    private char[] swap(char[] chars, int i, int beginIndex) {
        char tmp = chars[i];
        chars[i] = chars[beginIndex];
        chars[beginIndex] = tmp;
        return chars;
    }

    public static void main(String[] args) {
        StringArrange stringArrange = new StringArrange();
        ArrayList<String> ret = stringArrange.Permutation("abc");
        for (String str : ret){
            System.out.println(str);
        }
    }
}
