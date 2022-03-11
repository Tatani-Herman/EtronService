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

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "ABONNEMENT")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idabonnement;
    @Basic(optional = false)
    @NotNull
    private String dateabonnement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String statut;
    @JsonIgnore
    @JoinColumn(name = "IDOFFRE", referencedColumnName = "IDOFFRE")
    @ManyToOne(optional = false)
    private Offres idoffre;
    @JoinColumn(name = "IDUTILISATEUR")
    @OneToOne(cascade = CascadeType.ALL,optional = false)
    private Utilisateurs idutilisateur;





    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if ((this.idabonnement == null && other.idabonnement != null) || (this.idabonnement != null && !this.idabonnement.equals(other.idabonnement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Abonnement[ idabonnement=" + idabonnement + " ]";
    }
    
}
