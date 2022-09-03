/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calles;

import Alumbrado.ProblemaLuminaria;
import Alumbrado.ProblemaPoste;
import Interfaces.InterfazFinal;
import static Interfaces.InterfazNuevoRequerimiento.r;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Usuario
 */
public class InterfazCalles extends JFrame {
    
    private static int alto;
    private String opcion1="alumbrado público";
    JButton b1, b2, b3, b4;

    public InterfazCalles() {

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
        
        private JButton b1, b2, b3;
        private String opcion1="Calle pavimentada en mal estado";
        private String opcion2="Calle de tierra en mal estado";
        private String opcion3="Cordón cuneta roto";
        
        
        PanelAlumbrado() {
            
            setLayout(null);
            
            b1=new JButton(opcion1);
            crearBoton(b1);
            
            b2=new JButton(opcion2);
            crearBoton(b2);
            
            b3=new JButton(opcion3);
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
                    r.setOpcion1(opcion1);
                    InterfazFinal marco =new InterfazFinal();
                    
                    dispose();
                }
                
                if(e.getSource()==b2){
                    r.setOpcion1(opcion2);
                    InterfazFinal marco =new InterfazFinal();

                    
                    dispose();
                }
            }
            
        }
    }

    
}
