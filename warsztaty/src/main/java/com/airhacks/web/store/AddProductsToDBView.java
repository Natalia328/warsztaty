package com.airhacks.web.store;

import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.model.jpa.ProductEntity;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class AddProductsToDBView {
    @Inject
    private ProductDao productDao;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void setNew() {
        if (productDao.getProducts().size() == 0) {
            ProductEntity p1 = new ProductEntity(1L, "Książka kucharska", 49.99);
            productDao.addNewProduct(p1);
            ProductEntity p2 = new ProductEntity(2L, "Przewodnik górski", 59.99);
            productDao.addNewProduct(p2);
            ProductEntity p3 = new ProductEntity(3L, "Nauka szybkiego czytania", 19.99);
            productDao.addNewProduct(p3);
            ProductEntity p4 = new ProductEntity(4L, "Początkujący programista", 29.99);
            productDao.addNewProduct(p4);
        }
    }
}
