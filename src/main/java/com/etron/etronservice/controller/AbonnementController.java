package com.etron.etronservice.controller;
import com.etron.etronservice.entities.Abonnement;
import com.etron.etronservice.entities.Utilisateurs;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.services.AbonnementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbonnementController {
    @Autowired
    private AbonnementServices service;

    @PostMapping("/abonnerUtilisateur")
    public Abonnement abonnerUtilisateur(@RequestBody Abonnement abonnement) { return service.saveAbonnement(abonnement); }

    @PostMapping("abonnerUtilisateurs")
    public List<Abonnement> abonnerUtilisateurs(@RequestBody List<Abonnement> abonnements) { return service.saveAbonnements(abonnements); }

    @GetMapping(value = "/findAbonnements")
    public List<Abonnement> getAllAbonnements() { return service.getAbonnements(); }

    @GetMapping("/findAbonnementById/{id}")
    public Abonnement getAbonnementByID(@PathVariable int id) throws RessourceNotFoundException { return service.getAbonnementByID(id); }

    @GetMapping("/findAbonnementByIdutilisateur/{id}")
    public Abonnement getAbonnementUserByID(@PathVariable int id) { return service.getAbonnementByIdUtilisateur(id); }

    @GetMapping("/findAbonnementsByIdoffre/{id}")
    public List<Abonnement> getAbonnementByIdoffre(@PathVariable int id) { return service.getAbonnementByIdOffre(id);}

    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) throws RessourceNotFoundException { return service.updateAbonnement(abonnement); }

    @DeleteMapping("/deleteAbonnementById/{id}")
    public String deleteAbonnement(@RequestBody Utilisateurs user , @PathVariable int id) throws RessourceNotFoundException
        {
            if(user.getTypeuser()=="ADMIN") {
                service.deleteAbonnement(id);
                return "Abonnement resilé avec succès";
            }

            return "Vous ne disposer pas des droits pour resilier cet abonnement"; }

    @PutMapping("/Resilierabonnement/{id}")
    public String resilierAbonnement(@RequestBody Utilisateurs user , @PathVariable int id) throws RessourceNotFoundException
    {
         if(user.getTypeuser()=="ADMIN") {
             service.ResilierAbonnement(id);
             return "Abonnement resilé avec succès";
         }
           return "Vous ne disposer pas des droits pour resilier cet abonnement";}


}
