package com.fsoft.hibernatedemo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
    @Table(name = "orders", catalog = "demo")
    public class Orders implements Serializable {

        private int idorders;
        private Item item;
        private Customer customer;
        private Integer quantity;
        private String description;

        public Orders() {
        }

        public Orders(int idorders) {
            this.idorders = idorders;
        }

        public Orders(int idorders, Item item, Customer customer, Integer quantity,
                      String description) {
            this.idorders = idorders;
            this.item = item;
            this.customer = customer;
            this.quantity = quantity;
            this.description = description;
        }

        @Id
        @Column(name = "idorders", unique = true, nullable = false)
        public int getIdorders() {
            return this.idorders;
        }

        public void setIdorders(int idorders) {
            this.idorders = idorders;
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "iditem")
        public Item getItem() {
            return this.item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idcustomer")
        public Customer getCustomer() {
            return this.customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        @Column(name = "quantity")
        public Integer getQuantity() {
            return this.quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Column(name = "description", length = 45)
        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
