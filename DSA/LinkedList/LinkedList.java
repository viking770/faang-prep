public class LinkedList{
    private int size;
    private Node head;
    private Node tail;

    class Node{
       int data;
       Node next;

       public Node(int data){
        this.data = data;
        this.next = null;
       }
    }

    public LinkedList(int data){
        Node node = new Node(data);
        this.head = node;
        this.tail = node;
        size = 1;
    }

    public Node get(int index){
        if(index < 0 || index >= size )
            return null;
        Node temp = head;
        for(int i=0; i<index; i++)
            temp = temp.next;
        return temp;
    }

    public void append(int data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail= newNode;
        }
        size++;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void addAtHead(int data){
        Node newHead = new Node(data);
        if(size==0){
            head = newHead;
            tail = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    public Node removeFirst(){
        if(size==0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        if(size==0){
            tail = null;
        }
        return temp;
    }

    public Node removeLast(){
        if(size == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        size--;
        if(size == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList(10);
        list.append(20);
        list.addAtHead(5);
        list.printList();
        System.out.println(list.get(1).data);
    }
}