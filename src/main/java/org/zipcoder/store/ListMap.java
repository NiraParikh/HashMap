package org.zipcoder.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMap implements MyMap {
    // instance field that is intialize to an ArrayList
    private List<Entry> entries = new ArrayList<>();

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmptry() {
        return entries.size() == 0;
    }

    @Override
    public Cart get(User key) {
        // find the cart associate with the key
        for (Entry entry: entries){
            if(entry.getKey().equals(key))
                return entry.getValue();
            }
        return null;
    }

    @Override
    public void put(User key, Cart value) {
        // add the key, value entry to the entries list
        for (Entry ent: entries) {
            if (ent.getKey().equals(key)) {
                ent.setValue(value);
            }
        }
        entries.add(new Entry(key,value));
    }

    @Override
    public List<User> getKeys() {
        // get all the keys in the map
        List <User> users = new ArrayList<>();
        for (Entry entry: entries){
            users.add(entry.getKey());
        }
        return users;
    }

    @Override
    public List<Cart> getValues() {
        // get all the values in the map
        List <Cart> carts = new ArrayList<>();
        for (Entry entry:entries){
            carts.add(entry.getValue());
        }
        return carts;
    }

    @Override
    public Cart remove(User key) {
        Cart cart = null;
        for (Iterator <Entry> i = entries.iterator(); i.hasNext();){
            Entry entry =i.next();
            if (entry.getKey().equals(key)){
                cart = entry.getValue();
                i.remove();
            }
        }
        return cart;
    }
}
