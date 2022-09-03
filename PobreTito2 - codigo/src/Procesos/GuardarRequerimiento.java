/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Conexiones.Conexion;
import Interfaces.InterfazFinal;
import Objetos.Requerimiento;
import Objetos.Usuario;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class GuardarRequerimiento {
    
    Conexion c;
    
    public GuardarRequerimiento(){
        c=new Conexion();
    }
    
    public boolean guardarRequerimiento(Requerimiento requerimiento, FileInputStream fis, int longitudBytes){
        
        try {
            String sql="INSERT INTO historial(descripcion, opcion1, opcion2, localidad, barrio, calle, numero, imagen, comentario, cuilFK) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=c.conectar().prepareStatement(sql);
            
            ps.setString(1, requerimiento.getDescripcion());
            ps.setString(2, requerimiento.getOpcion1());
            ps.setString(3, requerimiento.getOpcion2());
            ps.setString(4, requerimiento.getLocalidad());
            ps.setString(5, requerimiento.getBarrio());
            ps.setString(6, requerimiento.getCalle());
            ps.setString(7, requerimiento.getNumero());
            ps.setBlob(8, fis,longitudBytes);
            ps.setString(9, requerimiento.getComentario());
            ps.setString(10, requerimiento.getCuil());
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
    
}
