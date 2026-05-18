public class DoublyLinkedListPartitionList {

    class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }

    public Node partition(Node head, int x) {
        if (head == null) return null;

        // Dummy heads for the two partitions
        Node smallerHead = new Node(0);
        Node greaterHead = new Node(0);
        
        Node smaller = smallerHead;
        Node greater = greaterHead;
        Node curr = head;

        while (curr != null) {
            // Unlink current node to prevent cycles and maintain DLL structure
            Node nextNode = curr.next;
            curr.next = null;
            curr.prev = null;

            if (curr.val < x) {
                smaller.next = curr;
                curr.prev = (smaller == smallerHead) ? null : smaller;
                smaller = curr;
            } else {
                greater.next = curr;
                curr.prev = (greater == greaterHead) ? null : greater;
                greater = curr;
            }
            curr = nextNode;
        }

        // Connect the two partitions
        smaller.next = greaterHead.next;
        if (greaterHead.next != null) {
            greaterHead.next.prev = (smaller == smallerHead) ? null : smaller;
        }

        // Final result head
        Node resultHead = smallerHead.next;
        if (resultHead != null) resultHead.prev = null;
        
        return resultHead;
    }

    public static void main(String[] args){

    }
}