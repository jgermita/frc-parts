package com.frcparts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

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
    private ArrayList<String> line;
    String query;
    
    public PartsDbHandler() {
        this.line = new ArrayList<String>();
        contents = null;
    }
    
    public String getContents() {
        String url = "https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv";
        contents = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            String s = "";
            
            while ((s = br.readLine()) != null) {
                line.add(s);
                contents = contents.concat(s + "<br>");
            }
        } catch(Exception e) {
            
        }
			
        //contents = System.currentTimeMillis() + "\t";
        if(query ==(null)) {
            query = "0";
        }
        
        if(query.equals("0")) {
            return contents;
        } else {
            return line.get(Integer.parseInt(query)).replace("\t", "\n<br>\n");
        }
        
        //return line.get(Integer.parseInt(query));
        //return contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }
    
    public void setQuery(String id) {
        this.query = id;
    }
    
    public String getQuery() {
        return query;
    }
    
    
}
