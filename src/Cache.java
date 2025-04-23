public interface Cache<K, V> {
    public Integer search(K key);
    public void add(K key, V value);
    public void remove(K key);
    public int value(K key);
}
