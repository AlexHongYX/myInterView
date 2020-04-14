package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/14
 * Description: 旋转数组的最小值Ⅱ——剑指Offer的进阶
 *      其他思路与153一模一样，只不过可以出现重复的数字
 *      由剑指Offer上那本书得到：若存在重复的数字
 *          若出现首值==中值==尾值，这种情况下根本无法判断中间数字到底是在前面数组还是后面数组。
 *          因此如果是这种情况，只能采用顺序查找的方式了(案例：{1,0,1,1,1}和{1,1,1,0,1})
 *
 *      注意：在进行比较时，可能会出现==的情况，即便是==也是需要移动start/end的
 */
public class leetcode154 {
    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        int mid = start;
        while (nums[start] >= nums[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }

            mid = (end + start) / 2;

            if (nums[start] == nums[mid] && nums[start] == nums[end]) {
                return orderFind(nums, start, end);
            }

            // 此时存在==的情况
            if (nums[mid] >= nums[start]) {
                start = mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }
        return nums[mid];
    }

    /**
     * 顺序寻找最小值
     */
    private static int orderFind(int[] nums, int start, int end) {
        int ret = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i]<ret){
                ret = nums[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] arr = {3,1,3};
//        System.out.println(findMin(arr));

    }

}
