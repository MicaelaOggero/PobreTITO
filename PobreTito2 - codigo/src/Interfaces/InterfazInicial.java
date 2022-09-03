/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Objetos.Usuario;
import Procesos.GuardarUsuario;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfazInicial extends JFrame {
    
    public static String g_cuil;
    
    public InterfazInicial() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;

        setTitle("Municipalidad de Córdoba");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        PanelInicial lamina1 = new PanelInicial();
        lamina1.setBackground(Color.BLACK);
        add(lamina1);
        
    }

    

    /*public static void main(String[] args){
        
        InterfazInicial marco1=new InterfazInicial();
    }*/
    private class PanelInicial extends JPanel {

        private JButton btnIngresar, btnRegistrarme;
        private JTextField txtCuil, txtContraseña;
        
        
        
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.yellow);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Hola!", 50, 50);

            g2.setFont(new Font("Arial", Font.BOLD, 14));
            g2.drawString("Cuil", 250, 120);
            g2.drawString("Contraseña", 250, 170);

            setLayout(null);
            btnIngresar = new JButton("Ingresar");
            btnRegistrarme = new JButton("Registrame");

            
            btnIngresar.setBounds(250, 250, 100, 30);
            btnRegistrarme.setBounds(400, 250, 100, 30);
            btnIngresar.setBackground(Color.yellow);
            btnRegistrarme.setBackground(Color.yellow);
                    
            add(btnIngresar);
            add(btnRegistrarme);
                        
            Oyente mioyente = new Oyente();
            Oyente2 mioyente2 = new Oyente2();

            btnRegistrarme.addActionListener(mioyente);
            btnIngresar.addActionListener(mioyente2);

            txtCuil = new JTextField();
            txtContraseña = new JTextField();

            txtCuil.setBounds(385, 100, 120, 30);
            txtContraseña.setBounds(385, 150, 120, 30);

            add(txtCuil);
            add(txtContraseña);

        }
        private class Oyente implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                InterfazRegistrarme marco = new InterfazRegistrarme();
                dispose();
            }

        }

        private class Oyente2 implements ActionListener {

            Usuario u;
            GuardarUsuario dao;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                g_cuil=txtCuil.getText();
                
                u = new Usuario();
                u.setCuil(g_cuil);
                u.setContraseña(txtContraseña.getText());

                dao = new GuardarUsuario();
                if (dao.validarAcceso(u)) {
                    JOptionPane.showMessageDialog(null, "Ingreso al sistema");
                    InterfazIngresar marco = new InterfazIngresar();
                    dispose();
                } else { 
                    JOptionPane.showMessageDialog(null, "Error: Vuelva a intentarlo");
                    txtCuil.setText("");
                    txtContraseña.setText("");
                }
                
            }

        }
    }
}
