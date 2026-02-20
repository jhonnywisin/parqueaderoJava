package com.jhonny.controlador;

import com.jhonny.modelo.ModeloDato;
import com.jhonny.vista.VentanaInicial;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;

public class ControladorInicial {
    private VentanaInicial vista;
    private ModeloDato modelo;

    public ControladorInicial(VentanaInicial vista, ModeloDato modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        //cargar datos iniciales
        refrescarLista();
        
        this.vista.btn.addActionListener(e -> ejecutarLogica());

    }

    private void refrescarLista() {
        vista.modeloLista.clear();
        modelo.leerDeArchivo().forEach(vista.modeloLista::addElement);
    }

    private void ejecutarLogica(){
       
       String texto = vista.texPlaca.getText().trim();
       String obtenidoComparar = modelo.buscarDatos(modelo.leerDeArchivo(), texto);

       if(!texto.isEmpty()){
  
          if(texto.equalsIgnoreCase(obtenidoComparar)){
              vista.txtEntrada.setForeground(Color.red);
              vista.txtEntrada.setText(obtenidoComparar);
              vista.texPlaca.setText("");
              String mensaje = "Vehiculo existente, desea borrarlo?";
              int opcion = JOptionPane.showConfirmDialog(vista, mensaje, "Cobros", 0, 2);
              
              if(opcion == 0){
               modelo.borrarDatos(vista.modeloLista, texto);
               modelo.guardarEnArchivo(Collections.list(vista.modeloLista.elements()));
               System.out.println("borrado");
              }
              
          }else{
              System.out.println("guardando archivos");
              vista.modeloLista.addElement(texto);
              modelo.guardarEnArchivo(Collections.list(vista.modeloLista.elements()));
              vista.txtEntrada.setText("exito");
              vista.txtEntrada.setForeground(Color.BLUE);
              vista.texPlaca.setText("");
          }           
       }else return;
    }
}
