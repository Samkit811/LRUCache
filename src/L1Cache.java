import java.util.LinkedHashMap;

public class L1Cache implements Cache<Integer,Integer> {

    private int capacity;
    private LinkedHashMap<Integer, Integer> linkedHashMap;
    private DBConnection dbConnection;

    public L1Cache(int capacity, DBConnection dbConnection){
        this.capacity = capacity;
        this.linkedHashMap = new LinkedHashMap<>(this.capacity, 0.75f, true);
        this.dbConnection = dbConnection;
    }

    @Override
    public Integer search(Integer key) {
        if(this.linkedHashMap.containsKey(key)){
            System.out.println("Item: " + key + " Found in the cache");
            return this.value(key);
        }
        System.out.println("Item: " + key + " Not Found in Cache");
        return this.fetchDataFromDB(key);
    }

    private Integer fetchDataFromDB(Integer key){
        Integer value = this.dbConnection.fetchFromDB(key);
        this.add(key, value);
        return value;
    }

    @Override
    public void add(Integer key, Integer value) {
        if(this.linkedHashMap.size() == this.capacity){
            System.out.println("Cache is full so deleting the oldest key present in Cache");
            Integer oldestKey = this.linkedHashMap.keySet().iterator().next();
            System.out.println("Oldest key present in Cache: " + oldestKey);
            this.remove(oldestKey);
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
