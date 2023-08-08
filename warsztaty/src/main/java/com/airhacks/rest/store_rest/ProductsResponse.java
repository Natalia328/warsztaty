package com.airhacks.rest.store_rest;

import java.util.Collection;

public class ProductsResponse {

    private Collection<ProductDTO> products;

    public Collection<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductDTO> products) {
        this.products = products;
    }
}
