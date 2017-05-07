package scraper;


public class Part {

	public String	cat, subcat, name, desc, price, pn, vendor, link, id;
	String			tags[];
	
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

	}

	public String generateMarkdown() {

		String md = "";

		md = md.concat("# " + name + "\n");
		md = md.concat("## " + cat + "/" + subcat + "\n");
		md = md.concat("Description: \t" + desc + " \n");

		md = md.concat("\n| Vendor | " + vendor + " | \n");
		md = md.concat("| Part # | [" + pn + "](" + link + ") | \n");
		md = md.concat("| Unit Price | " + price + " | \n");

		return md;

	}

}
