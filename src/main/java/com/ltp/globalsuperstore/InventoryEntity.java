package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryEntity {
   private static List<Product> products = new ArrayList<>();

    InventoryEntity(){}

    public static List<Product> getProducts() {
        return InventoryEntity.products;
    }

    public static void setProducts(List<Product> products) {
        InventoryEntity.products = products;
    }
    public static boolean exists(Product product){
        return products.indexOf(product) != -1;
    }
    public static boolean add(Product product) {
        return InventoryEntity.exists(product) ? false: products.add(product);
    }
    public static boolean update(Product product){
        int index = products.indexOf(product);
        boolean notExist = index == -1;
        if(notExist) return false;
        products.remove(index);
        return products.add(product);
    }

    public static Product getById(String id) {
        Product product = new Product();
        product.setId(UUID.fromString(id));
        int index = products.indexOf(product);
        boolean exist = index != -1;
        if(exist) product = products.get(index);

        return exist ? product : null;
    }
}
