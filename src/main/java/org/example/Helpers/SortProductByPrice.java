package org.example.Helpers;

import org.example.Pojo.Product;

import java.util.Comparator;

public class SortProductByPrice implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        double price1 = p1.price.isEmpty()?0:Double.parseDouble(p1.price.replace(",", ""));
        double price2 = p2.price.isEmpty()?0:Double.parseDouble(p2.price.replace(",", ""));
        return Double.compare(price1, price2);
    }
}
