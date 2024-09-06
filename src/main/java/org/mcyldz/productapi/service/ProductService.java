package org.mcyldz.productapi.service;

import org.mcyldz.productapi.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product) throws Exception;

    List<Product> findAll() throws Exception;

    Product findById(int id) throws Exception;

    void delete(int id) throws Exception;

    List<Product> findByName(String name) throws Exception;

    Product getProduct(int productId, String name) throws Exception;
}
