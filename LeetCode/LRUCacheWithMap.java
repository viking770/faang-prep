public class LRUCacheWithMap {

    Node[] map;
    Node head, tail;
    int capacity;
    int count;

    public LRUCacheWithMap(int capacity) {
        this.capacity = capacity;
        count = 0;

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        map = new Node[100001];
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(map[key] != null){
            Node node = map[key];
            int nodeVal = node.value;

            deleteNode(node);
            addToHead(node);

            return nodeVal;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map[key] != null){
            Node node = map[key];
            node.value = value;

            deleteNode(node);
            addToHead(node);
        }
        else{
            Node node = new Node(key, value);
            map[key] = node;
            if(count < capacity){
                count++;
                addToHead(node);
            }
            else{
                map[tail.prev.key] = null;
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
    
}

class Node{
    int key;
    int value;

    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
