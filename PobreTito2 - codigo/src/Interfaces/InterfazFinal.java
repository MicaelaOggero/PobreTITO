/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import static Interfaces.InterfazNuevoRequerimiento.r;
import Objetos.Requerimiento;
import Objetos.Usuario;
import Procesos.GuardarRequerimiento;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Usuario
 */
public class InterfazFinal extends JFrame {

    private JLabel foto;
    private FileInputStream fis;
    private int longitudBytes;

    private String opcion=r.getOpcion1();

    public InterfazFinal() {

        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        Dimension tamañoPantalla = miPantalla.getScreenSize();

        int altoPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;
        setTitle("Nuevo requerimiento");
        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        PanelFinal panel = new PanelFinal();
        panel.setBackground(Color.black);
        add(panel);

    }

    /*public static void main(String[] args) {
        InterfazFinal marco = new InterfazFinal("Opcion");
    }*/
    private class PanelFinal extends JPanel {

        private JLabel comentario, domicilio, localidad, barrio, calle, numero;
        private JTextField txtComentario, txtLocalidad, txtBarrio, txtCalle, txtNumero;
        private JButton btnGuardar;

        public PanelFinal() {

            iniciarComponentes();
            agregarFoto();

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.yellow);
            g2.setFont(new Font("Arial", Font.ITALIC, 20));
            g2.drawString(opcion, 20, 40);

            setLayout(null);

            

        }

        private void iniciarComponentes() {
            
            txtLocalidad = new JTextField();
            txtLocalidad.setBounds(180, 135, 100, 30);
            add(txtLocalidad);

            txtBarrio = new JTextField();
            txtBarrio.setBounds(180, 185, 100, 30);
            add(txtBarrio);

            txtCalle = new JTextField();
            txtCalle.setBounds(180, 235, 100, 30);
            add(txtCalle);

            txtNumero = new JTextField();
            txtNumero.setBounds(180, 285, 100, 30);
            add(txtNumero);

            txtComentario = new JTextField();
            txtComentario.setBounds(400, 280, 280, 40);
            add(txtComentario);
            
            domicilio = new JLabel("Domicilio");
            setLayout(null);
            domicilio.setBounds(20, 65, 250, 30);
            domicilio.setForeground(Color.yellow);
            domicilio.setFont(new Font("Arial Black", Font.BOLD, 17));
            add(domicilio);

            localidad = new JLabel();
            localidad.setText("Localidad");
            localidad.setBounds(55, 140, 250, 15);
            localidad.setForeground(Color.yellow);
            localidad.setFont(new Font("Arial", Font.BOLD, 14));
            add(localidad);

            barrio = new JLabel();
            barrio.setText("Barrio");
            barrio.setBounds(55, 190, 250, 15);
            barrio.setForeground(Color.yellow);
            barrio.setFont(new Font("Arial", Font.BOLD, 14));
            add(barrio);

            calle = new JLabel();
            calle.setText("Calle");
            calle.setBounds(55, 240, 250, 15);
            calle.setForeground(Color.yellow);
            calle.setFont(new Font("Arial", Font.BOLD, 14));
            add(calle);

            numero = new JLabel();
            numero.setText("Número");
            numero.setBounds(55, 290, 250, 15);
            numero.setForeground(Color.yellow);
            numero.setFont(new Font("Arial", Font.BOLD, 14));
            add(numero);

            comentario = new JLabel();
            comentario.setText("Comentario");
            comentario.setBounds(400, 250, 150, 20);
            comentario.setForeground(Color.yellow);
            comentario.setFont(new Font("Arial", Font.BOLD, 14));
            add(comentario);

            btnGuardar = new JButton("Guardar");
            btnGuardar.setBounds(330, 340, 100, 30);
            btnGuardar.setBackground(Color.yellow);
            add(btnGuardar);

            RegistroRequerimientoBD oyente = new RegistroRequerimientoBD();

            btnGuardar.addActionListener(oyente);
            
        }
        
