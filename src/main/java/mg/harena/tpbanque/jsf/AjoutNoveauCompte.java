/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.harena.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.harena.tpbanque.service.GestionnaireCompte;
import mg.harena.tpbanque.util.Util;

/**
 *
 * @author H
 */
@Named(value = "ajoutNoveauCompte")
@RequestScoped
public class AjoutNoveauCompte {

    private String nom;
    private int solde;

    @Inject
    GestionnaireCompte gc;

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

    /**
     * Creates a new instance of AjoutNoveauCompte
     */
    public AjoutNoveauCompte() {
    }

    public String ajoutCompte() {

        gc.ajoutCompte(nom, solde);
        Util.addFlashInfoMessage("Nouveau compte ajouter avec succes");
        return "listeComptes";
    }

}
