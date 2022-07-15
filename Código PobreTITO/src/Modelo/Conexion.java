/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Usuario
 */
public class Conexion {
    public Connection conexion=null;
    
    public static Connection Conectar(){
        Connection cn=null;
        
        try {
            Class.forName("con.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pobretito","root","Exaktus");
        } catch (Exception e){
            System.out.println(String.valueOf(e));
        }
        return cn;
    }
}
