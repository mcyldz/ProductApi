package org.mcyldz.productapi.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.mcyldz.productapi.model.dto.ExampleDTO;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ExampleDTO getExampleDTOByIdAndName(int productId, String name){

        //TypedQuery
        TypedQuery<ExampleDTO> query = entityManager.createQuery("SELECT NEW org.mcyldz.Product.model.dto.ExampleDTO(e.productId,e.name,concat(e.productId,concat('-',e.name) ) ) "+
                "FROM Product e "+
                "WHERE e.productId =:productId "+
                "AND e.name=:name",ExampleDTO.class).setParameter("productId",productId).setParameter("name",name);

        ExampleDTO exampleDTO = query.getSingleResult();
        return exampleDTO;

    }
}
