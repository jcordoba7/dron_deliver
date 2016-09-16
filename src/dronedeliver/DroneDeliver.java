/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronedeliver;

/**
 * Clase Main que inicia la ejecución de la aplicación.
 * @author Jhonathan A. Córdoba Castañeda
 */
public class DroneDeliver { 
    
    /**
     * Variable static final: numero total de drones manejados en el negocio.
     */
    public static final int NUMERO_DRONES = 1;
    
    /**
     * Variable statir final: máximo de entregas que un dron puede realizar por ruta.
     */
    public static final int LIMITE_ENTREGAS = 3;  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               
        for( int i = 0; i<NUMERO_DRONES; i++ )
        {
            Thread entrega = new Thread( new GestorDron((i+1), LIMITE_ENTREGAS));
            entrega.start();
        }         
    }
    
}
