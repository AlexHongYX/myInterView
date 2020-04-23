package leetcode;

import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoaxiao on 2020/4/22
 * Description: 两数之和
 */
public class leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        int num = 0;

        ListNode head = null;
        ListNode cur = null;


        while (cur1 != null && cur2 != null) {
            int val = cur1.val + cur2.val + num;

            num = val / 10;
            ListNode node = new ListNode(val%10);
            if (head == null){
                cur = node;
                head = node;
            }else {
                cur.next = node;
            }
            cur = node;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            int val = cur1.val + num;
            num = val/10;
            ListNode node = new ListNode(val%10);
            if (head == null){
                cur = node;
                head = node;
            }else {
                cur.next = node;
            }
            cur = node;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            int val = cur2.val + num;
            num = val/10;
            ListNode node = new ListNode(val%10);
            if (head == null){
                cur = node;
                head = node;
            }else {
                cur.next = node;
            }
            cur = node;
            cur2 = cur2.next;
        }

        if (num != 0){
            ListNode node = new ListNode(num);

                cur.next = node;

            cur = node;
        }

        return head;
    }
}


