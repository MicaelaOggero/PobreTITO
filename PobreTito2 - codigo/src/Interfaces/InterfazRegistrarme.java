/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;


import Objetos.Requerimiento;
import Objetos.Usuario;
import Procesos.GuardarUsuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class InterfazRegistrarme extends JFrame {

    public InterfazRegistrarme() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;

        setTitle("Registrarme");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        PanelRegistrarme lamina1 = new PanelRegistrarme();
        lamina1.setBackground(Color.BLACK);
        add(lamina1);

    }

    /*public static void main(String[] args) {

        InterfazRegistrarme marco = new InterfazRegistrarme();

    }*/
}

class PanelRegistrarme extends JPanel {

    private JTextField txtCuil, txtNombre, txtApellido;
    private JPasswordField txtContraseña;
    private JButton btnRegistrarme;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.yellow);

        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Ingrese sus datos", 50, 50);

        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawString("Cuil", 250, 100);
        g2.drawString("Nombre", 250, 150);
        g2.drawString("Apellido", 250, 200);
        g2.drawString("Contraseña", 250, 250);

        setLayout(null);
        btnRegistrarme = new JButton("Registrame");
        btnRegistrarme.setBounds(330, 300, 100, 30);
        btnRegistrarme.setBackground(Color.yellow);
        add(btnRegistrarme);

        RegistroUsuarioBD oyente = new RegistroUsuarioBD();
        btnRegistrarme.addActionListener(oyente);

        txtCuil = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtContraseña = new JPasswordField();

        txtCuil.setBounds(385, 80, 120, 30);
        txtNombre.setBounds(385, 130, 120, 30);
        txtApellido.setBounds(385, 180, 120, 30);
        txtContraseña.setBounds(385, 230, 120, 30);

        add(txtCuil);
        add(txtNombre);
        add(txtApellido);
        add(txtContraseña);

    }

    private class RegistroUsuarioBD implements ActionListener {

        GuardarUsuario dao;
        Usuario u;
        PanelRegistrarme pr;
        

        @Override
        public void actionPerformed(ActionEvent e) {
            
            pr = new PanelRegistrarme();
            u = new Usuario();
            u.setCuil(txtCuil.getText());
            u.setNombre(txtNombre.getText());
            u.setApellido(txtApellido.getText());
            u.setContraseña(txtContraseña.getText());

            dao = new GuardarUsuario();
            if (dao.guardarUsuario(u)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Vuelva a intentarlo");
            }

        }
    }
}
