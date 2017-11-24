package com.frcparts;

import java.util.ArrayList;
import java.util.Scanner;

public class SheetsData {
	private ArrayList<Part> cache;
	
	private SheetsFetcher sheet = null;
	public Part empty = new Part("\t\t\t\t\t\t\t\t");
	
	
	public SheetsData(SheetsFetcher sheet) {
		this.sheet = sheet;
		this.sheet.update();
		
		cache = this.sheet.getCache();
		
	
	}
	
	private ArrayList<Part> results = new ArrayList<Part>();
	private ArrayList<Part> temp = new ArrayList<Part>();
	public ArrayList<Part> search(String query) {
		
                results.clear();
                temp.clear();
            
		query = " " + query;

		if(sheet.isCacheStale()) {
			sheet.update();			
		}
		
		cache = this.sheet.getCache();
		
		boolean searchValid = true;
		
		if(query.length() < 3) {
			System.out.println("Search terms too short! Search for more than 3 characters!");
			searchValid = false;
		}
		
		
		if(searchValid) {
			
			for(Part p : cache) {
				String s = p.getCat() + "\t" + p.getSubcat() + "\t" + p.getVendor() + "\t" + p.getName() + "\t" + p.getDesc() + "\t" + p.getTags();
				
				//System.out.println(s);
				if(s.toLowerCase().contains(query.toLowerCase())) {
					if(results.size() == 0) {
						results.add(p);
					} else {
						for(Part d : results) {
							if(!(Integer.parseInt(d.getId()) == Integer.parseInt(p.getId()))) {
								temp.add(p);
							}
						}
					}
//					
//					if(!results.contains(p)) {
//						results.add(p);
//					}
				}
			}
			
		}
		
		results.addAll(temp);
		
		if(results.size() == 0) {
			results.add(empty);
		}
		return results;
	}
        
        public ArrayList<Part> getSearchResults() {
            return results;
        }
        
        public ArrayList<Part> getCategory(String category) {
            ArrayList<Part> answer = new ArrayList<Part>();
            
            category = category.toLowerCase();
            
            if(sheet.isCacheStale()) {
                sheet.update();			
            }

            cache = this.sheet.getCache();
            
            for(Part p : cache) {
                if(p.getCat().toLowerCase().equals(category)) {
                    answer.add(p);
                }
            }
            
            return answer;
        }
        
        public String getCacheTimestamp() {
            return sheet.getCacheTimestamp();
        }

}
