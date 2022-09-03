/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alumbrado;

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
public class ProblemaPoste extends JFrame {
    
    private String opcion2;

    public ProblemaPoste() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;
        setTitle("Nuevo requerimiento");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PanelLuminaria lamina = new PanelLuminaria();
        lamina.setBackground(Color.black);
        add(lamina);
    }

    private class PanelLuminaria extends JPanel {

        Boton btn1, btn2, btn3, btn4, btn5, btn6;

        public PanelLuminaria() {

            setLayout(null);
            Oyente oyente = new Oyente();

            btn1 = new Boton("Inclinado o por caer");
            add(btn1);
            btn1.addActionListener(oyente);

            btn2 = new Boton("Caído sobre calle, casa o vereda");
            add(btn2);
            btn2.addActionListener(oyente);

            btn3 = new Boton("Chocado");
            add(btn3);
            btn3.addActionListener(oyente);

            btn4 = new Boton("Columna electrificada");
            add(btn4);
            btn4.addActionListener(oyente);
            btn5 = new Boton("Tapa abierta o sin tapa");
            add(btn5);
            btn5.addActionListener(oyente);
            btn6 = new Boton("Columna picada en la base");
            add(btn6);
            btn6.addActionListener(oyente);

        }

        private class Oyente implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btn1) {
                    opcion2 = "Inclinado o por caer";
                    InterfazFinal ubicacion = new InterfazFinal();
                    r.setOpcion2(opcion2);
                    dispose();
                }

                if (e.getSource() == btn2) {
                    opcion2 = "Caído sobre calle, casa o vereda";
                    InterfazFinal ubicacion = new InterfazFinal();
                    r.setOpcion2(opcion2);
                    dispose();
                }

                if (e.getSource() == btn3) {
                    opcion2 = "Chocado";
                    InterfazFinal ubicacion = new InterfazFinal();
                    r.setOpcion2(opcion2);
                    dispose();
                }

                if (e.getSource() == btn4) {
                    opcion2 = "Columna electrificada";
                    InterfazFinal ubicacion = new InterfazFinal();
                    r.setOpcion2(opcion2);
                    dispose();
                }

                if (e.getSource() == btn5) {
                    opcion2 = "Tapa abierta o sin tapa";
                    InterfazFinal ubicacion = new InterfazFinal();
                    r.setOpcion2(opcion2);
                    dispose();
                }

                if (e.getSource() == btn6) {
                    opcion2 = "Columna picada en la base";
                    InterfazFinal ubicacion = new InterfazFinal();
                    r.setOpcion2(opcion2);
                    dispose();
                }
            }

        }
    }

    class Boton extends JButton {

        private int y;
        private static int ySiguiente = 50;

        public Boton(String nom) {

            y = ySiguiente;
            setText(nom);
            setBounds(225, y, 300, 30);
            setBackground(Color.yellow);
            ySiguiente = ySiguiente + 45;
        }

    }
    
}
