package com.skillsup.DAO.model;

public class Product {

    private Long id;
    private String name;
    private int price;
    private String category;
    private String gender;
    private String color;
    private String size;
    private int count;

    public Product() {
    }

    public Product(String name,
                   String category,
                   String color,
                   String gender,
                   int count,
                   int price,
                   String size,
                   Long id) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.gender = gender;
        this.count = count;
        this.price = price;
        this.size = size;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", gender='" + gender + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
