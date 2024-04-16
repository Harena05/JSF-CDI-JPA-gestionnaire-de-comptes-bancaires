/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.harena.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.harena.tpbanque.entity.CompteBancaire;
import mg.harena.tpbanque.service.GestionnaireCompte;
import mg.harena.tpbanque.util.Util;

/**
 *
 * @author H
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @Inject
    GestionnaireCompte gc;

    private List<CompteBancaire> listeCompte;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (listeCompte == null) {
            listeCompte = gc.getAllComptes();
        }
        return listeCompte;
    }
    
    public String supprimerCompte(CompteBancaire cb){
        //CompteBancaire cb = gc.getCompteById(id);
        gc.supprimer(cb);
        Util.addFlashInfoMessage("suppression effectué");
        return "listeComptes";
    }

}
