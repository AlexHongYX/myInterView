package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/16
 * Description: 链表入环口
 *          head到入环口距离为s
 *          环长度为x
 *          从入环口到交点为a
 *          剩余环b=x-a
 *          快指针是慢指针的二倍
 *              slow         fast
 *              2(s+a)  =  s+nx+a
 *          化简后： s = b+(n-1)x
 *          说明从s和b每次各走一步，最终交点就是入环口
 */
public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null){
            fast = fast.next;
            if (fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (slow==fast){
                break;
            }
        }
        if (fast==null){
            return null;
        }

        ListNode node = fast;

        while (node!=head){
            node = node.next;
            head = head.next;
        }
        return node;
    }
}
