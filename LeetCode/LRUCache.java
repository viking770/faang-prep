import java.util.*;

public class LRUCache extends LinkedHashMap<Integer,Integer>{

    private final int capacity;

    LRUCache(int capacity){
        super(capacity,1.0f,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            return size() > capacity;
    }
}