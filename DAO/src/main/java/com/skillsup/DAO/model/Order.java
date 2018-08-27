package com.skillsup.DAO.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ORDERS_PRODUCTS",
            joinColumns = @JoinColumn(name="ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCTS_ID")
    )
    private Set<Product> products;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date date;

    public Order() {

    }

    public Order(User user, Set<Product> products, String status, Date date, Long id) {
        this.user = user;
        this.products = products;
        this.status = status;
        this.date = date;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) &&
                Objects.equals(products, order.products) &&
                Objects.equals(status, order.status) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, products, status, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}