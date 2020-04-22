package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoaxiao on 2020/4/22
 * Description: 经典杨辉三角问题
 */
public class leetcode118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i-1){
                    list.add(1);
                }else {
                    list.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
