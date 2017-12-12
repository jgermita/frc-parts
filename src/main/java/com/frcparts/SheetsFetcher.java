package com.frcparts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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
    //public ArrayList<String> line;
	public String[] line;
    public ArrayList<Part> parts;
    String url = null;

    long lastGet = 0;
    long timeout = 600000;	// do not update sheet within timeout ms of last update.

    // "https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv";

    public SheetsFetcher(String url) {
      this.url = url;
      //this.line = new ArrayList<String>();
	  this.line = new String[0];
      this.parts = new ArrayList<Part>();
      contents = null;
    }

    private void getSheet() {

      lastGet = System.currentTimeMillis();

      contents = "";
	  
	  Object[] lines;
      //line.clear();
      parts.clear();
	  
      try {
		InputStreamReader isr = new InputStreamReader(new URL(url).openStream());
        BufferedReader br = new BufferedReader(isr);
		
		lines = br.lines().toArray();
		
		line = Arrays.copyOf(lines, lines.length, String[].class);
		
		br.close();
		isr.close();
		
      } catch(Exception e) {

      }
	  
	  
	for(String s : line) {
	  if(	s.split("\t")[0].isEmpty()) {
		break;
	  }

	  if(s.split("\t")[0].equals("Category")) {
		continue;
	  }

	  //line.add(s);
	  parts.add(new Part(s));

	  //System.out.println(s.split("\t").length);
	  //contents = contents.concat(s + "\n");
	}

      System.out.println("Get time ms: " + (System.currentTimeMillis() - lastGet));

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

    public String getCacheTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date resultdate = new Date(lastGet);
        return (sdf.format(resultdate));
    }

}
