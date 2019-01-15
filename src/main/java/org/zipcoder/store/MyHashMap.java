package org.zipcoder.store;

import java.util.*;

public class MyHashMap implements MyMap {
    // final field that doesn't change for any object
    private static final int BUCKET_SIZE = 100;

    // instance field that can only be set once. It is different for every Object
    private final List<Entry>[] entries;

    public MyHashMap() {
        entries = new List[BUCKET_SIZE];

        for (int i = 0; i < BUCKET_SIZE; i++) {
            entries[i] = new ArrayList<>();
        }
    }

    int sizeCounter = 0;

    @Override
    public int size() {
        int count =0;
        for (List <Entry> list : entries)  {
            count += list.size();
        }
        return count;

        // or //
//        for (int i = 0; i < BUCKET_SIZE; i++) {
//            if (entries[i].size() > 0) {
//                for (Entry e : entries[i]) {
//                    sizeCounter++;
//                }
//            }
//        }
//        return sizeCounter;
    }

    @Override
    public boolean isEmptry() {
        return size() == 0;
    }

    @Override
    public Cart get(User key) {

        List <Entry> bucket = entries[bucketIndex(key)];
        int index = keyIndex(bucket, key);
        if(index >= 0){
            return bucket.get(keyIndex(bucket, key)).getValue();
//        for (Entry e : entries[bucketIndex(key)]) {
//            if (e.getKey().equals(key)) {
//                return e.getValue();
//            }
        }
        return null;
    }

    @Override
    public void put(User key, Cart value) {
//        for (Entry e: entries[bucketIndex(key)]){
//            if (e.getKey().equals(value)){
//                e.setValue(value);
//                return;
//            }
        // }
        entries[bucketIndex(key)].add(new Entry(key, value));
    }

    @Override
    public List<User> getKeys() {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < BUCKET_SIZE; i++) {
            if (entries[i].size() > 0) {
                for (Entry e : entries[i]) {
                    users.add(e.getKey());
                }
            }
        }
        return users;
    }

    @Override
    public List<Cart> getValues() {
        List<Cart> ct = new ArrayList<>();
        for (List<Entry> list : entries) {
            for (Entry e : list) {
                ct.add(e.getValue());
            }
//        for (int i = 0; i < BUCKET_SIZE; i++){
//            if (entries[i].size() > 0){
//                for (Entry e: entries[i]){
//                    ct.add(e.getValue());
//                }
//            }
        }
        return ct;
    }

    @Override
    public Cart remove(User key) {
        Cart cart = null;
        for (Entry e : entries[bucketIndex(key)]) {
            if (e.getKey().equals(key)) {
                cart = e.getValue();
                remove(key);
            }
        }
        return cart;
    }

    private int bucketIndex(User key) {
        return Math.abs(key.hashCode()) % entries.length;
    }

    private int keyIndex(List<Entry> bucket, User key) {
        int index = -1;
        for (int i = 0; i < bucket.size(); i++) {
            index = i;
        }
        return index;
    }
}
