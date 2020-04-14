package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/31
 * Description: 接雨水
 * 按列求：找到当前列左右的最高列中较矮的那一列，若当前列<较矮的那一列，则当前列可存水量为(较矮-当前)
 */
public class leetcode42 {
    /**
     * 直接按列求法
     */
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 左边最高的墙
            int left = 0;
            // 右边最高的墙
            int right = 0;
            // 遍历找到左边最高墙
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) {
                    left = height[j];
                }
            }
            // 遍历找到右边最高墙
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }

            // 比较左右墙的低者
            int min = Math.min(left, right);
            // 只有低者比当前墙高时，当前墙才会存储水(低者-当前墙)
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 动态规划法——将i位置的左边最大值与右边最大值(不包含i位置)用数组记录下来
     *      i位置的左边最大值=i-1位置的值与i-1左边最大值的最大值——从左向右遍历
     *      i位置的右边最大值=i+1位置的值与i+1右边最大值的最大值——从右向左遍历
     *     依旧采用的是按列遍历的方式，只不过在循环中不比较不需要每次都要判断左右最大值了
     *     而是直接访问最大值数组即可
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int sum = 0;
        // 声明当前位置i的左边最大值与右边最大值数组
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        // 遍历整个数组设置当前位置的左边最大值
        // i的左边最大值=i-1的值与i-1的左边最大值的最大值
        // 从前往后走
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }
        // i的右边最大值=i+1的值与i+1的右边最大值的最大值
        // 从后往前走
        for (int i = height.length-2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }
        // 依旧采用的是按列求法，直接使用左右最大值数组
        for (int i = 1; i < height.length-1; i++) {
            int min = Math.min(max_left[i],max_right[i]);
            if (min > height[i]){
                sum += min-height[i];
            }
        }
        return sum;
    }

    /**
     * 动态规划法的优化
     *      如果当前节点的左边最大节点<=右边最大节点，那么当前节点能否存水就取决于当前节点与右边最大节点的大小比较
     *          如果当前结点比右边最大结点小，则当前节点可以存水(rightMax-now)
     *      如果当前节点的左边最大节点>右边最大节点，那么当前节点能否存水就取决于当前节点与左边最大节点的大小比较
     *          如果当前结点比左边最大结点小，则当前节点可以存水(leftMax-now)
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int sum = 0;
        // 当前节点的左节点最大值和右节点最大值
        int leftMax = 0;
        int rightMax = 0;
        // 双指针
        int left = 0;
        int right = height.length-1;
        // 由于要取到该数组[0,height-1]的所有结点，因此需要left==right
        while (left<=right){
            // 如果左节点最大值<右节点最大值
            // 能否存水取决于当前值与左最大值
            if (leftMax<rightMax){
                // 当前节点比左最大值大，说明当前不能存水，更新左最大节点为当前节点
                if (height[left]>leftMax){
                    leftMax = height[left];
                }else {
                    // 若小，说明可以存水，存水量就是两者差值
                    sum += leftMax-height[left];
                }
                // 当前节点判断完，无论能否存水，向后继续遍历
                left++;
            }else {
                // 同上
                if (height[right]>rightMax){
                    rightMax = height[right];
                }else {
                    sum += rightMax-height[right];
                }
                right--;
            }
        }
        return sum;
    }


        public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(arr));
    }
}
