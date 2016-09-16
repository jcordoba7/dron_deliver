package dronedeliver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase que representa un dron, con sus respectivas coordenadas, orientación y métodos que hacen que éste se desplace.
 * @author Jhonathan A. Córdoba Castañeda
 */
public class Dron {
    
    /**
     * Variable privada: ID del dron.
     */
    private int ID;
    /**
     * Variable privada: coordenada en el eje X del dron.
     */
    private int corX;
    /**
     * Variable privada: coordenada en el eje Y del dron.
     */
    private int corY;
    /**
     * Variable privada: orientación actual del dron (Norte, Sur, Oriente, Occidente).
     */
    private String direccion;

    /**
     * Constructor de la clase Dron. 
     * @param id id del Dron
     */    
    public Dron(int id)
    { 
        this.ID = id;
        this.corX = 0;
        this.corY = 0;
        this.direccion = "Norte";
    }
    
    /**
     * Método que modifica las coordenadas del dron según la dirección. 
     */
    public void avanzar()
    {
        switch( getDireccion() )
        {
            case "Norte": setCorY( getCorY()+1 ); break;
            case "Sur": setCorY( getCorY()-1 ); break;
            case "Oriente": setCorX( getCorX()+1 ); break;
            case "Occidente": setCorX( getCorX()-1 ); break;
            default: break;
        }
    }
    
    /**
     * Método de rotación respecto al plano, sin tener en cuenta la dirección del dron.
     * @param rotacion dirección hacia donde debe rotar el dron, si izquierda o derecha.
     */
    public void rotarRespectoAlPlano(String rotacion)
    {
        switch(rotacion)
        {
            case "D": 
                switch( getDireccion() )
                {
                    case ("Sur"): 
                    case ("Norte"): setDireccion("Oriente"); break;
                    case ("Oriente"): setDireccion("Sur"); break;
                    case ("Occidente"): setDireccion("Norte"); break;
                }
                break;
                
            case "I": 
                switch( getDireccion() )
                {
                    case ("Sur"): 
                    case ("Norte"): setDireccion("Occidente"); break;
                    case ("Oriente"): setDireccion("Norte"); break;
                    case ("Occidente"): setDireccion("Sur"); break;
                }
                break;
            default: break;
        }
    }
    
    /**
     * Método de rotación respecto al dron, teniendo en cuenta la dirección de éste.
     * @param rotacion dirección hacia donde debe rotar el dron, si izquierda o derecha.
     */
    public void rotarRespectoAlDron(String rotacion)
    {
        switch(rotacion)
        {
            case "D": 
                switch( getDireccion() )
                {                    
                    case ("Norte"): setDireccion("Oriente"); break;
                    case ("Sur"): setDireccion("Occidente"); break;
                    case ("Oriente"): setDireccion("Sur"); break;
                    case ("Occidente"): setDireccion("Norte"); break;
                }
                break;
                
            case "I": 
                switch( getDireccion() )
                {
                    case ("Norte"): setDireccion("Occidente"); break;
                    case ("Sur"): setDireccion("Oriente"); break;
                    case ("Oriente"): setDireccion("Norte"); break;
                    case ("Occidente"): setDireccion("Sur"); break;
                }
                break;
            default: break;
        }
    }
    
    /**
     * Método que retorna la ubicación actual del dron en el formato de registro. 
     * @return cadena con la ubicación actual del dron en el formato de registro.
     */
    public String mostrarUbicacion()
    {
        return ("(" + getCorX() + ", " + getCorY() + ") dirección " + getDireccion());
    }
    
    /**
     * Método que reinicia las coordenadas X y Y en 0, y la dirección en "Norte". Es decir, el dron vuelve al restaurante.
     */
    public void reinicarRecorrido()
    {
        setCorX( 0 );
        setCorY( 0 );
        setDireccion( "Norte" );
    }

    /**
     * @return the corX
     */
    public int getCorX() {
        return corX;
    }

    /**
     * @param corX the corX to set
     */
    public void setCorX(int corX) {
        this.corX = corX;
    }

    /**
     * @return the corY
     */
    public int getCorY() {
        return corY;
    }

    /**
     * @param corY the corY to set
     */
    public void setCorY(int corY) {
        this.corY = corY;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {        
        return this.direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {        
        this.direccion = direccion;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
}
