/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronedeliver;

/**
 * Clase que representa una entrega, con su respectivo conjunto de movimientos.
 * @author Jhonathan A. Córdoba Castañeda
 */
public class Entrega {
    
    /**
     * Variable privada: conjunto de movimientos (A,D,I) que conforman la entrega.
     */
    private String[] movimientos;

    /**
     * Constructor de la clase Entrega.
     * @param movimientos conjunto de movimientos que conformaran la entrega.
     */
    public Entrega(String[] movimientos)
    {
        this.movimientos = movimientos;
    }

    /**
     * @return the movimientos
     */
    public String[] getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(String[] movimientos) {
        this.movimientos = movimientos;
    }
}
