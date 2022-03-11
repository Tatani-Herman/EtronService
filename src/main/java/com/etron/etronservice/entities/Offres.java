/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etron.etronservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "OFFRES")
public class Offres{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDOFFRE")
    private Integer idoffre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TYPE", unique = true)
    private String typeoffre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRAISBASE")
    private double fraisbase;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FRAISCHARGEMINUTE22")
    private Double fraischargeminute22;
    @Column(name = "FRAISCHARGEMINUTE50")
    private Double fraischargeminute50;
    @Column(name = "FRAISCHARGEMINUTE150")
    private Double fraischargeminute150;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoffre")
    private Collection<Abonnement> abonnementCollection;


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offres)) {
            return false;
        }
        Offres other = (Offres) object;
        if ((this.idoffre == null && other.idoffre != null) || (this.idoffre != null && !this.idoffre.equals(other.idoffre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Offres[ idoffre=" + idoffre + " ]";
    }

}
