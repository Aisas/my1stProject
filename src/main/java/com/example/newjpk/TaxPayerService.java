package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("taxPayerService")
public class TaxPayerService {

    @Autowired
    @Qualifier("taxPayerDao")
    private TaxPayerDao taxPayerDao;

    @Transactional
    public TaxPayer getTaxPayerById(long IdTaxPayer){
        return taxPayerDao.selectTaxPayerById(IdTaxPayer);
    }
    @Transactional
    public void addTaxPayer(TaxPayer taxPayer) {
        taxPayerDao.insertTaxPayer(taxPayer);
    }

    @Transactional
    public void modifyTaxPayer(TaxPayer taxPayer){
        taxPayerDao.updateTaxPayer(taxPayer);
    }

    @Transactional
    public List<TaxPayer> getAllTaxPayer(){
        return taxPayerDao.selectAllTaxPayer();
    }
    @Transactional
    public void removeTaxPayer(long IdTaxPayer){
        taxPayerDao.deleteTaxPayer(IdTaxPayer);
    }


}
