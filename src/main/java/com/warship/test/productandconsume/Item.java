package com.warship.test.productandconsume;

public class Item {
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int id ;

    public String name;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