        public void agregarFoto(){
            
            Border LineBorder = BorderFactory.createLineBorder(Color.yellow);

            foto = new JLabel();

            foto.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    JFileChooser se = new JFileChooser();
                    se.addChoosableFileFilter(new FiltroSeleccionImagen());
                    se.setAcceptAllFileFilterUsed(false);

                    int estado = se.showOpenDialog(PanelFinal.this);

                    if (estado == JFileChooser.APPROVE_OPTION) {

                        try {
                            setFis(new FileInputStream(se.getSelectedFile()));
                            setLongitudBytes((int) se.getSelectedFile().length());

                            File imagenSeleccionada = se.getSelectedFile();

                            ImageIcon imagen = new ImageIcon(imagenSeleccionada.getAbsolutePath());

                            imagen = new ImageIcon(escalarImagen(convertirABufferedImage(imagen.getImage())));

                            foto.setIcon(imagen);

                        } catch (FileNotFoundException ex) {
                            System.out.println("Error en el catch" + ex);
                        }

                    }
                }

            });

            foto.setText("FOTO");
            foto.setHorizontalAlignment(SwingConstants.CENTER);
            foto.setBounds(455, 85, 130, 160);
            foto.setBorder(LineBorder);
            foto.setForeground(Color.yellow);
            foto.setFont(new Font("Arial", Font.BOLD, 14));
            add(foto);
           

            
        }
        
        private BufferedImage convertirABufferedImage(Image imagen) {

            if (imagen instanceof BufferedImage) {
                return (BufferedImage) imagen;
            }

            BufferedImage bi = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            Graphics g = bi.getGraphics();
            g.drawImage(imagen, 0, 0, null);
            g.dispose();

            return bi;

        }

        private Image escalarImagen(BufferedImage imagen) {

            return imagen.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);

        }

        private class RegistroRequerimientoBD implements ActionListener {

            GuardarRequerimiento dao;

            @Override
            public void actionPerformed(ActionEvent e) {
                //txtComentario, txtLocalidad, txtBarrio, txtCalle, txtNumero, txtNombreImagen;

                String comentario = txtComentario.getText();
                System.out.println(comentario);

                r.setComentario(txtComentario.getText());
                r.setLocalidad(txtLocalidad.getText());
                r.setBarrio(txtBarrio.getText());
                r.setCalle(txtCalle.getText());
                r.setNumero(txtNumero.getText());

                dao = new GuardarRequerimiento();
                if (dao.guardarRequerimiento(r, fis, longitudBytes)) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    //InterfazInicial i = new InterfazInicial();

                } else {
                    JOptionPane.showMessageDialog(null, "Error: Vuelva a intentarlo");
                }

            }

        }
    }

    /**
     * @return the longitudBytes
     */
    public int getLongitudBytes() {
        return longitudBytes;
    }

    /**
     * @param longitudBytes the longitudBytes to set
     */
    public void setLongitudBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }

    /**
     * @return the fis
     */
    public FileInputStream getFis() {
        return fis;
    }

    /**
     * @param fis the fis to set
     */
    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }
}

class FiltroSeleccionImagen extends FileFilter {

    public final static String JPEG = "jpeg";
    public final static String JPG = "jpg";
    public final static String PNG = "png";

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = obtenerExtensionArchivo(f);

        if (!extension.isEmpty()) {

            return extension.equals(JPEG) || extension.equals(JPG) || extension.equals(PNG);

        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Solo se aceptan imagenes (JPEG, JPG, PNG)";
    }

    String obtenerExtensionArchivo(File archivo) {

        String extension = "";
        String nombreArchivo = archivo.getName();
        int indicePunto = nombreArchivo.lastIndexOf('.');

        if (indicePunto > 0 && indicePunto < nombreArchivo.length() - 1) {

            extension = nombreArchivo.substring(indicePunto + 1).toLowerCase();

        }

        return extension;
    }
}
