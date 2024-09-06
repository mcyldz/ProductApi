package org.mcyldz.productapi.model.dto;

public class ExampleDTO {

    private int productId;
    private String name;
    private String idName;

    public ExampleDTO(int productId, String name, String idName) {
        this.productId = productId;
        this.name = name;
        this.idName = idName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }
}
