package data_structures;

import java.util.*;


public class MyHashMap<K, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] storage = new LinkedList[100];
    private int capacity = 100;

    private Set<K> keys = new HashSet<>();
    private Set<V> values = new HashSet<>();
    private Set<Entry<K, V>> entries = new HashSet<>();

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for(V currentValue: values)
            if(currentValue.equals(value))
                return true;
        return false;
    }

    @Override
    public V get(Object key) {
        int keyHashCode = key.hashCode();
        if(storage[keyHashCode % capacity] == null)
            return null;

        for(int i = 0; i < storage[keyHashCode % capacity].size(); i++) {
            if(storage[keyHashCode % capacity].get(i).key.equals(key))
                return storage[keyHashCode % capacity].get(i).value;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V previousValue = null;
        int keyHashCode = key.hashCode();
        if(storage[keyHashCode % capacity] == null){
            storage[keyHashCode % capacity] = new LinkedList<>();
        }
        for(int i = 0; i < storage[keyHashCode % capacity].size(); i++) {
            if(storage[keyHashCode % capacity].get(i).key.equals(key)) {
                previousValue = storage[keyHashCode % capacity].get(i).value;
                storage[keyHashCode % capacity].set(i, new Node(key, value));
            }
        }
        storage[keyHashCode % capacity].add(new Node(key, value));
        keys.add(key);
        values.add(value);
        values.remove(previousValue);
        entries.add(Map.entry(key, value));
        return previousValue;
    }

    @Override
    public V remove(Object key) {
        V previousValue = null;
        int keyHashCode = key.hashCode();
        if(storage[keyHashCode % capacity] == null){
            return null;
        }
        for(int i = 0; i < storage[keyHashCode % capacity].size(); i++) {
            if(storage[keyHashCode % capacity].get(i).key.equals(key)) {
                previousValue = storage[keyHashCode % capacity].get(i).value;
                storage[keyHashCode % capacity].set(i, null);
            }
        }
        if(previousValue != null){
            keys.remove((K)key);
            values.remove(previousValue);
            entries.remove(Map.entry(key,previousValue));
        }


        return previousValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Entry<? extends K, ? extends V> x: m.entrySet())
            put(x.getKey(),x.getValue());
    }

    @Override
    public void clear() {
        keys = new HashSet<>();
        values = new HashSet<>();
        storage = new LinkedList[2 * capacity];
        entries = new HashSet<>();
    }

    @Override
    public Set<K> keySet() {
        return keys;
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }


    MyHashMap() {
    }



    MyHashMap(int capacity) {
        storage = new LinkedList[2 * capacity];
        this.capacity = capacity;
    }
}
