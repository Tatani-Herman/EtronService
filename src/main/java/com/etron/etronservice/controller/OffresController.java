package com.etron.etronservice.controller;
import com.etron.etronservice.entities.Offres;
import com.etron.etronservice.exception.RessourceNotFoundException;
import com.etron.etronservice.services.OffresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OffresController {
    @Autowired
    private OffresServices service;

    @PostMapping( "/addOffre/{codeSecret}")
    public String addOffre(@PathVariable int codeSecret, @RequestBody Offres offre) {
        if(codeSecret ==12345){
        service.saveOffre(offre);
        return "Offre bien ajoutée";}
    return "Vous ne diposez pas des droits necessaires";}

    @GetMapping("/findOffres")
    public List<Offres> findAllOffres() { return service.getOffres(); }

    @GetMapping("/findOffreById/{id}")
    public Offres findOffreByID(@PathVariable int id) throws RessourceNotFoundException { return service.getOffreById(id); }

    @GetMapping("findOffreByType/{type}")
    public List<Offres> findOffreByType(@PathVariable String type) { return service.getOffresByType(type); }

    @PutMapping("/UpdateOffre/{codeSecret}")
    public String updateOffre(@PathVariable int codeSecret,@RequestBody Offres offre) throws RessourceNotFoundException {
        if(codeSecret ==12345){
            service.updateOffre(offre);
            return "Offre bien mise à jour";
        }
    return "vous ne disposez pas des droits necessaires";}

    @DeleteMapping("/deleteOffrebyId/{codeSecret}/{id}")
    public String deleteOffre(@PathVariable int id, @PathVariable int codeSecret) throws RessourceNotFoundException {
        if(codeSecret ==12345){
        service.deleteOffre(id);
        return "Offre bien supprimée";}
        return "vous ne disposez pas des droits necessaires";}
}
