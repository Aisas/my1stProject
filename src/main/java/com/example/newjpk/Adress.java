package com.example.newjpk;
import javax.persistence.*;

@Entity
@Table(name="adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IdAdress")
    //private int IdAdres;
    private long IdAdres;

    @ManyToOne
    @JoinColumn(name = "IdTaxPayer")
    private TaxPayer taxPayer;

    @Column(name="Street")
    private String Street;

    @Column(name="CityCode")
    private String CityCode;

    @Column(name="City")
    private String City;

    public long getIdAdres() {
        return IdAdres;
    }

    public void setIdAdres(long idAdres) {
        IdAdres = idAdres;
    }

    public TaxPayer getTaxPayer() {
        return taxPayer;
    }

    public void setTaxPayer(TaxPayer taxPayer) {
        this.taxPayer = taxPayer;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "IdAdres=" + IdAdres +
                ", taxPayer=" + taxPayer +
                ", Street='" + Street + '\'' +
                ", CityCode='" + CityCode + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
