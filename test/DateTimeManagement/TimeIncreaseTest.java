/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTimeManagement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kajornjit.songsaen
 */
public class TimeIncreaseTest {
    
    public TimeIncreaseTest() {
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
     * Test of Increase30min method, of class TimeIncrease.
     */
    @Test
    public void testIncrease30min() {
        System.out.println("Increase30min");
        TimeIncrease instance = new TimeIncrease();
        instance.Increase30min();
    }
    
    @Test
    public void testIncrease30minInput() {
        System.out.println("Increase30min");
        TimeIncrease instance = new TimeIncrease();
        instance.Increase30min("15:00");
    }
    
}