package scraper;

import java.util.Date;


public class Part {

	public String	cat, subcat, name, desc, price, pn, vendor, link, id;
	String			tags[]	= new String[10];
	
	public Part(String in) {

		String split[] = in.split("\t");

		cat = split[0];
		subcat = split[1];
		name = split[2];
		desc = split[3];
		price = split[4];
		pn = split[5];
		vendor = split[6];
		link = split[7];
		id = split[8];

		// System.out.println((split.length) - 9);

		for (int i = 0; i < 10; i++) {
			tags[i] = "";
		}
		if (split.length > 9) {
			for (int i = 0; i < ((split.length) - 9); i++) {
				if (split[9 + i] == null) {
					break;
				}
				tags[i] = split[9 + i];

			}
		}


	}

	public String generateMarkdown() {

		String md = "---\ntitle: " + name + "\n---\n\n";

		md = md.concat("# " + name + "\n");
		md = md.concat("## " + cat + " / " + subcat + "\n");
		md = md.concat("Description: \t" + desc + " \n");

		md = md.concat("\n| Vendor | " + vendor + " | \n");
		md = md.concat("| Part # | [" + pn + "](" + link + ") | \n");
		md = md.concat("| Unit Price | " + price + " | \n");
		md = md.concat("| Tags: | ");

		for (int i = 0; i < tags.length; i++) {
			if (tags[i].isEmpty()) {
				break;
			}

			
			md = md.concat("[" + tags[i] + "](https://jgermita.github.io/frc-parts/search/?q=" + tags[i]+ ")" + ", ");
		}
		md = md.concat(" | \n\n");

		md = md.concat("Last updated: " + (new Date(System.currentTimeMillis())));

		return md;

	}

}
