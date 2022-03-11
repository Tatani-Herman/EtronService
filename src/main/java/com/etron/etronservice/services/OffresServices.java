package com.etron.etronservice.services;


import com.etron.etronservice.entities.Offres;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.repositories.OffresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OffresServices {
    @Autowired
    private OffresRepository repository;

    public Offres saveOffre(Offres offre) { return repository.save(offre); }

    public List<Offres> saveOffres(List<Offres> offres) { return repository.saveAll(offres); }

    public List<Offres> getOffres() { return repository.findAll(); }

    public Offres getOffreById(int id) throws RessourceNotFoundException { return repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Offre not found for this id :: " + id));
    }

    public List<Offres> getOffresByType(String type) { return repository.findByTypeoffre(type); }

    public String deleteOffre(int id) throws RessourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Offre not found for this id :: " + id));
        repository.deleteById(id);

        return "Offre <" + id + "> bien supprimé!!";
    }

    public Offres updateOffre(Offres offre) throws RessourceNotFoundException {
        Offres O = repository.findById(offre.getIdoffre()).orElseThrow(() -> new RessourceNotFoundException("Offre not found for this id :: " + offre.getIdoffre()));
            O.setTypeoffre(offre.getTypeoffre());
            O.setFraisbase(offre.getFraisbase());
            O.setFraischargeminute22(offre.getFraischargeminute22());
            O.setFraischargeminute50(offre.getFraischargeminute50());
            O.setFraischargeminute150(offre.getFraischargeminute150());
            return repository.save(O);
    }
}
