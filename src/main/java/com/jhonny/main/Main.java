package com.jhonny.main;

import com.jhonny.controlador.ControladorInicial;
import com.jhonny.modelo.ModeloDato;
import com.jhonny.vista.VentanaInicial;


public class Main {
    
    public static void main(String[] args) {
        
        VentanaInicial vi = new VentanaInicial();
        ModeloDato modelo = new ModeloDato();
        ControladorInicial control = new ControladorInicial(vi, modelo);
        vi.setVisible(true);
    }
}
