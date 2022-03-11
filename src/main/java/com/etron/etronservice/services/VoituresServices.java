package com.etron.etronservice.services;

import com.etron.etronservice.entities.Voitures;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoituresServices {

    @Autowired
    private VoitureRepository repository;

    public Voitures saveVoiture(Voitures voiture){
        return repository.save(voiture);
    }

    public List<Voitures> saveVoitures(List<Voitures> voitures){
        return repository.saveAll(voitures);
    }

    public List<Voitures> getVoitures(){
        return repository.findAll();
    }

    public Voitures getVoituresById(int id) throws RessourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Voiture not found for this id :" + id));
    }

    public List<Voitures> getVoituresByModele(String modele){
        return repository.findByModele(modele);
    }

    public String deleteVoiture(int id) throws RessourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Voiture not found for this id :" + id));
        repository.deleteById(id);
        return "Voiture "+id+" bien supprimé!!";
    }

    public Voitures updateVoiture(Voitures voiture) throws RessourceNotFoundException {
        Voitures V = repository.findById(voiture.getIdvoiture()).orElseThrow(() -> new RessourceNotFoundException("Voiture not found for this id :" + voiture.getIdvoiture()));
        V.setCouleur(voiture.getCouleur());
        V.setDescription(voiture.getDescription());
        V.setModele(voiture.getModele());
        return repository.save(V);
    }
}
