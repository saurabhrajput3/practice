package com.project.ecommerce.Ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer id;
    @Column(name = "order_pQuantity")
    private Integer productQuantity;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user; //(foreign key mapping)

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product; //(foreign key mapping)
    @JoinColumn(name = "address_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address; //(foreign key mapping)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
