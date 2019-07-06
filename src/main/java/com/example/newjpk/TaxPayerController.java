package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaxPayerController {

    @Autowired
    @Qualifier("taxPayerService")
    private TaxPayerService taxPayerService;

    @PostMapping("/api/createTaxPayer")
    public void createNewTaxPayer(@Valid @RequestBody TaxPayer taxPayer) {
        taxPayerService.addTaxPayer(taxPayer);
    }

    @PutMapping("/api/changeTaxPayer")
    public void changeExistingTaxPayer(@Valid @RequestBody TaxPayer taxPayer) {
        taxPayerService.modifyTaxPayer(taxPayer);
    }
    @DeleteMapping("/api/removeTaxPayer/{id}")
    public void removeTaxPayer(@PathVariable(value = "id") long IdTaxPayer){
        taxPayerService.removeTaxPayer(IdTaxPayer);
    }

    @GetMapping("/api/viewsingleTaxPayer/{id}")
    public TaxPayer viewTaxPayerById(@PathVariable(value="id") long IdTaxPayer){
        return taxPayerService.getTaxPayerById(IdTaxPayer);
    }

    @GetMapping("/api/viewallTaxPayer")
    public List<TaxPayer> viewAllTaxPayer() {
        return taxPayerService.getAllTaxPayer();
    }

}
