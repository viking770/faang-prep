public class DeleteMiddleOfTheLinkedList{
    private Node head;

    class Node{
       int data;
       Node next;

       public Node(int data){
        this.data = data;
        this.next = null;
       }
    }

    public DeleteMiddleOfTheLinkedList(int data){
        Node node = new Node(data);
        this.head = node;
    }

    public Node removeMiddleNode(){
        if(head==null) return null;
        Node slow = head;
        Node fast = head.next.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
        }
        slow.next = slow.next.next;
        return head;
    }
}