public class MiddleOfTheLinkedList{
    private Node head;

    class Node{
       int data;
       Node next;

       public Node(int data){
        this.data = data;
        this.next = null;
       }
    }

    public MiddleOfTheLinkedList(int data){
        Node node = new Node(data);
        this.head = node;
    }

    public Node findMiddleNode(){
        if(head==null) return null;
        Node slow = head;
        Node fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}