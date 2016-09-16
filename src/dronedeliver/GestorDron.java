/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronedeliver;

import java.util.ArrayList;

/**
 * Clase que controla los movimientos de un dron según los movimientos de entrada
 * @author Jhonathan A. Córdoba Castañeda
 */
public class GestorDron implements Runnable{

    /**
     * Variable privada: dron que el gestor debe controlar.
     */
    private Dron dron;
    /**
     * Variable privada: número actual de entregas realizadas hasta el momento por parte del dron asignado.
     */
    private int entregasRealizadas;
    /**
     * Variable privada: número límite de entregas que el dron a cargo puede realizar por ruta.
     */
    private int limiteEntregas;
    /**
     * Variable privada: conjunto de entregas que el dron asignado tiene a cargo en el día.
     */
    private ArrayList<Entrega> entregas;
    /**
     * Variable privada: gesto de archivos para realizar la lectura y registro de entregas.
     */
    private GestorArchivos ga;
    
    /**
     * Constructor de la clase GestorDron.
     * @param idDrone id del dron a controlar.
     * @param limiteEntregas limite de entregas posibles qntes de volver al restaurante.
     */
    public GestorDron(int idDrone, int limiteEntregas)
    {
        this.dron = new Dron(idDrone);
        this.limiteEntregas = limiteEntregas;
        this.entregasRealizadas = 0;
        this.entregas = new ArrayList<>();
    }  

    @Override
    public void run()
    {               
        procesarEntregas();        
        realizarEntregas();        
    }
    
    /**
     * Método que procesa el listado de entregas y cada uno de sus movimientos a realizar.
     */
    public void procesarEntregas()
    {
        String nombreArchivo = "";
        
        {
        if( getDron().getID() < 10 )
            nombreArchivo += "0";
        }
        
        setGa(new GestorArchivos(nombreArchivo + getDron().getID()));
        
        String datos = getGa().lecturaDatos("in");
        
        String[] arregloEntregas = datos.split("\n");
        
        for (String arregloEntrega : arregloEntregas)
        {
            String[] arregloMovimientos = new String[arregloEntrega.length()];
            for (int j = 0; j < arregloEntrega.length(); j++)
            {
                arregloMovimientos[j] = arregloEntrega.charAt(j) + "";
            }            
            Entrega e = new Entrega(arregloMovimientos);
            this.getEntregas().add(e);
        }
    }
    
    /**
     * Método que recorre el listado de entregas asignadas al dron, para atender una por una.
     */    
    public void realizarEntregas()
    {
        for(Entrega e: getEntregas())
        {
            atenderEntrega(e);
            setEntregasRealizadas(getEntregasRealizadas() + 1);            
            getGa().escrituraDatos(getDron().mostrarUbicacion());
            
            if(getEntregasRealizadas() % getLimiteEntregas() == 0)
            {
                getDron().reinicarRecorrido();
            }
        }
    }
    
    /**
     * Método que atiende una entrega determinada, haciendo la lectura de cada movimiento que debe hacer el dron.
     * @param e entrega a ser atendida.
     */
    public void atenderEntrega (Entrega e)
    {
        for (String movimiento : e.getMovimientos())
        {
            switch (movimiento)
            {
                case "A": getDron().avanzar(); break;
                case "D": getDron().rotarRespectoAlPlano("D"); break;
                case "I": getDron().rotarRespectoAlPlano("I"); break;
                default: break;
            }
        }
    }

    /**
     * @return the dron
     */
    public Dron getDron() {
        return dron;
    }

    /**
     * @param dron the dron to set
     */
    public void setDron(Dron dron) {
        this.dron = dron;
    }

    /**
     * @return the entregasRealizadas
     */
    public int getEntregasRealizadas() {
        return entregasRealizadas;
    }

    /**
     * @param entregasRealizadas the entregasRealizadas to set
     */
    public void setEntregasRealizadas(int entregasRealizadas) {
        this.entregasRealizadas = entregasRealizadas;
    }

    /**
     * @return the limiteEntregas
     */
    public int getLimiteEntregas() {
        return limiteEntregas;
    }

    /**
     * @param limiteEntregas the limiteEntregas to set
     */
    public void setLimiteEntregas(int limiteEntregas) {
        this.limiteEntregas = limiteEntregas;
    }

    /**
     * @return the entregas
     */
    public ArrayList<Entrega> getEntregas() {
        return entregas;
    }

    /**
     * @param entregas the entregas to set
     */
    public void setEntregas(ArrayList<Entrega> entregas) {
        this.entregas = entregas;
    }

    /**
     * @return the ga
     */
    public GestorArchivos getGa() {
        return ga;
    }

    /**
     * @param ga the ga to set
     */
    public void setGa(GestorArchivos ga) {
        this.ga = ga;
    }
}
