/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.frcparts.SheetsData;
import com.frcparts.SheetsFetcher;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeremy
 */
public class SheetsDataTest {
    
    public SheetsData data = null;
    
    
    
    public SheetsDataTest() {
        data = new SheetsData(new SheetsFetcher("https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv"));
        
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void parseTsvTest() {
        
        String contents = "";
        
        for(String s : data.sheet.line) {
            contents = contents + s;
			System.out.println(s);
        }
        
        if(contents.isEmpty()) {
            fail("returned empty string!");
        }
        
        
        assert(true);
    }
    
    @Test
    public void minEntrySizeTest() {
        
        System.out.println("Minimum entry size test.");
        
        int min = 9;
        
        for(int i = 0; i < data.sheet.line.size(); i++) {
            
            int testIndex = i;
            
            //System.out.println("Testing index " + testIndex);
			//System.out.println(data.sheet.line.get(testIndex));
            
            int actual = data.sheet.line.get(testIndex).split("\t", 19).length;
            
            //System.out.println("Expected size: " + min);
            //System.out.println("Actual   size: " + actual + "\n\n");
			
			//System.out.println(data.sheet.line.get(testIndex).split("\t"));
			
            assert(actual >= min);
			//assert(true);
        }
    }
    
//    @Test
//    public void tagParseTest() {
//        
//        for(int i = 0; i < data.sheet.line.size(); i++) {
//            
//            String in = data.sheet.line.get(i);
//
//            String[] params = in.split("\t");
//            String[] tags = Arrays.copyOfRange(params, 9, params.length);
//
//            System.out.println("Testing index   " + i);
//            System.out.println("Tag array size  " + tags.length);
//            for(String s : tags) {
//                System.out.print(s + "\t");
//            }
//            System.out.println();
//            
//            
//        }
//        
//    }
    
    
}
