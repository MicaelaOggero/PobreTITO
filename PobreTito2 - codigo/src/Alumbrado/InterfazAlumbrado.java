/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alumbrado;


import static Interfaces.InterfazNuevoRequerimiento.r;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class InterfazAlumbrado extends JFrame {
    private static int alto;
    private String opcion1="alumbrado público";
    JButton b1, b2, b3, b4;

    public InterfazAlumbrado() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;
        setTitle("Nuevo requerimiento");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PanelAlumbrado panel = new PanelAlumbrado();
        panel.setBackground(Color.black);
        add(panel);
    }
    
    /*public static void main(String[] args){
        InterfazAlumbrado marco1=new InterfazAlumbrado();
    }*/

    private class PanelAlumbrado extends JPanel {
        
        JButton b1, b2, b3;
        
        PanelAlumbrado() {
            
            setLayout(null);
            
            b1=new JButton("Problema con luminaria");
            crearBoton(b1);
            
            b2=new JButton("Problema con poste o columna metálica");
            crearBoton(b2);
            
            b3=new JButton("Problema con alumbrado en plaza");
            crearBoton(b3);
        
        }
        private void crearBoton(JButton btn) {
        int x=40;
        alto=alto+x;
        btn.setBounds(240, alto, 300, 30);
        btn.setBackground(Color.yellow);
        add(btn);
        
        Oyente oyente=new Oyente();
        
        btn.addActionListener(oyente);
        
    }
        
        private class Oyente implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource()==b1){
                
                    ProblemaLuminaria marco=new ProblemaLuminaria(); 
                    r.setOpcion1("Problema con luminaria");
                    dispose();
                }
                
                if(e.getSource()==b2){
                
                    ProblemaPoste marco=new ProblemaPoste(); 
                    r.setOpcion1("Problema con poste o columna metálica");
                    dispose();
                }
            }
            
        }
    }

}
