package org.mcyldz.productapi.service;

import org.mcyldz.productapi.model.dto.ExampleDTO;

public interface CustomService {
    ExampleDTO getExampleDTOByIdAndName(int productId, String name) throws Exception;
}
