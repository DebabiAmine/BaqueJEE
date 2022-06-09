package com.example.DSBanque.CONTROLLER;


import com.example.DSBanque.MODEL.Compte;
import com.example.DSBanque.MODEL.Operation;
import com.example.DSBanque.Service.BanqueMetierImpl;
import com.example.DSBanque.Service.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class BanqueController {

    @Autowired
    private IBanque iBanque;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

    @RequestMapping("/consultercompte")
    public String consulter(Model model,String codeCompte){

        model.addAttribute("codeCompte",codeCompte);
        try {
            Compte cp=iBanque.consulterCompte(codeCompte);


            model.addAttribute("compte",cp);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "comptes";
    }
    @RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
    public String saveOperation(Model model,String typeOperation , String codeCompte , double montant , String codeCompte2){
        try {
            if (typeOperation.equals("vers")){
                iBanque.verser(codeCompte,montant);
            }
            else if(typeOperation.equals("retr")){
                iBanque.retirer(codeCompte,montant);
            }
            else if(typeOperation.equals("vir")){
                iBanque.virement(codeCompte,codeCompte2,montant);
            }
        }catch (Exception e){

            model.addAttribute("error",e);
            return "redirect:/consultercompte?codeCompte="+codeCompte+"&error="+e.getMessage();
        }

        return "redirect:/consultercompte?codeCompte="+codeCompte;
    }
}
