package com.simplon.dvdstore.repositories.clients;

import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="client")
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémente
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "address")
    private String address;

    // Mapper avec nom propriété "clientRepositoryModel" de la classe "ModelVenteRepositoryModel"
    @OneToMany(mappedBy = "clientRepositoryModel", orphanRemoval = true)
    private Set<VenteRepositoryModel> venteRepositoryModels = new LinkedHashSet<>();

    @OneToMany(mappedBy = "clientRepositoryModel", orphanRemoval = true)
    private Set<VenteRepositoryModel> testventeRepositoryModels = new LinkedHashSet<>();

    public ClientRepositoryModel(String lastname, String firstname, String address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public ClientRepositoryModel( Long id,String lastname,String firstname,String address){
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }


}
