package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/16
 * Description: 链表是否成环
 */
public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
