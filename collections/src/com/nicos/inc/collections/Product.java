package com.nicos.inc.collections;

public class Product {
    private final String name;
    private final int weight;

    public  Product(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
