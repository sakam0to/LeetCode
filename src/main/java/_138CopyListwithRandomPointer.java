public class _138CopyListwithRandomPointer {
    public static void main(String[] args){
        _138CopyListwithRandomPointer test = new _138CopyListwithRandomPointer();
        Node node1 = new Node();
        Node node2 = new Node();
        node1.val=1;
        node1.next = node2;
        node1.random = node2;
        node2.val = 2;
        node2.random = node2;
        Node result = test.copyRandomList(node1);
        System.out.println(result.val);
        System.out.println(result.equals(node1));
        System.out.println(result.random.val);
        System.out.println(result.random.equals(node2));
        System.out.println(result.random.equals(result.next));
        result = result.next;
        System.out.println(result.val);
        System.out.println(result.equals(node2));
        System.out.println(result.random.val);
        System.out.println(result.random.equals(node2));
        System.out.println(result.random.equals(result));
        result = result.next;
        System.out.println(result);
    }

    public Node copyRandomList(Node head) {
        /**
         * Old List: A --> B --> C --> D
         * InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'
         */
        Node start = head;
        //First loo[, not set random pointer because some of copied nodes are not created right now.
        while(head != null){
            Node copiedNode = new Node();
            copiedNode.next = head.next;
            copiedNode.val = head.val;
            head.next = copiedNode;
            head = copiedNode.next;
        }
        //Second Loop, add random pointer
        head = start;
        while(head != null){
            Node copiedNode = head.next;
            copiedNode.random = (head.random == null)?null: head.random.next;
            head = copiedNode.next;
        }
        //Third loop, resume original nodes
        if(start != null){
            Node temp = start.next;
            start.next = temp.next;
            start = temp;
            head = start;
            while(head.next != null){
                Node original = head.next;
                Node copiedNode = original.next;
                original.next = copiedNode.next;
                head.next = copiedNode;
                head = copiedNode;
            }
        }
        return start;
    }
}
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};