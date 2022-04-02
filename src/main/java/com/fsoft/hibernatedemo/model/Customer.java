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
    @Table(name = "customer", catalog = "demo")
    public class Customer implements Serializable {

        private int idcustomer;
        private String name;
        private String address;
        private Set<Orders> orderses = new HashSet<Orders>(0);

        public Customer() {
        }

        public Customer(int idcustomer) {
            this.idcustomer = idcustomer;
        }

        public Customer(int idcustomer, String name, String address,
                        Set<Orders> orderses) {
            this.idcustomer = idcustomer;
            this.name = name;
            this.address = address;
            this.orderses = orderses;
        }

        public Customer(int idcustomer, String name, String address) {
            super();
            this.idcustomer = idcustomer;
            this.name = name;
            this.address = address;
        }

        @Id
        @Column(name = "idcustomer", unique = true, nullable = false)
        public int getIdcustomer() {
            return this.idcustomer;
        }

        public void setIdcustomer(int idcustomer) {
            this.idcustomer = idcustomer;
        }

        @Column(name = "name", length = 45)
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Column(name = "address", length = 45)
        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
        public Set<Orders> getOrderses() {
            return this.orderses;
        }

        public void setOrderses(Set<Orders> orderses) {
            this.orderses = orderses;
        }

        @Override
        public String toString() {
            return this.idcustomer+ "   "+this.name+"    "+this.address;
        }

    }
