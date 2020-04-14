package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/15
 * Description: 两两交换链表中的结点-链表反转的变种
 *          25题的简单版本，将k固定设置为2即可
 */
public class leetcode24 {
    public ListNode swapPairs(ListNode head) {
        // 设置假头结点
        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;

        // 设置prev，end
        ListNode prev = prevHead;
        ListNode end = prev;
        while (end.next!=null){
            for (int i = 0; i < 2&&end!=null; i++) {
                end = end.next;
            }
            if (end==null){
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse(start);

            start.next = next;
            prev = start;
            end = prev;
        }
        return prevHead.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode cur = start;
        ListNode pre = null;
        ListNode prePrev = null;
        while (cur!=null){
            pre = cur;
            cur = cur.next;
            pre.next = prePrev;
            prePrev = pre;
        }
        return pre;
    }
}
