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
    String category = "electrical";
	public Part searched;
    
    public PartsDbHandler() {
        data = new SheetsData(new SheetsFetcher("https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv"));
        searched = data.empty;
    } 
    
    public String getSearchResults() {
        
        return this.toString(data.search(query));
    }
    
    public String getCategory(String cat) {
        this.setCategory(cat);
        return this.toTable(data.getCategory(category));
        //return "test";
    }
    
    
    public void setCategory(String cat) {
        
        this.category = cat;
    }
    
    public String getCategory() {
        return this.category;
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
        
        for(Part p : data.getSearchResults()) {
            answer = answer + p.getId() + "\n";
        }
        
        return answer;
    }
    
    public String toTable() {
        
        return HtmlHelper.toTable(data.search(query));
    }
    
    public String toTable(ArrayList<Part> p) {
        
        return HtmlHelper.toTable(p);
    }
    public String toString(ArrayList<Part> res) {
        
        String answer = "";
        
        for(Part p : res) {
            answer = answer + p.toString() + " <br>\n";
        }
        
        if(res.size() == 0 || res.get(0).equals(data.empty)) {
            answer = "Nothing found!";
        }
        
        
        
        return answer;
    }
	
	
	public void searchPart(String id) {
		for(Part p : data.cache) {
			if(p.getId().equals(id)) {
				searched = p;
			}
		}
		
	}
    
    
    public String getCacheTimestamp() {
        return data.getCacheTimestamp();
    }
    
    public String getSearchListings() {
        ArrayList<Part> results = data.search(query);
        String answer = "<section class=\"post\">";
        if(results.size() == 0) {
            answer = answer + "<h2>Nothing found!</h2>";
        } else {
			if(results.get(0).equals(data.empty)) {
				answer = answer + "<h2 class=\"post-title\">Nothing found!</h2>";
			} else {
				for(Part p : results) {
					answer = answer + "<h2 class=\"post-title\">" + p.getName() + "</h2>\n";
					answer = answer + "<p class=\"post-meta\">" + p.getCat() + " / " + p.getSubcat() + "</p>\n";
					answer = answer + "<div class=\"post-description\"><p>" + p.getDesc() + "</p></div><br>\n";
				}
			}
            
            answer = answer + "\n";
        }
        
        answer = answer + "</section>";
        
        return answer;
        
    }
    
}
