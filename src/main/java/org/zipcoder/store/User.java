package org.zipcoder.store;

import java.util.Objects;

public class User {

    private long id;
    private String name;

    public User(){}

    public User(long id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }

    public User(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object a){
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        User user = (User) a;  //explicit conversion - converting a to user from object
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
