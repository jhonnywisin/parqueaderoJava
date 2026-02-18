package com.jhonny.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.*;


public class VentanaInicial extends JFrame {
    
    public VentanaInicial() {
       
       //-----------propiedades de la ventana principal-------------------------
       setTitle("mi app");
       setBounds(700, 350, 700, 600);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("Parqueadero La Pezquera");
       setResizable(false);
       //-----------------------------------------------------------------------
       
       //-----------agregando componentes a sus paneles-------------------------
       pt.add(txtEntrada);
       p_pla.add(texPlaca);
       pbtn.add(btn);
       pbtn.setPreferredSize(new Dimension(600,100));
       
       //-------------agregando paneles al principal----------------------------
       pp.add(pt,BorderLayout.NORTH);
       pp.add(p_pla,BorderLayout.CENTER);
       pp.add(pbtn,BorderLayout.SOUTH);
       
       proLabel(txtEntrada);
       proTexfi(texPlaca);
       proBtn(btn);
        
       add(pp);      
       
   } 
    
   //------------metodos para dar propiedades-----------------------------------
   private void proLabel(JLabel tex){
       
       tex.setFont(new Font("Arial",Font.ITALIC,60));     
   }
   
   private void proTexfi(JTextField tex){
       
       tex.setFont(new Font("Arial",Font.ITALIC,45));
       tex.setHorizontalAlignment(JTextField.CENTER);
   }
   
   private void proBtn(JButton btn){
       
       btn.setFont(new Font("Arial",Font.ITALIC,20));
       btn.setPreferredSize(new Dimension(200,40));
       btn.setText("Registro");
    
   }
   //---------------------------------------------------------------------------
   
   //--------------intanciando objetos------------------------------------------
   public JLabel txtEntrada = new JLabel("Ingrese la placa");
   public JTextField texPlaca = new JTextField(10);
   public JButton btn = new JButton();
    
   JPanel pp = new JPanel(new BorderLayout(2,2));
   JPanel pt = new JPanel();
   JPanel p_pla = new JPanel(new GridBagLayout());
   JPanel pbtn = new JPanel();
   
   public DefaultListModel<String> modeloLista = new DefaultListModel<>();
   public JList<String> listaUI = new JList<>(modeloLista);
}