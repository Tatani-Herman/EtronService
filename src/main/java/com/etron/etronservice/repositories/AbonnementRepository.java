package com.etron.etronservice.repositories;

import com.etron.etronservice.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Integer> {
    Abonnement findByIdutilisateur(int idutilisateur);
    List<Abonnement> findByIdoffre(int idoffre);
}
