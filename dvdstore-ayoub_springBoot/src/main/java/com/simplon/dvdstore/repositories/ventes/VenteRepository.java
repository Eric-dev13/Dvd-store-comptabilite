package com.simplon.dvdstore.repositories.ventes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface VenteRepository extends CrudRepository<VenteRepositoryModel, Long> {

    ArrayList<VenteRepositoryModel> findAll();

    @Query("SELECT v FROM VenteRepositoryModel v WHERE v.clientRepositoryModel.id = :id")
    ArrayList<VenteRepositoryModel> findAllVenteByClient(Long id);

}