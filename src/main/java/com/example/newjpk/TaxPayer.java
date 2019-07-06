package com.example.newjpk;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TaxPayer")
public class TaxPayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IdTaxPayer")
    private long IdTaxPayer;

    @OneToMany(mappedBy = "payer")
    private List<Register> payer  = new ArrayList<Register>();
    @OneToMany(mappedBy = "supplier")
    private List<Register> supplier  = new ArrayList<Register>();
    @OneToMany(mappedBy = "taxPayer")
    private List<Adress> idAdress  = new ArrayList<Adress>();
    //@OneToOne(mappedBy = "IdtaxPayer")
    //private User user;

    @Column(name="NIP")
    private int NIP;

    @Column(name="Name_Surname")
    private String Name_Surname;

    @Column(name="FirstName")
    private String FirstName;


    public long getIdTaxPayer() {
        return IdTaxPayer;
    }

    public void setIdTaxPayer(long idTaxPayer) {
        IdTaxPayer = idTaxPayer;
    }

    public List<Register> getPayer() {
        return payer;
    }

    public void setPayer(List<Register> payer) {
        this.payer = payer;
    }

    public List<Register> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<Register> supplier) {
        this.supplier = supplier;
    }

    public List<Adress> getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(List<Adress> idAdress) {
        this.idAdress = idAdress;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public String getName_Surname() {
        return Name_Surname;
    }

    public void setName_Surname(String name_Surname) {
        Name_Surname = name_Surname;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "IdTaxPayer=" + IdTaxPayer +
                ", payer=" + payer +
                ", supplier=" + supplier +
                ", idAdress=" + idAdress +
                //", user=" + user +
                ", NIP=" + NIP +
                ", Name_Surname='" + Name_Surname + '\'' +
                ", FirstName='" + FirstName + '\'' +
                '}';
    }
}
