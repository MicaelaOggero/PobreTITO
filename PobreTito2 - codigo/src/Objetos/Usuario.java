/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

//clase entidad

import java.util.List;




public class Usuario {
    private String cuil;
    private String nombre;
    private String apellido;
    private String contraseña;
    private List<Requerimiento> listaRequerimiento;
    
    public Usuario(){
        System.out.println("Se creo usuario");
    }

    public Usuario(String cuil, String nombre, String apellido, String contraseña) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }
    
    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the listaRequerimiento
     */
    public List<Requerimiento> getListaRequerimiento() {
        return listaRequerimiento;
    }

    /**
     * @param listaRequerimiento the listaRequerimiento to set
     */
    public void setListaRequerimiento(List<Requerimiento> listaRequerimiento) {
        this.listaRequerimiento = listaRequerimiento;
    }
    
    
}
