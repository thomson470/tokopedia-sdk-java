package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowcaseDetail {

	public ArrayList<ShowcaseDetail> showcase;
    public ArrayList<ShowcaseGroup> showcase_group;
    public Boolean use_ace;
    public ArrayList<Integer> showcase_without_ace;
    public String prev_link;
    public String next_link;

	public static class Showcase {
	    public Integer id;
	    @JsonProperty("Name") 
	    public String name;
	    public String alias;
	    public String uri;
	    public Integer product_count;
	    public Boolean is_highlighted;
	    public String badge;
	    public Integer ace_default_sort;
	}

	public static class ShowcaseGroup{
	    public Integer id;
	    @JsonProperty("Name") 
	    public String name;
	    public String alias;
	    public String uri;
	    public Integer product_count;
	    public Boolean is_highlighted;
	    public String badge;
	    public Integer ace_default_sort;
	}


	
}
