/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Alumbrado.InterfazAlumbrado;
import Arbolado.InterfazArbolado;
import Calles.InterfazCalles;
import Cloacas.InterfazCloacas;
import static Interfaces.InterfazInicial.g_cuil;
import Objetos.Requerimiento;
import Plazas.InterfazPlazas;
import Predio.InterfazPredio;
import Recoleccion.InterfazRecoleccion;
import ViaPublica.InterfazViaPublica;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class InterfazNuevoRequerimiento extends JFrame implements ActionListener {

    JPanel panel;
    JButton btnArbolado, btnVia, btnSemaforo, btnRecoleccion, btnPredio, btnPlazas, btnCloacas, btnCalles, btnAlumbrado;
    JLabel titulo;
    private String descripcion;
    public static Requerimiento r = new Requerimiento();

    InterfazNuevoRequerimiento() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;
        setTitle("Nuevo requerimiento");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);

        inciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void inciarComponentes() {

        crearPanel();
        colocarBotones();
        colocarEtiquetas();

    }

    private void colocarBotones() {

        ImageIcon alumbrado = new ImageIcon("src/Imagenes/alumbrado.jpg");
        ImageIcon calles = new ImageIcon("src/Imagenes/calles.jpg");
        ImageIcon cloacas = new ImageIcon("src/Imagenes/cloacas.jpg");
        ImageIcon plazas = new ImageIcon("src/Imagenes/plazas.jpg");
        ImageIcon predio = new ImageIcon("src/Imagenes/predio.jpg");
        ImageIcon recoleccion = new ImageIcon("src/Imagenes/recoleccion.jpg");
        ImageIcon semaforos = new ImageIcon("src/Imagenes/semaforos.jpg");
        ImageIcon via = new ImageIcon("src/Imagenes/via.jpg");
        ImageIcon arbolado = new ImageIcon("src/Imagenes/arbolado.jpg");

        btnAlumbrado = new JButton();
        btnCalles = new JButton();
        btnCloacas = new JButton();
        btnPlazas = new JButton();
        btnPredio = new JButton();
        btnRecoleccion = new JButton();
        btnSemaforo = new JButton();
        btnVia = new JButton();
        btnArbolado = new JButton();

        btnAlumbrado.setBounds(200, 60, 100, 101);
        btnCalles.setBounds(320, 60, 100, 101);
        btnCloacas.setBounds(440, 60, 100, 101);
        btnPlazas.setBounds(200, 171, 100, 101);
        btnPredio.setBounds(320, 171, 100, 101);
        btnRecoleccion.setBounds(440, 171, 100, 101);
        btnSemaforo.setBounds(200, 282, 100, 101);
        btnVia.setBounds(320, 282, 100, 101);
        btnArbolado.setBounds(440, 282, 100, 101);

        crearBoton(btnAlumbrado, alumbrado);
        crearBoton(btnCalles, calles);
        crearBoton(btnCloacas, cloacas);
        crearBoton(btnPlazas, plazas);
        crearBoton(btnPredio, predio);
        crearBoton(btnRecoleccion, recoleccion);
        crearBoton(btnSemaforo, semaforos);
        crearBoton(btnVia, via);
        crearBoton(btnArbolado, arbolado);

    }

    private void crearBoton(JButton boton, ImageIcon imagen) {

        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        boton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));

        panel.add(boton);
        boton.addActionListener(this);
    }

    private void colocarEtiquetas() {

        titulo = new JLabel();
        titulo.setBounds(20, 5, 300, 50);
        titulo.setText("Elegí el motivo de tu requerimiento");
        titulo.setForeground(Color.yellow);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);

    }

    private void crearPanel() {

        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        r.setCuil(g_cuil);

        if (e.getSource() == btnAlumbrado) {

            InterfazAlumbrado marco = new InterfazAlumbrado();
            descripcion = "Alumbrado público";
            this.dispose();
        }
        //    JButton btnArbolado,btnVia,btnSemaforo,btnRecoleccion,btnPredio,btnPlazas,btnCloacas, btnCalles,btnAlumbrado;

        if (e.getSource() == btnArbolado) {

            InterfazArbolado marco = new InterfazArbolado();
            descripcion = "Árbolado";
            this.dispose();

        }

        if (e.getSource() == btnVia) {

            InterfazViaPublica marco = new InterfazViaPublica();
            descripcion = "Vía pública";
            this.dispose();

        }

        if (e.getSource() == btnRecoleccion) {

            InterfazRecoleccion marco = new InterfazRecoleccion();
            descripcion = "Recolección de residuos";
            this.dispose();

        }

        if (e.getSource() == btnPredio) {

            InterfazPredio marco = new InterfazPredio();
            descripcion = "Predio baldío o edificado";
            this.dispose();

        }

        if (e.getSource() == btnPlazas) {

            InterfazPlazas marco = new InterfazPlazas();
            descripcion = "Plazas o espacios verdes";
            this.dispose();

        }

        if (e.getSource() == btnCloacas) {

            InterfazCloacas marco = new InterfazCloacas();
            descripcion = "Cloacas";
            this.dispose();

        }

        if (e.getSource() == btnCalles) {

            InterfazCalles marco = new InterfazCalles();
            descripcion = "Calles";
            this.dispose();

        }

        r.setDescripcion(descripcion);
    }
}
