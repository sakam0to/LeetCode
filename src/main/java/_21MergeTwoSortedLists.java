public class _21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode previous = result;
        while(l1 != null && l2 !=null){
            ListNode newNode;

            if(l1.val < l2.val){
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }

            previous.next = newNode;
            previous = previous.next;
        }

        if(l1 != null){
            previous.next = l1;
        }
        if(l2 != null){
            previous.next = l2;
        }
        return result.next;
    }


}
