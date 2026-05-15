import java.util.LinkedList;

public class LinkedListUsingLL extends LinkedList<Integer>{

    public static void main(String[] args){
        LinkedListUsingLL linkedListUsingLL = new LinkedListUsingLL();
        linkedListUsingLL.add(1);
        linkedListUsingLL.add(5);
        linkedListUsingLL.add(10);
        for(Integer i: linkedListUsingLL)
            System.out.println(i);
        System.out.println("-----------------------");
        linkedListUsingLL.add(1,3);
        //linkedListUsingLL.add(20, 20); Exception
        linkedListUsingLL.addFirst(0);
        linkedListUsingLL.addLast(11);
        for(Integer i: linkedListUsingLL)
            System.out.println(i);

        System.out.println("-----------------------");
        System.out.println(linkedListUsingLL.remove());
        System.out.println(linkedListUsingLL.removeFirst());
        System.out.println(linkedListUsingLL.removeLast());
        System.out.println(linkedListUsingLL.remove(1));
        //System.out.println(linkedListUsingLL.remove(10)); exception

    }
}
