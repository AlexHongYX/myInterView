package array;

import java.util.Scanner;

/**
 * Created by xiaoaxiao on 2019/11/27
 * Description: n个人，报到m出去，最后剩下的那个人的编号
 */
public class JosephRing {

    public static int getResult(int n, int m) {
        // 设置一个数组表示这些人是否存活
        // 先假设这n个人都活着(false)
        boolean[] people = new boolean[n];
        // 设置当前的编号(1-m)
        int sum = 0;
        // 已经被淘汰了多少人
        // 通过这个已被淘汰的人和总人数的比值，进行循环的退出
        // 不要也可以，写成死循环即可
        int pass = 0;
        // 淘汰的人比总人数少，循环才能继续执行下去
        // 定义一个i表示当前数组的下标
        int i = 0;
        while (pass < n) {
            if (i == n) {  // 需要对该数组进行循环遍历，因此当i==n时，将i设置为0
                i = 0;
            }
            if (!people[i]) { // 若当前位置上的人还没有被淘汰
                sum++;
                // 若此时sum==m，说明当前这个位置上报的数就是m
                // 先++再比较，因为sum是从0开始计数的
                if (sum == m) {
                    // 淘汰的人+1
                    pass++;
                    // 该位置被设置为true，意味着该位置已被淘汰
                    people[i] = true;
                    // 将sum重新设置为0，进行下一轮的约瑟夫过程
                    sum = 0;
                }
                // 无论当前位置上的人是否被淘汰，i都需要向后走一步
                // 比较巧妙：如果是最后一次pass==n时，此时的i再+1，刚好对应了实际的编号(从1开始)
                i++;
            } else { // 若当前位置上的人已经被淘汰了，直接i++往后走就行
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(getResult(n,m));
    }
}
