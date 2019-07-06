package com.example.newjpk;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdUser;

    @OneToOne
    @JoinColumn(name = "IdTaxPayer")
    private TaxPayer taxPayer;

    @Column(name="Login")
    @NotBlank(message = "Username is required.")
    private String login;

    @Column(name="Email")
    @NotBlank(message = "Email is required.")
    private String email;

    @Column(name="Password")
    private String password;

    public long getIdUser() {
        return IdUser;
    }

    public void setId(Long id) {
        this.IdUser = id;
    }

    public TaxPayer getTaxPayer() {
        return taxPayer;
    }

    public void setTaxPayer(TaxPayer taxPayer) {
        this.taxPayer = taxPayer;
    }

    public void setIdUser(long idUser) {
        IdUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "IdUser=" + IdUser +
                ", taxPayer=" + taxPayer +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}