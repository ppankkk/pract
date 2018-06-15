package com.skillsup.DAO.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long user;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date date;

    @Column(name = "PRODUCTS", nullable = false)
    private Product product;

    @Column(name = "STATUS", nullable = false)
    private String status;
}
