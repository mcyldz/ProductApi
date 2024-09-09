# ProductAPI Documentation

Welcome to the documentation for the ProductAPI, a RESTful API for managing product information. This API is built using Spring Boot and supports CRUD operations with a MySQL database.

## Table of Contents

- [Endpoints](#endpoints)
  - [Get Product](#get-product)
  - [Get Product By ID](#get-product-by-id)
  - [Get Product By Name](#get-product-by-name)
  - [Get All Products](#get-all-products)
  - [Update Products](#update-products)
  - [Delete Products](#delete-products)
  - [Get Custom Query Result](#get-custom-query-result)
- [Database Configuration](#database-configuration)

## Endpoints

### Get Product

Get information about a specific product by providing its ID.

- **Endpoint:** `/api/product`
- **Method:** POST
- **Request Body**
  ```json
  {
  "productId": 1,
  "name": "CPU"
  }
  ```
- **Response:**
  ```json
  {
    "productId": 1,
    "name": "CPU",
  }
  ```

### Get Product By ID

Fetches an product's details using their ID.

- **Endpoint:** `/api/product/getById/{id}`
- **Method:** GET
- **Response**
  ```json
  {
  "productId": 1,
  "name": "CPU"
  }
  ```

### Get Product By Name

Fetches products with a given name.
  
- **Endpoint:** `/api/product/getByName/{name}`
- **Method:** GET
- **Response**
  ```json
  {
  "productId": 1,
  "name": "CPU"
  },
  {
  "productId": 2,
  "name": "GPU"
  }
  ```
  
### Get All Products

Fetches the list of all products.
  
- **Endpoint:** `/api/product`
- **Method:** GET
- **Response**
  ```json
  {
  "productId": 1,
  "name": "CPU"
  },
  {
  "productId": 2,
  "name": "GPU"
  }
  ```
  
### Update Products

Updates an existing products's details.
  
- **Endpoint:** `/api/product`
- **Method:** PUT
- **Request Body**
  ```json
  {
  "productId": 1,
  "name": "Motherboard"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Product updated successfully"
  }
  ```
  
### Delete Products

Updates an existing products's details.
  
- **Endpoint:** `/api/product/{id}`
- **Method:** DELETE
- **Response:**
  ```json
  {
    "message": "Product deleted successfully"
  }
  ```

### Get Custom Query Result

Fetches a custom DTO (Data Transfer Object) with the product's details and a concatenated ID-name value..

- **Endpoint:** `/api/product/getTypedQueryByIdAndName/{id}/{name}`
- **Method:** GET
- **Response:**
  ```json
  {
  "productId": 1,
  "name": "Motherboard",
  "idName": "1-Motherboard"
  }
  ```
  
### Database Configuration
This project uses MySQL as the database. To configure the database, follow these steps:

1. Install MySQL and create a database:
```sql
  CREATE DATABASE jpa;
```
2. Configure the connection settings in application.properties:
```
  spring.datasource.url=jdbc:mysql://localhost:3306/jpa
  spring.datasource.username=root
  spring.datasource.password=yourpassword
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
```
