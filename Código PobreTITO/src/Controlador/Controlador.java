/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Metodos;
import Modelo.Usuarios;
import Vista.Login;
import Vista.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener {

    Metodos met=new Metodos();
    Usuarios x=new Usuarios();
    Login log=new Login();
    Registro reg=new Registro();
    
    public Controlador(Registro reg, Usuarios user){
        
        this.reg=reg;
        
        this.x=user;
        
        //registrar usuario
        this.reg.btRegistrar.addActionListener(this);
    }
    
    public void registrar(){
        
        x.setNombre(reg.tNombre.getText());
        x.setApellido(reg.tApellido.getText());
        x.setCuil(reg.tCuil.getName());
        x.setContraseña(reg.tContraseña.getText());
        
        if(met.insertarUsuario(x)){
            JOptionPane.showMessageDialog(null, "Usuario registrad");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==reg.btRegistrar){
            registrar();
        }
    }
    
}
