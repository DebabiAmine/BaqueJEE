package com.example.DSBanque.MODEL;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)/*heritage*/
@DiscriminatorColumn(name = "Type_CPT",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {
    public Compte(String codeCpte, Date dateCreation, double solde, Client client) {
        this.codeCpte = codeCpte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }

    public Compte() {
    }

    @Id
    @Getter @Setter
    private String codeCpte;
    @Getter @Setter
    private Date dateCreation;
    @Getter @Setter
    private double solde;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "Code_CLI")
    private Client client;
    @Getter @Setter
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;
}
