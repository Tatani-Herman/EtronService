/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etron.etronservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "VOITURES")
public class Voitures{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVOITURE")
    private Integer idvoiture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MODELE")
    private String modele;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COULEUR")
    private String couleur;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @JsonIgnore
    @OneToOne(mappedBy = "idvoiture")
    private Utilisateurs utilisateurs;


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voitures)) {
            return false;
        }
        Voitures other = (Voitures) object;
        if ((this.idvoiture == null && other.idvoiture != null) || (this.idvoiture != null && !this.idvoiture.equals(other.idvoiture))) {
            return false;
        }
        return true;
    }
    
}
