package org.mcyldz.productapi.service.impl;


import org.mcyldz.productapi.model.Product;
import org.mcyldz.productapi.repository.ProductRepository;
import org.mcyldz.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) throws Exception {
        try {
            productRepository.save(product);
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }
    }

    @Override
    public List<Product> findAll() throws Exception {
        try {
            return productRepository.findAll();
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }

    }

    @Override
    public Product findById(int id) throws Exception {
        try {
            Product response;
            Optional<Product> product=productRepository.findById(id);
            if(product.isPresent()){
                response = product.get();
                return response;
            }else{
                throw new RuntimeException("Product not found for the id: "+id);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            Product product = findById(id);
            if(product!=null){
                productRepository.delete(product);
            }else{
                throw new RuntimeException("Product not found for the id: "+id);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }
    }

    public List<Product> findByName(String name) throws Exception {
        try {
            List<Product> productList = productRepository.findByName(name);
            if(productList != null){
                return productList;
            }else{
                throw new RuntimeException("Product list not found for the name: "+name);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }
    }

    public Product getProduct(int productId, String name) throws Exception {
        try {
            Product product = productRepository.getProduct(productId,name);
            if(product!=null){
                return product;
            }else{
                throw new RuntimeException("Product not found for the id: " + productId +" and name: "+name);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: " + ex.getMessage());
        }
    }
}
