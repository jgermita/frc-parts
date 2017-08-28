package com.frcparts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class PartsDbHandler {
    String contents;
    
    public PartsDbHandler() {
        contents = null;
    }
    
    public String getContents() {
        String url = "https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv";
        contents = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            String s = "";
            
            while ((s = br.readLine()) != null) {
                contents = contents.concat(s + "<br>");
            }
        } catch(Exception e) {
            
        }
			
        //contents = System.currentTimeMillis() + "\t";
        return contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }
    
    
}
