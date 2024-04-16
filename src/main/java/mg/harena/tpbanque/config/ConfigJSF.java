/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.harena.tpbanque.config;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

/**
 *
 * @author H
 */
@Named(value = "configJSF")
@ApplicationScoped
@FacesConfig
public class ConfigJSF {

    /**
     * Creates a new instance of ConfigJSF
     */
    public ConfigJSF() {
    }
    
}
