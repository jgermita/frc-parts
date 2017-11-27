package com.frcparts;

import java.util.Arrays;

public class Part {

	private String cat 		= "";
	private String subcat	= "";
	private String name		= "";
	private String desc		= "";
	private String cost		= "";
	private String pn		= "";
	private String vendor	= "";
	private String url		= "";
	private String id		= "";
	private String[] tags;
	private String source	= "";
	
	
	private String s		= "";
	
	
	
        /**
         * Constructor. 
         * @param in line from the parsed tsv file from the google sheet
         */
	public Part(String in) {
		try {
			s = in;

			String[] params = in.split("\t");

			//System.out.println(params.length + "\t" + s);;
			if(params.length > 0) {
				cat		= params[0];
				subcat	= params[1];
				name	= params[2];
				desc	= params[3];
				cost	= params[4];
				pn		= params[5];
				vendor	= params[6];
				url		= params[7];
				id		= params[8];
				

				if(id.equals("id")) {
					id = "-1";
				}
			}
			
			// extra part metadata
			if(params.length > 9) {
				source	= params[9];
				if(params.length > 10) {
					tags = Arrays.copyOfRange(params, 9, params.length-1);

					if(tags == null) { 
						tags = new String[0];
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
        /**
         * Gets the category of the part listing
         * @return 
         */
	public String getCat() {
		return cat;
	}

        /**
         * Gets the subcategory of the part listing
         * @return 
         */
	public String getSubcat() {
		return subcat;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getCost() {
		return cost;
	}

	public String getPn() {
		return pn;
	}

	public String getVendor() {
		return vendor;
	}

	public String getUrl() {
		
		
		return url;
	}
        
	public String getUrlLink() {
		if(this.getUrl().isEmpty()) {
			return "";
		}
		return "<a href=\"" + this.getUrl() + "\"  target=\"_blank\">" + this.getPn() + "</a>";
	}

	public String getId() {
		return id;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getSourceLink() {

		if(this.getSource().isEmpty()) {
			return "";
		}
		return "<a href=\"" + this.getSource() + "\" target=\"_blank\">Source</a>";
	}

	public String[] getTags() {
		return tags;
	}
	
	public String toString() {
                String answer = getCat() + "\t" + getSubcat() + "\t<a href=\"part.jsp?p=" + getId() + "\">" + getName() + "</a>\t<small>" + getDesc() + "</small>\t" + getUrlLink() + "\t" + getSourceLink() + "\t";

                if(tags != null) {
                    for(String s : tags) {
						
						if(s.isEmpty()) {
							continue;
						}
						
                        answer = answer + s + ", ";
                    }
                }

		return answer;
	}

}
