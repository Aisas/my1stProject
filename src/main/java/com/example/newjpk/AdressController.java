package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdressController {

    @Autowired
    @Qualifier("adressService")
    private AdressService adressService;

    @PostMapping("/api/createAdress")
    public void createNewAdress(@Valid @RequestBody Adress adress) {
        adressService.addAdress(adress);
    }
    @PutMapping("/api/changeAdress")
    public void changeExistingAress(@Valid @RequestBody Adress adress) {
        adressService.modifyAdress(adress);
    }

    @DeleteMapping("/api/removeAdress/{id}")
    public void removeAdress(@PathVariable(value = "id") long idAdress) {
        adressService.removeAdress(idAdress);
    }

    @GetMapping("/api/viewsingleAdress/{id}")
    public Adress viewAdressById(@PathVariable(value="id") long idAdress){
            return adressService.getAdressById(idAdress);
        }

    @GetMapping("/api/viewAllAdress")
    public List<Adress> viewAllAdress(){
    return adressService.getAllAdress();}


}
