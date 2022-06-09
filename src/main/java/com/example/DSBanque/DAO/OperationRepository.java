package com.example.DSBanque.DAO;

import com.example.DSBanque.MODEL.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OperationRepository extends JpaRepository<Operation,Long> {
    /*@Query("select o from Operation o where o.compte.codeCompte=:x ")
    public Page<Operation> listOperation ( @Param("x") String codeCpte,Pageable pageable);*/

    /*@Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
    Page<Operation> listOperation(@Param("x") String codeCpte, Pageable pageable );*/


}
