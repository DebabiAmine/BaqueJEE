package com.example.DSBanque.MODEL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_OP",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long numero;
    @Getter @Setter
    private Date dateOperation;
    @Getter @Setter
    private double montant;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "CODE_CPT")
    private Compte compte;

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
}
