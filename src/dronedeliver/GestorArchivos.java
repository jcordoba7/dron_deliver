/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronedeliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que se encarga de la lectura y escritura de los los ficheros involucrados en la aplicación.
 * @author Jhonathan A. Córdoba Castañeda
 */
public class GestorArchivos {
    
    private final String rutaArchivoEntrada;  
    private final String rutaArchivoSalida;

    /**
     * Constructor de la clase GestorArchivos
     * @param numeroArchivo numero del dron a procesar.
     */
    public GestorArchivos(String numeroArchivo)
    {
        this.rutaArchivoEntrada = new File("archivostexto/in/in" + numeroArchivo + ".txt").getAbsolutePath().replace("\\", "/");
        this.rutaArchivoSalida = new File("archivostexto/out/out" + numeroArchivo + ".txt").getAbsolutePath().replace("\\", "/");
    }
    
    /**
     * Método que realiza la lectura de un archivo.
     * @param tipo tipo de archivo (in o out).
     * @return cadena con el contenido del archivo leído.
     */
    public String lecturaDatos(String tipo)
    {
        String datos = "";
        
        try {            
            FileReader fr;
            
            if(tipo.equals("in"))
            {
                fr = new FileReader(rutaArchivoEntrada); 
            }
            else
            {
                fr = new FileReader(rutaArchivoSalida);
            }
            
            BufferedReader br = new BufferedReader(fr);     

            String linea;

            while((linea = br.readLine()) != null)
            {
                datos += linea + "\n";
            }
            fr.close();            
        }
        catch(Exception e) {
            System.out.println("Excepcion leyendo archivo "+ rutaArchivoEntrada + ": " + e);
        }
        return datos;
    }
    
    /**
     * Método que modifica el contenido de un archivo, registrando las coordenadas del dron al final de cada entrega.
     * @param dato cadena a ser escrita dentro del archivo a modificar (nueva coordenada del dron luego de su última entrega).
     */
    public void escrituraDatos(String dato)
    {
        try
        {                  
            File archivo = new File(rutaArchivoSalida);
            //archivo.deleteOnExit(); //Los archivos out generados se borrarán automáticamente apenas se cierre la aplicación.
           
            if (!archivo.exists())
            {
                    archivo.createNewFile();
                    dato = "== Reporte de entregas ==\r\n" + dato;
            }

            dato = lecturaDatos("out").replace("\n", "\r\n") + dato;
                    
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile());
            
            try (BufferedWriter bw = new BufferedWriter(fw)) 
            {
                bw.write(dato);
                bw.close();
                fw.close();                
            }   
            catch(IOException e)
            {
                System.out.println("Excepcion escribiendo archivo "+ rutaArchivoEntrada + ": " + e);
            }
        }
        catch(Exception e)
        {
            System.out.println("Excepcion escribiendo archivo "+ rutaArchivoEntrada + ": " + e);
        }
    }
    
}
