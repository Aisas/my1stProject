package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("adressService")
public class AdressService {

    @Autowired
    @Qualifier("adressDao")
    private AdressDao adressDao;

    @Transactional
    public Adress getAdressById(long idAdress){
        return adressDao.selectAdressById(idAdress);
    }
    @Transactional
    public void modifyAdress(Adress adress){
        adressDao.updateAdress(adress);
    }
    @Transactional
    public List<Adress> getAllAdress(){
        return adressDao.selectAllAdress();
    }

    @Transactional
    public void addAdress(Adress adress) {
        adressDao.insertAdress(adress);
    }

    @Transactional
    public void removeAdress(long idAdress){
        adressDao.deleteAdress(idAdress);
    }

}
