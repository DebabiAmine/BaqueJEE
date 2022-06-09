package com.example.DSBanque;

import com.example.DSBanque.DAO.ClientRepository;
import com.example.DSBanque.DAO.CompteRepository;
import com.example.DSBanque.DAO.OperationRepository;
import com.example.DSBanque.MODEL.*;
import com.example.DSBanque.Service.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Date;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DsBanqueApplication implements CommandLineRunner {

	public static void main(String[] args) {
		//1er methode
		/*ApplicationContext ctx= SpringApplication.run(DsBanqueApplication.class, args);
		ClientRepository clientRepository=ctx.getBean(ClientRepository.class);
		clientRepository.save(new Client("amine"));*/
		SpringApplication.run(DsBanqueApplication.class, args);
	}
	//2eme methode
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanque iBanque;
	@Override
	public void run(String... args) throws Exception {
		/*Client c1=clientRepository.save(new Client("amine","amine@sesame.com"));
		Client c2=clientRepository.save(new Client("amine","amine@sesame.com"));

		Compte cp1 = compteRepository.save(new CompteCourant("c1",new Date(),90000,c1,6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5));


		operationRepository.save(new Versement(new Date(),9000,cp1));
		operationRepository.save(new Versement(new Date(),6000,cp1));
		operationRepository.save(new Versement(new Date(),2300,cp1));
		operationRepository.save(new Retrait(new Date(),9000,cp1));


		operationRepository.save(new Versement(new Date(),2300,cp2));
		operationRepository.save(new Versement(new Date(),6000,cp2));
		operationRepository.save(new Versement(new Date(),2300,cp2));
		operationRepository.save(new Retrait(new Date(),9000,cp2));


		iBanque.verser("c1",11111);*/


	}
}
