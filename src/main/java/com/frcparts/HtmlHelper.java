/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frcparts;

import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class HtmlHelper {
    
    public static String toTable(ArrayList<Part> in) {
        String answer =  "<table class=\"pure-table pure-table-horizontal\" pure-table-odd>\n";
        answer =  answer + "\t<tr> <th>Category</th> <th>Subcat</th> <th>Name</th> <th>Description</th> <th>$</th> <th>P/N</th> <th>Vendor</th> <th>URL</th> <th>ID</th> <th>Source</th> <th>Tags</th> <tr>\n";
        
        for(Part p : in) {
            answer = answer + "\t<tr> ";
            String[] split = p.toString().split("\t");
            
			int i = 0;
			
            for(String s : split) {
				if(s.isEmpty()) s = "-";
                answer = answer + "<td>" + s + "</td> ";
				i++;
            }
			i = 11-i;
			i = Math.max(0, i);
			
			for(int j = 0; j < i; j++) {
				answer = answer + "<td>-</td>";
			}
            
            answer = answer + "</tr>\n	";
        }
        
        answer = answer + "</table>";
        return answer;
    }
    
}
