package com.etron.etronservice.repositories;

import com.etron.etronservice.entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateurs,Integer> {
    List<Utilisateurs>findByUsername(String username);
    List<Utilisateurs>findByTypeuser(String typeuser);
}
