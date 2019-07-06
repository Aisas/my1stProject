package com.example.newjpk;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDRegister")
    private long IDRegister;

    @Column(name="TransactionDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date TransactionDate;

    @ManyToOne
    @JoinColumn(name = "IdPayer")
    private TaxPayer payer;

    @ManyToOne
    @JoinColumn(name = "IdSupplier")
    private TaxPayer supplier;

    @Column(name="Inv_Nr")
    private String invNr;

    @Column(name="VAT_YN")
    private String ifVAT;

    @Column(name="Descript")
    private String description;

    @Column(name="Income_Cost_IC")
    private String incomeOrCost;

    @Column(name="FixedAsset_YN")
    private String ifFA;

    @Column(name="Currency")
    private String cur;

    @Column(name="Netto")
    private int netto;

    @Column(name="VAT")
    private int vat;

    @Column(name="Brutto")
    private int brutto;

    public long getIDRegister() {
        return IDRegister;
    }

    public void setIDRegister(long IDRegister) {
        this.IDRegister = IDRegister;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public TaxPayer getPayer() {
        return payer;
    }

    public void setPayer(TaxPayer payer) {
        this.payer = payer;
    }

    public TaxPayer getSupplier() {
        return supplier;
    }

    public void setSupplier(TaxPayer supplier) {
        this.supplier = supplier;
    }

    public String getInvNr() {
        return invNr;
    }

    public void setInvNr(String invNr) {
        this.invNr = invNr;
    }

    public String getIfVAT() {
        return ifVAT;
    }

    public void setIfVAT(String ifVAT) {
        this.ifVAT = ifVAT;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncomeOrCost() {
        return incomeOrCost;
    }

    public void setIncomeOrCost(String incomeOrCost) {
        this.incomeOrCost = incomeOrCost;
    }

    public String getIfFA() {
        return ifFA;
    }

    public void setIfFA(String ifFA) {
        this.ifFA = ifFA;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public int getNetto() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto = netto;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getBrutto() {
        return brutto;
    }

    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }

    @Override
    public String toString() {
        return "Register{" +
                "IDRegister=" + IDRegister +
                ", TransactionDate=" + TransactionDate +
                ", payer=" + payer +
                ", supplier=" + supplier +
                ", invNr='" + invNr + '\'' +
                ", ifVAT='" + ifVAT + '\'' +
                ", description='" + description + '\'' +
                ", incomeOrCost='" + incomeOrCost + '\'' +
                ", ifFA='" + ifFA + '\'' +
                ", cur='" + cur + '\'' +
                ", netto=" + netto +
                ", vat=" + vat +
                ", brutto=" + brutto +
                '}';
    }
}
