package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/14
 * Description: 连续子数组的最大和
 *      无论是动态规划还是列表都是在遍历数组的途中分为两种情况
 *          1、若当前字段和>0，那么当前字段和+=当前值
 *          2、若当前字段和<=0，则当前字段和==当前值
 *              既然i-1的子数组和<0，一个小于0的数再加上当前值肯定会把当前值加的更小
 *              因此会以当前值作为新的起始。
 *
 *      一定要分清当前字段和的值and最大字段和的值：是两个东西，不要混淆
 *
 *      比较好的解答：
 *          动态规划的是首先对数组进行遍历，当前连续子序列和为 sum，当前最大子序列和为max
 *              如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 *              如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 *          每次比较 sum 和 max的大小，将最大值置为max，遍历结束返回结果
 *
 */
public class leetcode53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum<=0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }

            if (sum>max){
                max = sum;
            }
        }
        return max;
    }
}
