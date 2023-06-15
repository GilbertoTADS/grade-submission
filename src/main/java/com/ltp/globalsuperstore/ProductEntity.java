package com.ltp.globalsuperstore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductEntity{
    private UUID id;
    private String category;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private BigDecimal price;
    private BigDecimal discount;

    ProductEntity(){
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
     public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "ProductEntity [id=" + id + ", category=" + category + ", name=" + name + ", orderDate=" + orderDate
                + ", price=" + price + ", discount=" + discount + "]";
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((discount == null) ? 0 : discount.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductEntity other = (ProductEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        System.out.println("my ID "+id+" other "+other.getId());
        System.out.println("IGUAIS: "+id.toString().equals(other.getId().toString()));
        if(id.toString().equals(other.getId().toString()))
            return true;
        return false;
    }
    
}
