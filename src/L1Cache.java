import java.util.LinkedHashMap;

public class L1Cache implements Cache<Integer,Integer> {

    private int capacity;
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public L1Cache(int capacity){
        this.capacity = capacity;
        this.linkedHashMap = new LinkedHashMap<>(this.capacity, 0.75f, true);
    }

    @Override
    public boolean search(Integer key) {
        if(this.linkedHashMap.containsKey(key)){
            System.out.println("Item: " + key + " Found in the cache");
            return true;
        }
        System.out.println("Item: " + key + " Not Found in Cache");
        return false;
    }

    @Override
    public void add(Integer key, Integer value) {
        if(this.linkedHashMap.size() == this.capacity){
            Integer oldestKey = this.linkedHashMap.keySet().iterator().next();
            System.out.println("Oldest key present in Cache: " + oldestKey);
            this.linkedHashMap.remove(oldestKey);
        }
        System.out.println("Item: " + key + " Added in the Cache");
        this.linkedHashMap.put(key, value);
    }

    @Override
    public void remove(Integer key) {
        System.out.println("Removing Item: " + key + " from the Cache");
        this.linkedHashMap.remove(key);
    }

    @Override
    public int value(Integer key) {
        Integer val = this.linkedHashMap.get(key);
        System.out.println("Item val: " + val + " for the key: " + key);
        return val;
    }
}
