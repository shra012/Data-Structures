package com.shrvn.ds.hashing.map;

import java.util.ArrayList;

public class Map<K, V> {

    // bucketArray is used to store array of chains
    private ArrayList<HashNode<K, V>> bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    public Map(int numBuckets, int size) {
        this.bucketArray = new ArrayList<>();
        this.numBuckets = numBuckets;
        this.size = size;
    }

    public Map() {
        this.bucketArray = new ArrayList<>();
        this.numBuckets = 10;
        this.size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    public V remove(K key) {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {

            if (head.key.equals(key))
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {

            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            // If found update the value.
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> new_node = new HashNode<>(key, value);
        new_node.next = head;
        bucketArray.set(bucketIndex, new_node);

        if ((size / numBuckets) > 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            size = 0;
            numBuckets = numBuckets * 2;

            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }
            for (HashNode<K, V> node : temp) {
                while (node != null) {
                    add(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Map<String, Integer>map = new Map<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

}
