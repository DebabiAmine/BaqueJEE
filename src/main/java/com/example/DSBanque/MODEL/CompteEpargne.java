package com.example.DSBanque.MODEL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;





@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {


    @Getter @Setter
    private double Tx_Inter;

    public CompteEpargne() {
    }

    public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double tx_Inter) {
        super(codeCompte, dateCreation, solde, client);
        this.Tx_Inter = tx_Inter;
    }

}
