package org.zipcoder.store;

import java.util.Objects;

public class Cart {
    private final long id;

    public Cart(long id) {
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    @Override
    public boolean equals (Object a){
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Cart cart = (Cart) a;
        return id ==cart.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id); // Objects is a class of java.lang package
    }
}
