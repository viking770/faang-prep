public class DoublyLinkedListReverseBetween {

    class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }

    public Node reverseBetween(Node head, int left, int right) {
        if (head == null || left == right) return head;

        // Use a dummy node to seamlessly handle changes at the head
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node before = dummy;

        // 1. Reach the node just before the 'left' position
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        // 2. Identify the sublist boundaries
        Node subLeft = before.next; 
        Node curr = subLeft;
        Node nextNode = null;

        // 3. Swap prev and next for nodes inside the range [left, right]
        for (int i = left; i <= right; i++) {
            nextNode = curr.next;
            
            // Swap pointers to reverse direction
            curr.next = curr.prev;
            curr.prev = nextNode;
            
            curr = nextNode;
        }

        // 'curr' now points to the node right after 'right' position
        Node subRight = (curr == null) ? null : curr.prev; 
        Node after = curr;

        // 4. Reconnect the reversed sublist to the outer boundaries
        before.next = subRight;
        if (subRight != null) subRight.prev = before;

        subLeft.next = after;
        if (after != null) after.prev = subLeft;

        // Clean up dummy reference
        Node newHead = dummy.next;
        if (newHead != null) newHead.prev = null;

        return newHead;
    }
}
