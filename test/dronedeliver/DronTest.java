/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronedeliver;

import dronedeliver.Dron;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class DronTest {
    
    public DronTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of avanzar method, of class Dron.
     */
    @Test
    public void testAvanzar() {
        System.out.println("avanzar");
        Dron instance = new Dron(1);
        int prevX = instance.getCorX();
        int prevY = instance.getCorY();
        String prevDir = instance.getDireccion();
        instance.avanzar();
        // TODO review the generated test code and remove the default call to fail.
        switch (prevDir) 
        {
            case "Norte":
                if(!( prevX == instance.getCorX() && prevY+1 == instance.getCorY() && prevDir.equals(instance.getDireccion()) ) )
                {
                    fail("The test case is a prototype.");
                }   break;
            case "Sur":
                if(!( prevX == instance.getCorX() && prevY-1 == instance.getCorY() && prevDir.equals(instance.getDireccion()) ) )
                {
                    fail("The test case is a prototype.");
                }   break;
            case "Oriente":
                if(!( prevX+1 == instance.getCorX() && prevY == instance.getCorY() && prevDir.equals(instance.getDireccion()) ) )
                {
                    fail("The test case is a prototype.");
            }   break;
            case "Occidente":
                if(!( prevX-1 == instance.getCorX() && prevY == instance.getCorY() && prevDir.equals(instance.getDireccion()) ) )
                {
                    fail("The test case is a prototype.");
            }   break; 
        }
    }

    /**
     * Test of rotarRespectoAlPlano method, of class Dron.
     */
    @Test
    public void testRotarRespectoAlPlano() {
        System.out.println("rotarRespectoAlPlano");
        String rotacion = "D";        
        Dron instance = new Dron(1);
        String prevDir = instance.getDireccion();
        instance.rotarRespectoAlPlano(rotacion);
        // TODO review the generated test code and remove the default call to fail.
        if( !( (prevDir.equals("Norte") || prevDir.equals("Sur")) && instance.getDireccion().equals("Oriente")) )
        {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of rotarRespectoAlDron method, of class Dron.
     */
    @Test
    public void testRotarRespectoAlDron() {
        System.out.println("rotarRespectoAlDron");
        String rotacion = "D";
        Dron instance = new Dron(0);
        String prevDir = instance.getDireccion();
        instance.rotarRespectoAlDron(rotacion);
        // TODO review the generated test code and remove the default call to fail.
        if( !( prevDir.equals("Norte") && instance.getDireccion().equals("Oriente")) )
        {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of mostrarUbicacion method, of class Dron.
     */
    @Test
    public void testMostrarUbicacion() {
        System.out.println("mostrarUbicacion");
        Dron instance = new Dron(1);
        String expResult = "(" + instance.getCorX() + ", " + instance.getCorY() + ") dirección " + instance.getDireccion();
        String result = instance.mostrarUbicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of reinicarRecorrido method, of class Dron.
     */
    @Test
    public void testReinicarRecorrido() {
        System.out.println("reinicarRecorrido");
        Dron instance = new Dron(1);
        instance.reinicarRecorrido();
        // TODO review the generated test code and remove the default call to fail.
        
        if( !( instance.getCorX() == 0 && instance.getCorY() == 0 && instance.getDireccion().equals("Norte") ) )
        {
           fail("The test case is a prototype."); 
        }  
    }
}
