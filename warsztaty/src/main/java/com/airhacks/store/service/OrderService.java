package com.airhacks.store.service;

import com.airhacks.rest.store_rest.OrderRequest;
import com.airhacks.rest.store_rest.OrderResponse;
import com.airhacks.rest.store_rest.ProductDTO;
import com.airhacks.rest.store_rest.UserDTO;
import com.airhacks.store.dao.OrdersDao;
import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.jpa.OrdersEntity;
import com.airhacks.store.model.jpa.ProductEntity;
import com.airhacks.store.model.jpa.UserEntity;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderService {

    @Inject
    private UserDao userDao;
    @Inject
    private OrdersDao ordersDao;
    @Inject
    private ProductDao productDao;

    public void addNewOrder(OrderRequest request){
        OrdersEntity ordersEntity = new OrdersEntity();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        ordersEntity.setOrderDate(timeStamp);

        UserEntity userEntity = userDao.getUser(request.getUserId());
        ordersEntity.setUser(userEntity);

        ProductEntity productEntity = productDao.getProduct(request.getProductId());
        ordersEntity.setProduct(productEntity);

        ordersDao.addNewOrder(ordersEntity);
    }

    public OrderResponse getOrder(Long id){
        OrderResponse response = new OrderResponse();
        OrdersEntity ordersEntity = ordersDao.getOrder(id);
        response.setId(ordersEntity.getId());
        response.setOrderDate(ordersEntity.getOrderDate());

        UserDTO user = new UserDTO();
        UserEntity userEntity = ordersEntity.getUser();
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setId(userEntity.getId());
        response.setUser(user);

        ProductDTO product = new ProductDTO();
        ProductEntity productEntity = ordersEntity.getProduct();
        product.setProductName(productEntity.getProductName());
        product.setPrice(productEntity.getPrice());
        product.setId(productEntity.getId());
        response.setProduct(product);

        return response;
    }
}
