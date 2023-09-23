package com.airhacks.store.model.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "firstName", nullable = false)
        private String firstName;

        @Column(name = "lastName", nullable = false)
        private String lastName;

        @Column(name = "email", nullable = false, unique = true)
        private String email;

        @Column(name = "password", nullable = false)
        private String password;
        @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
        private Collection<OrdersEntity> ordersEntities;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
        return password;
    }

        public void setPassword(String password) {
        this.password = password;
    }
        public Collection<OrdersEntity> getOrdersEntities() {
        return ordersEntities;
    }
        public void setOrdersEntities(Collection<OrdersEntity> ordersEntities) {
        this.ordersEntities = ordersEntities;
    }

    @Override
    public String toString() {
        return firstName +
                " " + lastName + " " + email;
    }
}

