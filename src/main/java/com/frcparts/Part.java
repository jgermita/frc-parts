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
			source	= params[9];
                        
			if(id.equals("id")) {
				id = "-1";
			}

			tags = Arrays.copyOfRange(params, 10, params.length-1);

			if(tags == null) { 
				tags = new String[0];
			}

                        
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
            
            return "<a href=\"" + this.getUrl() + "\">Link</a>";
        }

	public String getId() {
		return id;
	}
	
	public String getSource() {
		return source;
	}

	public String[] getTags() {
		return tags;
	}
	
	public String toString() {
                String answer = getCat() + "\t" + getSubcat() + "\t" + getName() + "\t" + getDesc() + "\t" + getCost() + "\t" + getPn() + "\t" + getVendor() + "\t" + getUrlLink() + "\t" + getId() + "\t";

                if(tags != null) {
                    for(String s : tags) {

                        answer = answer + s + ", ";
                    }
                }

		return answer;
	}

}
