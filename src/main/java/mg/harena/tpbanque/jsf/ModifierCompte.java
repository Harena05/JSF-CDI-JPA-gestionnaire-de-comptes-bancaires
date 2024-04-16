/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.harena.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.harena.tpbanque.entity.CompteBancaire;
import mg.harena.tpbanque.service.GestionnaireCompte;
import mg.harena.tpbanque.util.Util;

/**
 *
 * @author H
 */
@Named(value = "modifierCompte")
@RequestScoped
public class ModifierCompte {

    private int id;
    private String nom;
    private int solde;
    private CompteBancaire compte;
    private String error = "";

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getError() {
        return error;
    }

    /**
     * Creates a new instance of Modification
     */
    public ModifierCompte() {
    }

    public void loadCompte() {
        compte = gestionnaireCompte.getCompteById(id);
        this.nom = compte.getNom();
        this.solde = compte.getSolde();
    }

    public String modif() {
        String anciennom = nom;
        int ancienSolde = solde;
        String erreur = "";
        if ("".equals(nom) || nom == null) {
            error += "solde invalide";
        }
        if ("".equals(solde)) {
            error += "solde invalide";
        }
        if (!"".equals(erreur)) {
            error = erreur;
            return null;
        }
        compte = gestionnaireCompte.getCompteById(id);
        compte.setNom(nom);
        compte.setSolde(solde);
        gestionnaireCompte.updateCompte(compte);

        Util.addFlashInfoMessage("Nom  " + anciennom + "changé  en " + compte.getNom());

        Util.addFlashInfoMessage("Solde " + ancienSolde + " changé en " + compte.getSolde());

        return "listeComptes";
    }

}
