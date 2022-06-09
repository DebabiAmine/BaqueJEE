package com.example.DSBanque.Service;

import com.example.DSBanque.DAO.CompteRepository;
import com.example.DSBanque.DAO.OperationRepository;
import com.example.DSBanque.MODEL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BanqueMetierImpl implements IBanque {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCpte) {
        Compte cp;


        return cp = compteRepository.findById(codeCpte)
                .orElseThrow(() -> new RuntimeException("Compte Introuvable"));
    }

    @Override
    public Optional<Compte> findById(String codeCpte) {

        return compteRepository.findById(codeCpte);
    }

    @Override
    public void verser(String codeCpte, double montant) {
        if(findById(codeCpte).isPresent()){
            Optional<Compte> cp = findById(codeCpte);
            Versement v = new Versement(new Date() , montant, cp.get());
            operationRepository.save(v);
            cp.get().setSolde(cp.get().getSolde()+montant);
            compteRepository.save(cp.get());}

    }

    @Override
    public void retirer(String codeCpte, double montant) {
        Optional<Compte> cp = findById(codeCpte);
        if (findById(codeCpte).isPresent()) {
            if (cp.get() instanceof CompteCourant) {
                if (cp.get().getSolde() < montant) {
                    throw new RuntimeException("Solde insuffisant");

                } else {
                    Retrait r = new Retrait(new Date(), montant, cp.get());
                    operationRepository.save(r);
                    cp.get().setSolde(cp.get().getSolde() - montant);
                    compteRepository.save(cp.get());
                }
            }

        }
    }

    @Override
    public void virement(String codeCpte1, String codeCpte2, double montant) {
        if (codeCpte1.equals(codeCpte2))
            throw new RuntimeException("Operation impossible sur un même compte");


        retirer(codeCpte1,montant);
        verser(codeCpte2,montant);

    }
    /*@Override
    public Page<Operation> listOperation(String codeCompte, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return operationRepository.listOperation(codeCompte, paging) ;
    }*/


}
