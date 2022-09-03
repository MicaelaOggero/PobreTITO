/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Requerimiento implements Serializable {

    private String descripcion;
    private String opcion1;
    private String opcion2;
    private String comentario;
    private String barrio;
    private String calle;
    private String numero;
    private byte[] imagen;
    private String cuil;
    private String localidad;

    public Requerimiento() {
        System.out.println("se creo requerimiento");
    }

    public Requerimiento(String descripcion, String opcion1, String opcion2, String comentario, String barrio, String calle, String numero, byte[] imagen, String cuil, String localidad) {
        this.descripcion = descripcion;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.comentario = comentario;
        this.barrio = barrio;
        this.calle = calle;
        this.numero = numero;
        this.imagen = imagen;
        this.cuil = cuil;
        this.localidad = localidad;

    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the opcion1
     */
    public String getOpcion1() {
        return opcion1;
    }

    /**
     * @param opcion1 the opcion1 to set
     */
    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    /**
     * @return the opcion2
     */
    public String getOpcion2() {
        return opcion2;
    }

    /**
     * @param opcion2 the opcion2 to set
     */
    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the barrio
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * @param barrio the barrio to set
     */
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the cuil
     */
    public String getCuil() {
        return cuil;
    }

    /**
     * @param cuil the cuil to set
     */
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    /**
     * @return the fecha
     */
}
