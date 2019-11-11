public class _206ReverseLinkedList {
    //iteratively
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        while(head != null){
            ListNode listNode = new ListNode(head.val);
            listNode.next = newHead.next;
            newHead.next = listNode;
            head = head.next;
        }
        return newHead.next;
    }

    //recursively
    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }

        return recur(head, null);
    }

    public ListNode recur(ListNode listNode, ListNode previous){
        ListNode current = new ListNode(listNode.val);
        current.next = previous;
        if(listNode.next == null){
            return current;
        }else{
            return recur(listNode.next, current);
        }
    }
}
