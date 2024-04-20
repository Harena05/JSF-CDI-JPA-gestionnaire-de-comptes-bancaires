/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.harena.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import static java.lang.System.gc;
import java.util.List;
import mg.harena.tpbanque.entity.CompteBancaire;
import mg.harena.tpbanque.entity.OperationBancaire;
import mg.harena.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author H
 */
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable {

    private int id;
    private CompteBancaire compteBancaire;
    @Inject
    private GestionnaireCompte gestionnaireCompte;
    private List<OperationBancaire> listeoperation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compteBancaire;
    }

    public void setCompte(CompteBancaire compte) {
        this.compteBancaire = compte;
    }

    public GestionnaireCompte getGestionnaireCompte() {
        return gestionnaireCompte;
    }

    public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
        this.gestionnaireCompte = gestionnaireCompte;
    }

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }

    public void loadCompte() {
        compteBancaire = gestionnaireCompte.getCompteById(id);
    }

    public List<OperationBancaire> getAllOperation(long id) {
        if (listeoperation == null) {
            listeoperation = gestionnaireCompte.getAllOperation(id);
        }
        return listeoperation;
    }

}
