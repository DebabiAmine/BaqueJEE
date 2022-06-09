package com.example.DSBanque.MODEL;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long codeC;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private String mail;

    @Getter @Setter
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client() {
    }

    public Client(String nom,String mail) {
        this.nom = nom;
        this.mail = mail;
    }
}
