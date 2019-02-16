/**
 * @author zhujingjie
 * @project LeetCode
 * @description 2
 * @date 2019-02-14 14:37
 */
public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 解决思路是加法器，用一个变量表示进位
         */
        int addon = 0;
        /**
         * 虚拟头节点，返回时要移除
         */
        ListNode sums = new ListNode(0);
        ListNode result = sums;

        /**
         * 遍历两个链表
         */
        while(l1 != null && l2 != null){
            sums.next = new ListNode((l1.val + l2.val + addon)%10);
            addon = (l1.val + l2.val + addon) / 10;
            l1 = l1.next;
            l2 = l2.next;
            sums = sums.next;
        }
        /**
         * 遍历剩余链表
         */
        while(l1 != null){
            if(addon == 0){
                sums.next = l1;
                break;
            }
            sums.next = new ListNode((l1.val + addon)%10);
            addon = (l1.val + addon) / 10;
            l1 = l1.next;
            sums = sums.next;
        }
        while(l2 != null){
            if(addon == 0){
                sums.next = l2;
                break;
            }
            sums.next = new ListNode((l2.val + addon)%10);
            addon = (l2.val + addon) / 10;
            l2 = l2.next;
            sums = sums.next;
        }
        /**
         * 如果两个链表遍历完后仍有进位，则新增一个节点存放进位
         */
        if(addon > 0){
            sums.next = new ListNode(addon);
        }
        return result.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}