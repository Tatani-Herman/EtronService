package com.etron.etronservice.services;

import com.etron.etronservice.exception.RessourceNotFoundException;
import org.springframework.stereotype.Service;
import com.etron.etronservice.entities.Utilisateurs;
import com.etron.etronservice.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UtilisateurServices {
    @Autowired
    private UtilisateurRepository repository;

    public Utilisateurs saveUtilisateur(Utilisateurs utilisateur) { return repository.save(utilisateur); }

    public List<Utilisateurs> saveUtilisateurs(List<Utilisateurs> utilisateurs) { return repository.saveAll(utilisateurs); }

    public List<Utilisateurs> getUtilisateurs() { return repository.findAll(); }

    public Utilisateurs getUtilisateurById(int id) throws RessourceNotFoundException { return repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("User not found for this id :" + id)); }

    public List<Utilisateurs> getUtilisateurByUsername(String username) { return  repository.findByUsername(username); }
    public List<Utilisateurs> getUtilisateurByTypeuser(String typeuser) { return  repository.findByTypeuser(typeuser); }

    public String deleteUtilisateur(int id) throws RessourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("User not found for this id :" + id));
        repository.deleteById(id);

        return "Utilisatuer <" + id + "> bien supprimé!!";
    }

    public Utilisateurs updateUtilisateur(Utilisateurs utilisateur) throws RessourceNotFoundException {
        Utilisateurs U = repository.findById(utilisateur.getIdutilisateur()).orElseThrow(() -> new RessourceNotFoundException("Voiture not found for this id :" + utilisateur.getIdutilisateur()));

        U.setAdresse(utilisateur.getAdresse());
        U.setPays(utilisateur.getPays());
        U.setDatenaissance(utilisateur.getDatenaissance());
        U.setEmail(utilisateur.getEmail());
        U.setNom(utilisateur.getNom());
        U.setPrenom(utilisateur.getPrenom());
        U.setPassword(utilisateur.getPassword());
        U.setIdvoiture(utilisateur.getIdvoiture());
        U.setTypeuser(utilisateur.getTypeuser());

        return repository.save(U);
    }
}
