package com.airhacks.store.dao;

import com.airhacks.rest.store_rest.UserDTO;
import com.airhacks.store.model.jpa.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;


public class UserDao implements Serializable {

        @PersistenceContext(unitName = "pawUnitMySQL")
        private EntityManager entityManager;

        public void addNewUser(UserEntity user) {
            entityManager.persist(user);
        }


        public UserEntity getUser(Long id) {
            return entityManager
                    .createQuery("SELECT l FROM UserEntity l " + "WHERE l.id = :id",
                            UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }


        public UserEntity getUserByEmail(String email) {
            UserEntity userByMail = entityManager
                    .createQuery("SELECT l FROM UserEntity l " + "WHERE l.email = :email",
                            UserEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return userByMail;
        }


    public List<UserEntity> isUserExist(String email, String password) {
        String query = "select l from UserEntity l where l.email = :email and l.password = :password";
        return entityManager
                .createQuery(query, UserEntity.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
    }



        public List<UserEntity> getUsers(){
            return entityManager
                    .createQuery("SELECT l FROM UserEntity l", UserEntity.class)
                    .getResultList();
        }

        public List<UserDTO> getUsersDto() {
            return entityManager
                    .createQuery("SELECT new com.airhacks.rest.store_rest.UserDTO(l.id, l.firstName," +
                            "l.lastName, l.email, l.password) FROM UserEntity l", UserDTO.class)
                    .getResultList();
        }

    }


