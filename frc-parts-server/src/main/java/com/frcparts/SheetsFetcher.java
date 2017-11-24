package com.frcparts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class SheetsFetcher {
    String contents;
    private ArrayList<String> line;
    private ArrayList<Part> parts;
    String url = null;
    
    long lastGet = 0;
    long timeout = 10000;	// do not update sheet within timeout ms of last update. 
    
    // "https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv";
    
    public SheetsFetcher(String url) {
    	this.url = url;
        this.line = new ArrayList<String>();
        this.parts = new ArrayList<Part>();
        contents = null;
    }
    
    private void getSheet() {
    	
    	lastGet = System.currentTimeMillis();
    	
    	
        contents = "";
        line.clear();
        parts.clear();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            String s = "";
            
            while ((s = br.readLine()) != null) {
                line.add(s);
                
                //System.out.println(s);
                contents = contents.concat(s + "\n");
            }
            
            for(String s1 : line) {
            	parts.add(new Part(s1));
            }
        } catch(Exception e) {
            
        }
        
    }
    
    public boolean isCacheStale() {
    	return (System.currentTimeMillis() - lastGet > timeout);
    }
    
    public ArrayList<Part> getCache() {
    	return parts;
    }
    
    public String update() {
    	getSheet();
    	return contents;
    }
    
}