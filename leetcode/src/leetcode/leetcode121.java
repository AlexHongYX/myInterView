package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/13
 * Description: 买卖股票的最佳时机
 *      暴力法：找到每一个下标之后最大值，用这个最大值-当前下标的值，然后比较所有情况中的最大值
 *      一次遍历法：找到当前的最小值(波谷)，对当前元素进行判断，如果当前元素<最小值，那么当前元素作为最小值
 *              直接向后移，若不小于，则用当前元素-最小值与最大值进行相比，实时更新最大值
 */
public class leetcode121 {
    // 暴力法
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i+1;j<prices.length;j++){
//                int diff = prices[j]-prices[i];
//                if (diff>max){
//                    max = diff;
//                }
//            }
//        }
//        return max;
//    }
    public int maxProfit(int[] prices) {
        // 设置当前数组[0,i]中的最小值
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min){
                min = prices[i];
            }else if (prices[i]-min>max){
                max = prices[i]-min;
            }
        }
        return max;
    }
}
