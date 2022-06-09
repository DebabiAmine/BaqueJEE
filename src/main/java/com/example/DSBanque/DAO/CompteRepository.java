package com.example.DSBanque.DAO;

import com.example.DSBanque.MODEL.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,String> {
   // public void findOne(String codeCpte);

    //@Query("SELECT a FROM AccountEntity a WHERE a.id =? 1")
    //public Compte findOne(String id);
}
