package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/15
 * Description: K个一组翻转链表，最后剩余的保持不变
 *      这个题必须得画图才能解决的一目了然
 *      大概思路：将整个链表截取成每段长为k的小链表，对这些小链表进行链表的反转
 *              比较难的就是设置一个假的头结点，prev，start，end，next设置的位置
 *              整个链表分为：已反转部分+正在翻转部分+还未反转部分
 *
 *      注意：假头结点的作用，四个结点的链接问题
 */
public class leetcode25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 创建一个假的头结点，保证之后操作的统一性
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode pre = preHead;
        ListNode end = pre;
        // 因为end是指当前长度为k的子链表处，有可能当前end刚好是最后一个子链表的最后一个结点
        // 因此while的条件需要设置为end.next!=null
        while (end.next!=null){
            // 由于end是从pre开始读取的，因此走k步后end处于当前长度k的最后一个结点处
            for (int i = 0;i<k&&end!=null;i++){
                end = end.next;
            }
            // 如果end==null了，也就对应的是最后一个子链表可能长度不够k，那么直接退出循环，下面的就不需要做了
            if (end==null) {
                break;
            }
            // 设置当前子链表的起始点为pre，start的位置就是当前子链表的第一个结点
            // 对于第一个子链表来讲由于设置了假的头结点，保证start取得也是第一个子节点
            ListNode start = pre.next;
            // 此时的next取end.next，也就是下一个子链表的起始位置
            ListNode next = end.next;
            // 将end.next设置为null，在下面的函数中，只需要以null作为临界条件即可
            end.next = null;
            // 将pre.next设置为该函数的返回值，也就是当前子链表被反转后的头结点
            // 由于pre指的是当前子链表前面的结点，因此将prev.next为反转后的头结点
            pre.next = reverse(start);
            // 再将该子链表反转后的最后结点(反转前的最先结点start)的next指向下一个子链表的头
            // 完成当前子链表的反转调整
            start.next = next;
            // 将pre设置为反转后子链表的最后结点(也就是反转前的最先结点start)
            // 此时pre就意味着是下一个子链表的前驱节点
            pre = start;
            // 将end也设置为pre，当前子链表反转后的最后一个节点，
            // 这样的话end向后移动k步就刚好到达下一个子链表的最后一个节点
            end = pre;
        }
        return preHead.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode prePre = null;
        while (cur!=null){
            pre = cur;
            cur = cur.next;
            pre.next = prePre;
            prePre = pre;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;



        ListNode cur = reverseKGroup(node1,3);
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
