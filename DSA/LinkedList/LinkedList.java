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

    public boolean set(int index, int data){
        Node temp = get(index);
        if(temp!=null){
            temp.data = data;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int data){
        if(index <0 || index >= size)
            return false;
        if(index == 1){
            return addAtHead(data);
        }
        if(index == size)
            return append(data);
        Node newNode = new Node(data);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }

    public boolean append(int data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail= newNode;
        }
        size++;
        return true;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean addAtHead(int data){
        Node newHead = new Node(data);
        if(size==0){
            head = newHead;
            tail = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
        return true;
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

    public Node remove(int index){
        if(index<0 || index >= size)
            return null;
        if(index == size-1)
            return removeLast();
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        size--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < size; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList(10);
        list.append(20);
        list.addAtHead(5);
        list.printList();
        System.out.println(list.get(1).data);
        list.set(0, 2);
        list.insert(2, 15);
        list.printList();
    }
}