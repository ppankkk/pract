package com.skillsup.services.DTO;

import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.model.User;

import java.util.Date;
import java.util.Set;

public class OrderDTO {
    private User user;
    private Set<Product> products;
    private String status;
    private Date date;

    public OrderDTO(User user, Set<Product> products, String status, Date date) {
        this.user = user;
        this.products = products;
        this.status = status;
        this.date = date;
    }

    public OrderDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "user=" + user +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}