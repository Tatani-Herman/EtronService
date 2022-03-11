package com.etron.etronservice.controller;
import com.etron.etronservice.entities.Utilisateurs;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurServices service;

    @PostMapping("/inscrireClient")
    public String inscrireClient(@RequestBody Utilisateurs utilisateur) {
        if(utilisateur.getTypeuser()!=null && utilisateur.getEmail()!=null & utilisateur.getPassword()!=null && utilisateur.getUsername()!=null)
        {service.saveUtilisateur(utilisateur);
        return "Client bien inscrit !!";}
    return "Informations de client manquants, veuillez réessayer!!";}

    @PostMapping("/inscrireClients")
    public List<Utilisateurs> inscrireClients(@RequestBody List<Utilisateurs> utilisateurs) { return service.saveUtilisateurs(utilisateurs); }

    @GetMapping("/findutilisateurs")
    public List<Utilisateurs> findAllUtilisateurs() { return service.getUtilisateurs(); }

    @GetMapping("/findUtilisateurById/{id}")
    public Utilisateurs findUtilisateurByID(@PathVariable int id) throws RessourceNotFoundException { return service.getUtilisateurById(id); }

    @GetMapping("findUtilisateurByUsername/{username}")
    public List<Utilisateurs> findUtilisateurByUsername(@PathVariable String username) { return service.getUtilisateurByUsername(username); }

    @GetMapping("findUtilisateurByTypeuser/{typeuser}")
    public List<Utilisateurs> findUtilisateurByTypeuser(@PathVariable String typeuser) { return service.getUtilisateurByTypeuser(typeuser); }

    @PutMapping("/updateUtilisateur")
    public Utilisateurs updateUtilisateur(@RequestBody Utilisateurs utilisateur) throws RessourceNotFoundException { return service.updateUtilisateur(utilisateur); }

    @DeleteMapping("/deleteUtilisateurById/{id}")
    public String deleteUtilisateur(@PathVariable int id) throws RessourceNotFoundException { return service.deleteUtilisateur(id); }
}
