package com.apiodkpointage.apiodkpointage.log;

import com.apiodkpointage.apiodkpointage.administrateurs.Administrateur;
import com.apiodkpointage.apiodkpointage.utilisateurs.Utilisateur;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonBackReference
    private Administrateur administrateur;

    private String action;

    private String typeActeur;
    private String nomComplet;

    private LocalDate date = LocalDate.now();
    private  LocalTime heure = LocalTime.now();

    public Log() {
    }

    public Log(Utilisateur utilisateur, Administrateur administrateur, String action, String typeActeur, String nomComplet, LocalDate date, LocalTime heure) {
        this.utilisateur = utilisateur;
        this.administrateur = administrateur;
        this.action = action;
        this.date = date;
        this.heure = heure;
        this.typeActeur = typeActeur;
        this.nomComplet = nomComplet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTypeActeur() {
        return typeActeur;
    }

    public void setTypeActeur(String typeActeur) {
        this.typeActeur = typeActeur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }
}
