package com.etron.etronservice.repositories;

import com.etron.etronservice.entities.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffresRepository extends JpaRepository<Offres,Integer> {
    List<Offres> findByTypeoffre(String type);
}
