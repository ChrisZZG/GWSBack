/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Dto;

/**
 *
 * @author EQUIPO
 */
public class dtoEducacion {
    
    private String tituloE;
    private String institucionE;
    private String descripcionE;
    private String urlE;

    public dtoEducacion() {
    }

    public dtoEducacion(String tituloE, String institucionE, String descripcionE, String urlE) {
        this.tituloE = tituloE;
        this.institucionE = institucionE;
        this.descripcionE = descripcionE;
        this.urlE = urlE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }

    public String getInstitucionE() {
        return institucionE;
    }

    public void setInstitucionE(String institucionE) {
        this.institucionE = institucionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUrlE() {
        return urlE;
    }

    public void setUrlE(String urlE) {
        this.urlE = urlE;
    }

    
    
}
