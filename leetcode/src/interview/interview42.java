package strive.insist.xiaoaxiao.interview;

/**
 * Created by xiaoaxiao on 2020/4/14
 * Description: 连续子数组的最大和
 *     字节实习二面考题->要求时间复杂度为O(n)
 *     思路:动态规划中比较典型的一道题
 *
 */
public class interview42 {

    /**
     * 这种思路应该属于贪心->使用了一个变量对当前值进行了保存，未对数组进行直接的修改
     */
//    public int maxSubArray(int[] nums) {
//        int maxSub = Integer.MIN_VALUE;
//        int curSub = 0;
//        for (int i = 0; i < nums.length; i++) {
//            curSub += nums[i];
//            if (curSub > maxSub){
//                maxSub = curSub;
//            }
//            if (curSub < 0){
//                curSub = 0;
//            }
//        }
//        return maxSub;
//    }

    /**
     * 使用动态规划->相当于是直接对当前数组进行了修改
     */
    public int maxSubArray(int[] nums){
        int maxSub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
            if (nums[i]>maxSub){
                maxSub = nums[i];
            }
        }
        return maxSub;
    }
}
