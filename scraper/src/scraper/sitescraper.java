package scraper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;

public class sitescraper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String vendor = "WCP";
		try {		
			
			String prefix = "http://www.wcproducts.net/WCP-";
			
			for(int i = 0; i < 1000; i++) {
				Thread.sleep(250);
				String url = prefix + String.format("%04d", (i));
				System.out.println(url);
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			
					String s = "";
					String title = "";
					String price = "";
					String partNo = url.split(".net/")[1];
					while ((s = br.readLine()) != null) {
						s = s.trim();
						
						if(s.contains("<title>")) {
							title = s.split(">")[1].split("<")[0];
							//System.out.println(title);
						} else if(s.contains("class=\"price\"")) {
							price = s.split(">")[1].split("<")[0];
							//System.out.println(price);	
						} else {
							continue;
						}
						// break;
					}
					
					System.out.print(title + ", , " + price + ", " + partNo + ", " + vendor + ", " + url);
				} catch(FileNotFoundException e) {
					continue;
				}
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
