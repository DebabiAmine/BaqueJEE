package com.example.DSBanque.MODEL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

    @Getter @Setter
    private double decouvert;

    public CompteCourant() {
    }

    public CompteCourant(String codeCpte, Date dateCreation, double solde, Client client, double decouvert) {
        super(codeCpte, dateCreation, solde, client);
        this.decouvert = decouvert;
    }


}
