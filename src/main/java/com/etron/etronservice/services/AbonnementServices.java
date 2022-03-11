package com.etron.etronservice.services;
import com.etron.etronservice.entities.Abonnement;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.repositories.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AbonnementServices {

    @Autowired
    private AbonnementRepository repository;

    public Abonnement saveAbonnement(Abonnement abonnement) {
        return  repository.save(abonnement); }

    public List<Abonnement> saveAbonnements(List<Abonnement> abonnements) { return repository.saveAll(abonnements); }

    public List<Abonnement> getAbonnements() { return repository.findAll(); }

    public Abonnement getAbonnementByID(int id) throws RessourceNotFoundException { return repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Abonnement not found for this id :: " + id));}

    public Abonnement getAbonnementByIdUtilisateur(int idutilisateur) { return repository.findByIdutilisateur(idutilisateur); }

    public List<Abonnement> getAbonnementByIdOffre(int idoffre) { return repository.findByIdoffre(idoffre); }

    public String deleteAbonnement(int id) throws RessourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Abonnement not found for this id :: " + id));
        repository.deleteById(id);

        return "Abonnement <" + id + "> bien supprimé!!";
    }

    public Abonnement ResilierAbonnement(int id) throws RessourceNotFoundException {
        Abonnement A = repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Abonnement not found for this id :: " + id));
        A.setStatut("RESILIE");
        return repository.save(A);

    }

    public Abonnement updateAbonnement(Abonnement abonnement) throws RessourceNotFoundException {
        Abonnement A = repository.findById(abonnement.getIdabonnement()).orElseThrow(() -> new RessourceNotFoundException("Abonnement not found for this id :: " + abonnement.getIdabonnement()));

        if(abonnement.getIdoffre() != null) A.setIdoffre(abonnement.getIdoffre());
        A.setStatut(abonnement.getStatut());

        return repository.save(A);
    }

}
