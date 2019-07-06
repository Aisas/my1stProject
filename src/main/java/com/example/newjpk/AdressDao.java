package com.example.newjpk;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("adressDao")
public class AdressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Adress selectAdressById(long idAdress){
        return  entityManager.find(Adress.class, idAdress);
    }

    public void insertAdress(Adress adress){
        entityManager.persist(adress);
    }

    public void updateAdress(Adress adress){
        Adress adressToUpdate=selectAdressById(adress.getIdAdres());
        adressToUpdate.setCity(adressToUpdate.getCity());
        adressToUpdate.setCityCode(adressToUpdate.getCityCode());
        adressToUpdate.setStreet(adressToUpdate.getStreet());
        adressToUpdate.setTaxPayer(adressToUpdate.getTaxPayer());
        entityManager.flush();
    }

    public void deleteAdress(long idAdress){
        entityManager.remove(selectAdressById(idAdress));
    }

    public List<Adress> selectAllAdress(){
        Query query = entityManager.createQuery("SELECT * from Adress");
        return (List<Adress>) query.getResultList();
    }

}
