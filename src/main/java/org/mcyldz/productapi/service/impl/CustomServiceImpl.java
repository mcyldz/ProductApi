package org.mcyldz.productapi.service.impl;

import org.mcyldz.productapi.model.dto.ExampleDTO;
import org.mcyldz.productapi.repository.CustomRepository;
import org.mcyldz.productapi.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements CustomService {

    private final CustomRepository customRepository;
    @Autowired
    public CustomServiceImpl(CustomRepository customRepository) {
        this.customRepository = customRepository;
    }

    public ExampleDTO getExampleDTOByIdAndName(int productId, String name) throws Exception {
        try {
            ExampleDTO exampleDTO = customRepository.getExampleDTOByIdAndName(productId, name);
            if (exampleDTO != null) {
                return exampleDTO;
            } else {
                throw new RuntimeException("ExampleDTO not found for the id: " + productId + " and name: " + name);
            }
        } catch (Exception ex) {
            throw new Exception("Exception message: " + ex.getMessage());
        }

    }
}
