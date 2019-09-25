package com.nicos.inc.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	Product door = new Product("Wooden door", 35);
	Product floorPanel = new Product("Floor panel", 25);
	Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        System.out.println(products);
        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()){
            Product product = productIterator.next();
            System.out.println(product);
        }


    }



}
