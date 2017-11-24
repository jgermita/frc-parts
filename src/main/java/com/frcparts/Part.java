package com.frcparts;

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
	
	private String s		= "";
	
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
			
			System.arraycopy(params, 9, tags, 0, params.length - 9);
                        
                        if(tags == null) {
                            tags = new String[0];
                        }
		}
	}
	
	public String getCat() {
		return cat;
	}

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

	public String[] getTags() {
		return tags;
	}
	
	public String toString() {
                String answer = getCat() + "\t" + getSubcat() + "\t" + getName() + "\t" + getDesc() + "\t" + getCost() + "\t" + getPn() + "\t" + getVendor() + "\t" + getUrlLink() + "\t" + getId() + "\t";
                for(String s : tags) {
                    answer = answer + ", ";
                }
		return answer;
	}

}
