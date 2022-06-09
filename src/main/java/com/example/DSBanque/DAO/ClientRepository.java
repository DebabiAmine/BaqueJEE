package com.example.DSBanque.DAO;

import com.example.DSBanque.MODEL.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
