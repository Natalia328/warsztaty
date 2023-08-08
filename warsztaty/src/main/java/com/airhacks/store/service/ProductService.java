package com.airhacks.store.service;

import com.airhacks.rest.store_rest.*;
import com.airhacks.store.dao.ProductDao;
import com.airhacks.store.model.jpa.ProductEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class ProductService {
        @Inject
        private ProductDao productDao;

        public ProductResponse getProduct(int id){
            ProductResponse response = new ProductResponse();
            ProductEntity entity = productDao.getProduct(id);
            response.setProductName(entity.getProductName());
            response.setPrice(entity.getPrice());
            response.setQuantity(entity.getQuantity());
            response.setId(entity.getId());

//            Collection<SubjectDTO> subjectDTOS = getSubjectDTOS(entity);
//            response.setSubjects(subjectDTOS);
            return response;
        }

//        private Collection<SubjectDTO> getSubjectDTOS(LecturerEntity entity) {
//            Collection<SubjectEntity> subjectEntities = entity.getSubjects();
//            Collection<SubjectDTO> subjectDTOS = new ArrayList<>();
//
//            for (SubjectEntity subjectEntity: subjectEntities) {
//                SubjectDTO subjectDTO = new SubjectDTO();
//                subjectDTO.setId(subjectEntity.getId());
//                subjectDTO.setName(subjectEntity.getName());
//                subjectDTO.setYear(subjectEntity.getYear());
//                subjectDTOS.add(subjectDTO);
//            }
//            return subjectDTOS;
//        }


        public ProductsResponse getProducts(){
            ProductsResponse response = new ProductsResponse();
            List<ProductEntity> productEntities = productDao.getProducts();
            List<ProductDTO> productDTOS = new ArrayList<>();
            for (ProductEntity productEntity: productEntities){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(productEntity.getId());
                productDTO.setProductName(productEntity.getProductName());
                productDTO.setPrice(productEntity.getPrice());
                productDTO.setQuantity(productEntity.getQuantity());
                productDTOS.add(productDTO);
            }
            response.setProducts(productDTOS);
            return response;
        }

        public ProductsResponse getProductDTO() {
            ProductsResponse response = new ProductsResponse();
            List<ProductDTO> productsDTOS = productDao.getProductsDto();
            response.setProducts(productsDTOS);
            return response;
        }
}
