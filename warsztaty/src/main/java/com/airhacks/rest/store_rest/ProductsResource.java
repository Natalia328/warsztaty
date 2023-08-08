package com.airhacks.rest.store_rest;

import com.airhacks.store.service.ProductService;
import com.airhacks.store.service.UserService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import com.airhacks.rest.*;
import com.airhacks.store.service.UserService;
import com.airhacks.university.lecturer.service.LecturerService;
import com.airhacks.university.lecturer.service.SubjectService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("store_products")
@Consumes("application/json")
@Produces("application/json")
public class ProductsResource {

        @Inject
        private ProductService productService;

//        @Inject
//        private SubjectService subjectService;


        @GET
        @Path("product/{id}")
        public ProductResponse getProduct(@PathParam("id") int id){
            return productService.getProduct(id);
        }

        @GET
        @Path("products")
        public ProductsResponse getProducts(){
            return productService.getProducts();
        }

//        @POST
//        @Path("subject")
//        public void addNewSubject(@RequestBody SubjectRequest request){
//            subjectService.addNewSubject(request);
//
//        }
//
//        @GET
//        @Path("subject/{id}")
//        public SubjectResponse getSubject(@PathParam("id") Long id) {
//            return subjectService.getSubject(id);
//        }



    }


