package com.example.DSBanque.Service;

import com.example.DSBanque.MODEL.Compte;
import com.example.DSBanque.MODEL.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IBanque {
    public Compte consulterCompte(String codeCpte);
    public void verser(String codeCpte,double montant);
    public void retirer(String codeCpte,double montant);
    public void virement(String codeCpte1,String codeCpte2,double montant);
    //public Page<Operation> listOperation(String codeCpte, int page, int sizePage);
    //public Page<Operation> listOperation(String codeCpte, int page, int sizePage);
    Optional<Compte> findById(String id);

}
