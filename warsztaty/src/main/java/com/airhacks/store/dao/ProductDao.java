package com.airhacks.store.dao;


import com.airhacks.rest.store_rest.ProductDTO;
import com.airhacks.store.model.jpa.ProductEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
@Stateless
public class ProductDao implements Serializable{

    @PersistenceContext(unitName = "pawUnitMySQL")
    private EntityManager entityManager;

    public void addNewProduct(ProductEntity product) {
        entityManager.persist(product);
    }
    public ProductEntity getProduct(Long id) {
        return entityManager
                .createQuery("SELECT l FROM ProductEntity l " + "WHERE l.id = :id",
                            ProductEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    public List<ProductEntity> getProducts(){
        return entityManager
                .createQuery("SELECT l FROM ProductEntity l", ProductEntity.class)
                .getResultList();
    }
    public List<ProductDTO> getProductsDto() {
        return entityManager
              .createQuery("SELECT new com.airhacks.rest.store_rest.ProductDTO(l.id, l.productName," +
                            "l.price) FROM ProductEntity l", ProductDTO.class)
              .getResultList();
    }
}




