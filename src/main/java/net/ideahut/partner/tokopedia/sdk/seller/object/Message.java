package net.ideahut.partner.tokopedia.sdk.seller.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

	public String message_key;
    public Long msg_id;
    public Attributes attributes;
	
	public static class Attributes {
	    public Contact contact;
	    public String last_reply_msg;
	    public Long last_reply_time;
	    public Integer read_status;
	    public Integer unreads;
	    public Integer pin_status;
	    @JsonProperty("Name") 
	    public String name;
	    public String tag;
	    public String thumbnail;
	}

	public static class Contact {
	    public Long id;
	    public String role;
	    public Attributes attributes;
	}
	
}
