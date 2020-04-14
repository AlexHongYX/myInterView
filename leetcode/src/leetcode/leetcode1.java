package strive.insist.xiaoaxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoaxiao on 2020/4/14
 * Description: 两数之和
 *      字节实习一面考题->需要优化到O(n),n²做法猪都会
 * 思路: 将遍历过的元素保存在Map中，查找当前下标对应的值是否在Map中存在，若存在则输出，否则向后走
 *  ->使用containsKey()可以实现O(1)复杂度，总体上复杂度就是O(n)->空间换时间
 * 感想: 难以想通的是这么简单一道题为什么当时没想出来
 */
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int matchNum = 0;
        for (int i = 0; i < nums.length; i++) {
            matchNum = target-nums[i];
            if (map.containsKey(matchNum)){
                int[] result = new int[2];
                result[0] = map.get(matchNum);
                result[1] = i;
                return result;
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
