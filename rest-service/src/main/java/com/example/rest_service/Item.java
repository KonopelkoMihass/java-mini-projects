package com.example.rest_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


// In order for it to be stored in a database, we need to utilise JPA (Java Persistent API). To mark a Plain Old Java
// Object (POJO), we add annotation @Entity.
@Entity
public class Item {

    private String brand;
    private String name;
    private  @Id @GeneratedValue Long id; // This way, it will be generated based on the content of the table.
    private double grossPrice;


    Item(){}

    Item(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }


    public String getBrand() { return brand; }
    public void setBrand(String newBrand) { this.brand = newBrand;}

    public double getGrossPrice() { return this.grossPrice; }
    public void setGrossPrice(double newPrice) { this.grossPrice = newPrice;}

    public String getName() { return this.name; }
    public void setName(String newName) { this.name = newName;}

    public Long getID() { return this.id; }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order))
            return false;
        Item item = (Item) o;
        return Objects.equals(this.getID(), item.getID()) &&
                Objects.equals(this.getName(), item.getName()) &&
                Objects.equals(this.getBrand(), item.getBrand()) &&
                Objects.equals(this.getGrossPrice(), item.getGrossPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getID(), this.getName(), this.getBrand(), this.getGrossPrice());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Item{");
        sb.append("id=").append(this.id).append(" ,");
        sb.append("brand=").append(this.brand).append(" ,");
        sb.append("name=").append(this.name).append(" ,");
        sb.append("grossPrice=").append(this.grossPrice).append("}");
        return sb.toString();
    }
}
