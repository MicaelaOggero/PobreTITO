/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

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
public class InterfazIngresar extends JFrame {

    public InterfazIngresar() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;

        setTitle("Ingreso");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        PanelIngresar lamina1 = new PanelIngresar();
        lamina1.setBackground(Color.BLACK);
        add(lamina1);

    }

    private class PanelIngresar extends JPanel {

    JButton btnNuevoRequerimiento, btnHistorial, btnNotificaciones;

    PanelIngresar() {

        setLayout(null);
        btnNuevoRequerimiento = new JButton("Nuevo requerimiento");
        btnHistorial = new JButton("Historial");
        btnNotificaciones = new JButton("Notificaiones");

        btnNuevoRequerimiento.setBounds(290, 100, 170, 30);
        btnHistorial.setBounds(290, 150, 170, 30);
        btnNotificaciones.setBounds(290, 200, 170, 30);

        btnNuevoRequerimiento.setBackground(Color.yellow);
        btnHistorial.setBackground(Color.yellow);
        btnNotificaciones.setBackground(Color.yellow);

        add(btnNuevoRequerimiento);
        add(btnHistorial);
        add(btnNotificaciones);
        
        Oyente oyente=new Oyente();
        btnNuevoRequerimiento.addActionListener(oyente);
    }

     private class Oyente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            InterfazNuevoRequerimiento marco = new InterfazNuevoRequerimiento();
            dispose();
        }

    }
}


   
}



