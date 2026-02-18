package com.jhonny.controlador;

import com.jhonny.modelo.ModeloDato;
import com.jhonny.vista.VentanaInicial;
import java.awt.Color;
import java.util.*;

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
              System.out.println("el dato ya exite: ");
              vista.txtEntrada.setForeground(Color.red);
              vista.txtEntrada.setText(obtenidoComparar);
          }else{
              System.out.println("guardando archivos");
              vista.modeloLista.addElement(texto);
              modelo.guardarEnArchivo(Collections.list(vista.modeloLista.elements()));
              vista.txtEntrada.setText("exito");
              vista.txtEntrada.setForeground(Color.BLUE);
          }           
       }else return;
    }
}
