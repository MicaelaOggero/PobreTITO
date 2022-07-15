/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Usuario
 */
public class Metodos {
    public static boolean insertarUsuario(Usuarios x){
        Connection cn=Conexion.Conectar();
        PreparedStatement ps=null;
        
        String sql="insert into usuario (cuil,nombre,apellido,contraseña) values (?,?,?,?)";
   
        try{
            
            ps=cn.prepareStatement(sql);
            ps.setString(1, x.getCuil());
            ps.setString(2, x.getNombre());
            ps.setString(3, x.getApellido());
            ps.setString(4, x.getContraseña());
            ps.execute();
            cn.close();
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return false;
    }
    
    public static boolean autenticacion (String Pusher, String Ppsw){
        Connection cn=Conexion.Conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        String sql="select cuil, contraseña from usuario where cuil=? and contraseña=?";
        
        try{
            
            ps=cn.prepareStatement(sql);
            ps.setString(1, Pusher);
            ps.setString(2, Ppsw);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                cn.close();
                return true;
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
