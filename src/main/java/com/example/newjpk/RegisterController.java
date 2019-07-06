package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    @Qualifier("registerService")
    private RegisterService registerService;

    @PostMapping("/api/createregister")
    public void createNewregister(@Valid @RequestBody Register register) {
        registerService.addRegister(register);
    }

    @PutMapping("/api/changeRegister")
    public void changeExistingRegister(@Valid @RequestBody Register register) {
        registerService.modifyRegister(register);
    }

    @DeleteMapping("/api/removeRegister/{id}")
    public void removeRegister(@PathVariable(value = "id") long IDRegister){
        registerService.removeRegister(IDRegister);
    }

    @GetMapping("/api/viewsingleRegister/{id}")
    public Register viewRegisterById(@PathVariable(value="id") long IDRegister){
        return registerService.getRegisterById(IDRegister);
    }

    @GetMapping("/api/viewAllRegister")
    public List<Register> viewAllRegister(){
        return  registerService.getAllRegister();
    }

}
