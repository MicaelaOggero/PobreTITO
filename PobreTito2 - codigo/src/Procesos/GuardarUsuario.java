/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Conexiones.Conexion;
import Objetos.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;

public class GuardarUsuario {
   
    Conexion c;
    
    public GuardarUsuario(){
        c=new Conexion();
    }
    
    public boolean guardarUsuario(Usuario usuario){
        
        try {
            String sql="INSERT INTO usuarios(cuil,nombre,apellido,contraseña) values (?,?,?,?)";
            PreparedStatement ps=c.conectar().prepareStatement(sql);
            ps.setString(1, usuario.getCuil());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getContraseña());
            ps.execute();
            ps.close();
            ps=null;
            
            c.desconectar();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("No se inserto registro "+ex);
            return false;
        }

    }
    
    public boolean validarAcceso(Usuario u){
        
        try{
            String sql="select * from usuarios where cuil='"+u.getCuil()+"' and contraseña ='"+u.getContraseña()+"'";
            PreparedStatement ps=c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
            else{
                System.out.println("Datos incorrectos");
                return false;
            }
        }catch(Exception e){
            System.out.println("Problema: "+e);
            return false;
            
        }
             
    }
}

