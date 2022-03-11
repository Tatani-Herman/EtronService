package com.etron.etronservice.repositories;

import com.etron.etronservice.entities.Voitures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voitures, Integer> {
    List<Voitures>findByModele(String modele);
}
