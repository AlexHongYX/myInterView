package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/15
 * Description: x的平方根
 *      二分法查找：start为1，end为x/2+1（不一定能整除），
 *          退出条件就是mid==x/mid（可以整除）或者mid<x/mid&&mid+1>x/(mid+1)（不能整除）
 *
 *          由于循环的条件是start<end，但是end取得是x/2+1，若x==1或0，则此时的mid=(0+1)/2=0
 *              循环中的x/mid就会报错，因此需要将0和1的情况单独讨论
 */
public class leetcode69 {
    public static int mySqrt(int x) {
//        return (int)Math.floor(Math.sqrt(x));
        if (x==0||x==1){
            return x;
        }
        int start = 0;
        // 也有可能会取到end的值
        int end = x/2;
        int mid = 0;
        // 需要设置start<=end，如果start==end了，也是需要进入循环计算mid的
        while (start<=end){
            mid = (start+end)/2;
            if (mid==x/mid||mid<x/mid&&mid+1>x/(mid+1)){
                break;
            }
            // 和二分一样
            if(mid<x/mid){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
}
