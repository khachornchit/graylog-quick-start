/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author kajornjit.songsaen
 */
public class CrmPerformanceChartTest {

    public CrmPerformanceChartTest() {
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
     * Test of insertRecordIntoTable method, of class CrmPerformanceChart.
     */
    @Ignore
    public void testInsertRecordIntoTable() throws Exception {
        System.out.println("insertRecordIntoTable");
        CrmPerformanceChart instance = new CrmPerformanceChart();

        Random random = new Random();
        final int upperBound = 3000;
        final int lowerBound = 1000;

        int PerformanceId = 21;
        String Timex = "18:00";
        int PageSpeed = random.nextInt(upperBound - lowerBound) + lowerBound;
        int RestSpeed = random.nextInt(upperBound - lowerBound) + lowerBound;
        int Reference = upperBound;
        int Lsl = lowerBound;
        int Usl = upperBound;

        assertEquals(instance.insertRecordIntoTable(
                PerformanceId,
                Timex,
                PageSpeed,
                RestSpeed,
                Reference,
                Lsl,
                Usl
        ), true);
    }

    /**
     * Test of selectRecordsFromTable method, of class CrmPerformanceChart.
     */
    @Ignore
    public void testSelectRecordsFromTable() throws Exception {
        System.out.println("selectRecordsFromTable");
        CrmPerformanceChart instance = new CrmPerformanceChart();

        assertEquals(instance.selectRecordsFromTable(), true);
    }
    
    @Test
    public void testGetLastTime() throws Exception {
        System.out.println("selectRecordsFromTable");
        CrmPerformanceChart instance = new CrmPerformanceChart();
        instance.getLastTime();
    }
}
