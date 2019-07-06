package com.example.newjpk;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("taxPayerDao")
public class TaxPayerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public TaxPayer selectTaxPayerById(long IdTaxPayer){
        return entityManager.find(TaxPayer.class, IdTaxPayer);
    }

    public void insertTaxPayer (TaxPayer taxPayer){
        entityManager.persist(taxPayer);
    }

    public void updateTaxPayer (TaxPayer taxPayer){

    TaxPayer taxPayerToUpdate=selectTaxPayerById(taxPayer.getIdTaxPayer());
    taxPayerToUpdate.setFirstName(taxPayer.getFirstName());
    taxPayerToUpdate.setPayer(taxPayer.getPayer());
    taxPayerToUpdate.setSupplier(taxPayer.getSupplier());
    taxPayerToUpdate.setIdAdress(taxPayer.getIdAdress());
    taxPayerToUpdate.setNIP(taxPayer.getNIP());
    taxPayerToUpdate.setName_Surname(taxPayer.getName_Surname());
    entityManager.flush();
    }

    public void deleteTaxPayer(long IdTaxPayer){
        entityManager.remove(selectTaxPayerById(IdTaxPayer));
    }

    public List<TaxPayer> selectAllTaxPayer(){
        Query query = entityManager.createQuery("from TaxPayer as taxPayer order by TaxPayer.IDTaxPayer");
        return (List<TaxPayer>) query.getResultList();
    }

}
