package org.mcyldz.productapi.controller;

import org.mcyldz.productapi.model.Product;
import org.mcyldz.productapi.model.dto.ExampleDTO;
import org.mcyldz.productapi.service.CustomService;
import org.mcyldz.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;
    private final CustomService customService;

    @Autowired
    public ProductController(ProductService productService, CustomService customService) {
        this.productService = productService;
        this.customService = customService;
    }

    @PostMapping("/product")
    public void save(@RequestBody Product product) throws Exception {
        productService.save(product);
    }

    @GetMapping("/product")
    public List<Product> get() throws Exception {
        return productService.findAll();
    }

    @PutMapping("/product")
    public void update(@RequestBody Product product) throws Exception {
        productService.save(product);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable int id) throws Exception {
        productService.delete(id);
    }

    @GetMapping("/product/getById/{id}")
    public Product get(@PathVariable int id) throws Exception {
        Product product = productService.findById(id);
        return product;
    }

    @GetMapping("/product/getByName/{name}")
    public List<Product> getByName(@PathVariable String name) throws Exception {
        List<Product> productList=productService.findByName(name);
        return productList;
    }

    @GetMapping(path = "/product/getProduct/{id}/{name}")
    public Product getProduct(@PathVariable int id, @PathVariable String name) throws Exception {
        Product product = productService.getProduct(id,name);
        return product;
    }

    @GetMapping(path = "/product/getTypedQueryByIdAndName/{id}/{name}")
    public ExampleDTO getTypedQuery(@PathVariable int id, @PathVariable String name) throws Exception {
        ExampleDTO exampleDTO = customService.getExampleDTOByIdAndName(id,name);
        return exampleDTO;
    }
}
