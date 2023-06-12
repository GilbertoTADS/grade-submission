package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

public class InventoryEntity {
   private static List<ProductEntity> products = new ArrayList<>();

    InventoryEntity(){}

    public static List<ProductEntity> getProducts() {
        return InventoryEntity.products;
    }

    public static void setProducts(List<ProductEntity> products) {
        InventoryEntity.products = products;
    }
    public static boolean exists(ProductEntity product){
        return products.indexOf(product) != -1;
    }
    public static boolean add(ProductEntity product) {
        return InventoryEntity.exists(product) ? false: products.add(product);
    }
}
