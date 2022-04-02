package com.fsoft.hibernatedemo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

    @Entity
    @Table(name = "item", catalog = "demo")
    public class Item implements Serializable {

        private int iditem;
        private String name;
        private Float cost;
        private Set<Orders> orderses = new HashSet<Orders>(0);

        public Item() {
        }

        public Item(int iditem) {
            this.iditem = iditem;
        }

        public Item(int iditem, String name, Float cost, Set<Orders> orderses) {
            this.iditem = iditem;
            this.name = name;
            this.cost = cost;
            this.orderses = orderses;
        }

        @Id
        @Column(name = "iditem", unique = true, nullable = false)
        public int getIditem() {
            return this.iditem;
        }

        public void setIditem(int iditem) {
            this.iditem = iditem;
        }

        @Column(name = "name", length = 45)
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Column(name = "cost", precision = 12, scale = 0)
        public Float getCost() {
            return this.cost;
        }

        public void setCost(Float cost) {
            this.cost = cost;
        }

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
        public Set<Orders> getOrderses() {
            return this.orderses;
        }

        public void setOrderses(Set<Orders> orderses) {
            this.orderses = orderses;
        }

    }
