package com.etron.etronservice.controller;

import com.etron.etronservice.entities.Voitures;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.services.VoituresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VoituresController {

    @Autowired
    private VoituresServices service;

    @PostMapping("/addVoiture")
    public Voitures addVoiture(@RequestBody Voitures voiture) {
        return service.saveVoiture(voiture);
    }

    @PostMapping("/addVoitures")
    public List<Voitures> addVoitures(@RequestBody List<Voitures> voitures) {
        return service.saveVoitures(voitures);
    }

    @GetMapping("/findVoitures")
    public List<Voitures> findAllVoitures() {
        return service.getVoitures();
    }

    @GetMapping("/findVoitureById/{id}")
    public Voitures findVoitureById(@PathVariable int id) throws RessourceNotFoundException {
        return service.getVoituresById(id);
    }

    @GetMapping("/findVoituresByModele/{modele}")
    public List<Voitures> findVoitureByModele(@PathVariable String modele) {
        return service.getVoituresByModele(modele);
    }

    @PutMapping("/updateVoiture")
    public Voitures updateVoiture(@RequestBody Voitures voiture) throws RessourceNotFoundException {
        return service.updateVoiture(voiture);
    }

    @DeleteMapping("/deleteVoitureById/{id}")
    public String deleteVoiture(@PathVariable int id) throws RessourceNotFoundException {
        return service.deleteVoiture(id);
    }
}
