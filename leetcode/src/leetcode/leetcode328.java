package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/16
 * Description: 奇偶链表
 *      双指针法
 */
public class leetcode328 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode firstHead = head;
        ListNode firstTail = firstHead;
        if(head.next==null){
            return head;
        }
        ListNode secondHead = head.next;
        ListNode secondTail = secondHead;

        ListNode cur = secondTail.next;
        boolean flag = true;
        while (cur!=null){
            if (flag){
                firstTail.next = cur;
                firstTail = firstTail.next;
                flag = false;
            }else {
                secondTail.next = cur;
                secondTail = secondTail.next;
                flag = true;
            }
            cur = cur.next;
        }
        secondTail.next = null;
        firstTail.next = secondHead;
        return firstHead;
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

        ListNode ret = oddEvenList(node1);

        ListNode cur = ret;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}
