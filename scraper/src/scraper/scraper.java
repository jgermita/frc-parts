package scraper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class scraper {

	public static void main(String[] args) {

		String url = "https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv";
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

			String s = "";
			
			ArrayList<Part> elec = new ArrayList<Part>();
			ArrayList<Part> gear = new ArrayList<Part>();
			ArrayList<Part> hard = new ArrayList<Part>();
			ArrayList<Part> mate = new ArrayList<Part>();
			ArrayList<Part> misc = new ArrayList<Part>();
			ArrayList<Part> pneu = new ArrayList<Part>();
			ArrayList<Part> pull = new ArrayList<Part>();
			ArrayList<Part> spro = new ArrayList<Part>();
			ArrayList<Part> too = new ArrayList<Part>();
			ArrayList<Part> whee = new ArrayList<Part>();
			
			while ((s = br.readLine()) != null) {
				
				// System.out.println(s);
				Part p = new Part(s);
				if (p.id.isEmpty() || p.name.isEmpty()) {
					continue;
				}
				// System.out.println(p.id + ": " + p.name);
				System.out.println(p.generateMarkdown());
				writeToFile(("parts/" + p.id + ".md"), p.generateMarkdown());

				if (p.cat.equals("Electrical")) {
					elec.add(p);
				}
				// break;
			}
			
			String catElec = "# Electrical\n";
			catElec = catElec.concat("Electrical supplies and devices!\n\n");
			
			for(Part p : elec) {
				catElec = catElec.concat("\n| [" + p.subcat
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html) | "
						+ p.name + " | [" + p.pn + "]("
						+ p.link + ") | " + p.vendor + " | \n");
			}
			
			writeToFile("electrical.md", catElec);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void writeToFile(String fname, String contents) {


		File out = new File(fname);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(out));
			writer.write(contents);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
