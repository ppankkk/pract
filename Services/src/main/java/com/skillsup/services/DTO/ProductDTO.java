package com.skillsup.services.DTO;

public class ProductDTO {
    private String name;
    private String category;
    private String color;
    private int count;
    private int price;
    private String gender;
    private String size;

    public ProductDTO() {
    }

    public ProductDTO(String name,
                      String category,
                      String color,
                      String gender,
                      int count,
                      int price,
                      String size) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.gender = gender;
        this.count = count;
        this.price = price;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
