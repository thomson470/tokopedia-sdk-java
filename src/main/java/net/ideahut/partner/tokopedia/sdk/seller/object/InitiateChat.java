package net.ideahut.partner.tokopedia.sdk.seller.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitiateChat {

	public Contact contact;
    public Boolean is_success;
    public Long msg_id;
    
	public static class Attributes {
	    @JsonProperty("Name") 
	    public String name;
	    public String tag;
	    public String thumbnail;
	    public Boolean is_gold;
	    public Boolean is_official;
	}

	public static class Contact {
	    public Long id;
	    public String role;
	    public Attributes attributes;
	}
	
}
