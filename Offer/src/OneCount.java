import java.util.Queue;

/**
 * Created by xiaoaxiao on 2020/5/5
 * Description: 二进制中1的个数
 */
public class OneCount {
    public static int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (char c : str.toCharArray()){
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(15));
        System.out.println(NumberOf1(-15));
    }
}
