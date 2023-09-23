package com.airhacks.rest.store_rest;

import com.airhacks.store.service.ProductService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.*;


@Path("store_products")
@Consumes("application/json")
@Produces("application/json")
public class ProductsResource {

        @Inject
        private ProductService productService;

        @GET
        @Path("product/{id}")
        public ProductResponse getProduct(@PathParam("id") Long id){
            return productService.getProduct(id);
        }

        @GET
        @Path("products")
        public ProductsResponse getProducts(){
            return productService.getProducts();
        }

        @POST
        @Path("products")
        public void addNewProduct(@RequestBody ProductRequest request){
            productService.addNewProduct(request);
        }
    }


