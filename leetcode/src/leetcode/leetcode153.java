package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/14
 * Description: 旋转数组的最小值-剑指Offer上也有
 *      使用二分查找的思路，由于是旋转数组，将数组分成前半部分排序数组+后半部分排序数组
 *      最小值就是第二个排序数组的第一个元素
 *         若中间值>首值：当前还处于第一个排序数组中，最小值还在后面，将首指针设置为当前中间指针
 *         若中间值<尾值：当前还处于第二个排序树组中，最小值可能在前面，将尾指针设置为当前中间指针
 *      循环退出条件：
 *          首尾两个指针相差1，此时就返回尾指针的元素即可
 *
 *      有一个特殊情况，就是不旋转(从0下标旋转)
 */
public class leetcode153 {
    public static int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int start = 0;
        int end = nums.length-1;

        // 有可能不进行旋转(在0处旋转)，因此需要将mid设置为start,并搭配while(nums[start]>nums[end])使用
        // 如果是已经排好序的数组，连循环都进不去，直接返回nums[mid]也就是此时的最小值(数组的第一个元素)
        int mid = start;
        // 由于上面特殊情况的存在，因此这样设置while条件就是为了应对不旋转的情况
        // 只有此时nums[start]是大于nums[end]时，才说明确实进行了旋转
        while (nums[start]>nums[end]){
            if (end-start==1){  //如果首尾指针差1说明当前的尾指针就是最小值的位置
                // 为了搭配上面mid使用，此处将mid设置为end，以便最终统一返回nums[mid]
                mid = end;
                break;
            }

            mid = (end+start)/2;

            if (nums[mid]>nums[start]){ //说明此时最小值在后面
                start = mid;
            }else if (nums[mid]<nums[end]){ //此时最小值可能在前面
                end = mid;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
}
