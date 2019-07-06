package com.example.newjpk;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("registerDao")
public class RegisterDao {

    @PersistenceContext
    private EntityManager entityManager;

        public Register selectRegisterById(long IDRegister){
            return entityManager.find(Register.class, IDRegister);
        }

        public void insertRegister (Register register){
            entityManager.persist(register);
        }

        public void updateRegister(Register register){
            Register registerToUpdate = selectRegisterById(register.getIDRegister());
            registerToUpdate.setTransactionDate(registerToUpdate.getTransactionDate());
            registerToUpdate.setInvNr(registerToUpdate.getInvNr());
            registerToUpdate.setCur(registerToUpdate.getCur());
            registerToUpdate.setDescription(registerToUpdate.getDescription());
            registerToUpdate.setIfFA(registerToUpdate.getIfVAT());
            registerToUpdate.setIfVAT(registerToUpdate.getIfVAT());
            registerToUpdate.setIncomeOrCost(registerToUpdate.getIncomeOrCost());
            registerToUpdate.setNetto(registerToUpdate.getNetto());
            registerToUpdate.setBrutto(registerToUpdate.getBrutto());
            registerToUpdate.setVat(registerToUpdate.getVat());
            registerToUpdate.setPayer(registerToUpdate.getPayer());
            registerToUpdate.setSupplier(registerToUpdate.getSupplier());
            registerToUpdate.setDescription(registerToUpdate.getDescription());
            entityManager.flush();
        }

    public void deleteRegister (long IDRegister){
        entityManager.remove(selectRegisterById(IDRegister));
    }

    public List<Register> selectAllRegister(){
        Query query = entityManager.createQuery("SELECT * from Register");
        return (List<Register>) query.getResultList();
    }



}
