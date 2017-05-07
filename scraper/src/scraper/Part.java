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
		md = md.concat(desc + " \n");

		return md;

	}

}
