package scraper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;


public class scraper {

	public static void main(String[] args) {

		String url = "https://docs.google.com/spreadsheets/d/1x07PQ0yxtrQXogLbfGt5_W_RXgm1O1TL-T5Hijq8WTM/pub?gid=0&single=true&output=tsv";
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

			String s = "";
			while ((s = br.readLine()) != null) {
				// System.out.println(s);
				Part p = new Part(s);
				if (p.id.isEmpty() || p.name.isEmpty()) {
					continue;
				}
				// System.out.println(p.id + ": " + p.name);
				System.out.println(p.generateMarkdown());
				writeToFile(("parts/" + p.id + ".md"), p.generateMarkdown());
				// break;

			}

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
