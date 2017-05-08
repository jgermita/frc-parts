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
			ArrayList<Part> tool = new ArrayList<Part>();
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
				} else if (p.cat.equals("Gears")) {
					gear.add(p);
				} else if (p.cat.equals("Hardware")) {
					hard.add(p);
				} else if (p.cat.equals("Materials")) {
					mate.add(p);
				} else if (p.cat.equals("Misc")) {
					misc.add(p);
				} else if (p.cat.equals("Pneumatics")) {
					pneu.add(p);
				} else if (p.cat.equals("Pulleys/Belt")) {
					pull.add(p);
				} else if (p.cat.equals("Sprockets/Chain")) {
					spro.add(p);
				} else if (p.cat.equals("Tools")) {
					tool.add(p);
				} else if (p.cat.equals("Wheels")) {
					whee.add(p);
				}
				// break;
			}

			// ////////////////
			
			String catElec = "# Electrical\n";
			catElec = catElec.concat("Electrical supplies and devices!\n\n");
			
			for(Part p : elec) {
				catElec = catElec.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "]("
 + p.link + ") | " + p.vendor + " |");
			}
			
			writeToFile("electrical.md", catElec);

			// ////////////////

			String catGear = "# Gears\n";
			catElec = catElec.concat("Gears of various bores, DPs, and tooth counts!\n\n");

			for (Part p : gear) {
				catGear = catGear.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("gears.md", catGear);

			// ////////////////

			String catHard = "# Hardware\n";
			catElec = catElec.concat("Screws, nuts, bearings, bushings, etc!\n\n");

			for (Part p : hard) {
				catHard = catHard.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("hardware.md", catHard);

			// ////////////////

			String catMate = "# Materials\n";
			catElec = catElec.concat("Raw materials in various shapes!\n\n");

			for (Part p : mate) {
				catMate = catMate.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("materials.md", catMate);

			// ////////////////

			String catMisc = "# Miscellaneous\n";
			catElec = catElec.concat("Other odds and ends!\n\n");

			for (Part p : misc) {
				catMisc = catMisc.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("misc.md", catMisc);

			// ////////////////

			String catPneu = "# Pneumatics\n";
			catElec = catElec.concat("Air powered!\n\n");

			for (Part p : pneu) {
				catPneu = catPneu.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("pneumatics.md", catPneu);

			// ////////////////

			String catPull = "# Pulleys / Belts\n";
			catElec = catElec.concat("HTD, GT2, etc belts and pulleys!\n\n");

			for (Part p : pull) {
				catPull = catPull.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("pulleysbelt.md", catPull);

			// ////////////////

			String catSpro = "# Sprockets / Chain\n";
			catElec = catElec.concat("25 and 35 chain and sprockets!\n\n");

			for (Part p : spro) {
				catSpro = catSpro.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("sprocketschain.md", catSpro);

			// ////////////////

			String catTool = "# Tools\n";
			catElec = catElec.concat("Tools of the trade!\n\n");

			for (Part p : tool) {
				catTool = catTool.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("tools.md", catTool);

			// ////////////////

			String catWhee = "# Wheels\n";
			catWhee = catWhee.concat("The wheels on the bot go round and round!\n\n");

			for (Part p : whee) {
				catWhee = catWhee.concat("\n| " + p.subcat + " | [" + p.name
						+ "](https://jgermita.github.io/frc-parts/parts/" + p.id + ".html)"
						+ " | [" + p.pn + "](" + p.link + ") | " + p.vendor + " |");
			}

			writeToFile("wheels.md", catWhee);

			// ////////////////

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
