package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("registerService")
public class RegisterService {

    @Autowired
    @Qualifier("registerDao")
    private RegisterDao registerDao;

    @Transactional
    public Register getRegisterById(long IDRegister){
        return registerDao.selectRegisterById(IDRegister);
    }

    @Transactional
    public void addRegister(Register register){
        registerDao.insertRegister(register);
    }

    @Transactional
    public void modifyRegister(Register register){
        registerDao.updateRegister(register);
    }

    @Transactional
    public List<Register> getAllRegister(){
        return registerDao.selectAllRegister();
    }
    @Transactional
    public void removeRegister(long IDRegister){
        registerDao.deleteRegister(IDRegister);
    }

}
