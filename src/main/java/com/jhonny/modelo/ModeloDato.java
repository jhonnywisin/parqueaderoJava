package com.jhonny.modelo;

import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;

public class ModeloDato {
    
    private final String ARCHIVO = "baseDatos3";

    public List<String> leerDeArchivo(){
        List<String> datos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(ARCHIVO))){
            while(sc.hasNextLine()) datos.add(sc.nextLine());
        }catch(FileNotFoundException e){ /* Archivo nuevo */}
        return datos;
    }
    
    
    public void guardarEnArchivo(List<String> lista){
        try(PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO))){
            for(String s: lista) out.println(s);
        }catch(IOException e){e.printStackTrace();}
    }
    
    public String buscarDatos(List<String> lista,String texto){

        if(lista.contains(texto))return texto;
 
        return null;
    }
    
    public void borrarDatos(DefaultListModel modelo, String texto){
        
        modelo.removeElement(texto);
        
    }
}
