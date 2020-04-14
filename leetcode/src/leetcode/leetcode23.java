package strive.insist.xiaoaxiao.leetcode;

/**
 * Created by xiaoaxiao on 2019/12/13
 * Description: 合并K个排序链表
 *      暴力法：将K个链表全部放入一个数组，再将该数组排序，最终将该数组转换为链表
 *      暴力法没有用到这K个链表是排序这一属性
 *      分治法：将K个链表两两合并为K/2个链表，再继续合并，直到K==1为止
 *      分治法选择list[i]与list[length-i-1]这两个链表
 */
public class leetcode23 {
    // 暴力法解题
//    public static ListNode mergeKLists(ListNode[] lists) {
//        int length = 0;
//        for (ListNode list : lists){
//            ListNode cur = list;
//            while (cur!=null){
//                length++;
//                cur = cur.next;
//            }
//        }
//        int[] arr = new int[length];
//        int i = 0;
//        for (ListNode list : lists){
//            ListNode cur = list;
//            while (cur!=null){
//                arr[i++] = cur.val;
//                cur = cur.next;
//            }
//        }
//        Arrays.sort(arr);
//        ListNode head = null;
//        ListNode tail = null;
//        for (int a : arr){
//            ListNode node = new ListNode(a);
//            if (head==null){
//                head = node;
//            }else {
//                tail.next = node;
//            }
//            tail = node;
//        }
//        return head;
//    }
    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        // 需要注意空数组的情况
        if (length == 0) {
            return null;
        }
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[length - i - 1]);
            }
            if (length % 2 == 0) {
                length /= 2;
            } else {
                length = length / 2 + 1;
            }
        }
        return lists[0];
    }

    /**
     * 合并两个有序链表
     * 最大的改进：设置一个真正的头结点，不需要尾结点了，直接将其他节点加在该头结点后即可
     * 最后返回头结点的下一个结点，也就是实际上的第一个结点
     */
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);

        ListNode head = mergeKLists(listNodes);

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
