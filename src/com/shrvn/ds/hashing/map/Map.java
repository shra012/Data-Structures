package com.shrvn.ds.hashing.map;

import java.util.ArrayList;

public class Map<K,V> {

    // bucketArray is used to store array of chains
    private ArrayList<HashNode<K,V>> bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    public Map( int numBuckets, int size) {
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

    public boolean isEmpty(){
        return size()==0;
    }


    public int getBucketIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    public V remove(K key){
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);

        HashNode<K,V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head!=null){

            if(head.key.equals(key))
                break;

            prev=head;
            head = head.next;
        }

        if(head==null)
            return null;

        size--;

        if(prev!=null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex,head.next);

        return head.value;
    }

}
