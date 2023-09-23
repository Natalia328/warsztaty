package com.airhacks.store.dao;

import com.airhacks.store.model.jpa.OrdersEntity;
import com.airhacks.store.model.jpa.ProductEntity;
import com.airhacks.store.model.jpa.UserEntity;
import com.airhacks.university.lecturer.model.SubjectEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrdersDao {

    @PersistenceContext(unitName = "pawUnitMySQL")
    private EntityManager entityManager;

    public void addNewOrder(OrdersEntity order){
        entityManager.persist(order);
    }

    public OrdersEntity getOrder(Long id) {
        return entityManager.find(OrdersEntity.class, id);
    }

    public List<OrdersEntity> getOrders(){
        return entityManager
                .createQuery("SELECT l FROM OrdersEntity l", OrdersEntity.class)
                .getResultList();
    }
//    public List<OrdersEntity> getOrdersByUserId(Long id){
//        return entityManager
//                .createQuery("SELECT l FROM OrdersEntity l WHERE l.user = :id", OrdersEntity.class)
//                .getResultList();
//    }

}
