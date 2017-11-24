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
    public SheetsData data = null;
    
    String results;
    String query;
    
    public PartsDbHandler() {
        data = new SheetsData(new SheetsFetcher("https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv"));
        
    } 
    
    public String getResults() {
        
        String answer = "";
        
        ArrayList<Part> res = data.search(query);
        
        for(Part p : res) {
            answer = answer + p.toString() + " <br>\n";
        }
        
        if(res.size() == 0 || res.get(0).equals(data.empty)) {
            answer = "Nothing found!";
        }
        
        this.results = answer;
        
        return results;
    }
    
    public void setResults(String results) {
        
        this.results = results;
    }
    
    public void setQuery(String id) {
        
        this.query = id.trim();
        
        
    }
    
    public String getQuery() {
        return query;
    }
    
    public String getIds() {
        String answer = "";
        
        for(Part p : data.get()) {
            answer = answer + p.getId() + "\n";
        }
        
        return answer;
    }
    
    public String toTable() {
        
        return HtmlHelper.toTable(data.search(query));
    }
    
}