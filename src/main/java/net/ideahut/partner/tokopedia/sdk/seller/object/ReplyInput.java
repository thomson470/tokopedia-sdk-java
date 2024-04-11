package net.ideahut.partner.tokopedia.sdk.seller.object;

public class ReplyInput {

	public Long shop_id;
    public Integer attachment_type;
    public Payload payload;
    public String message;
	
	public static class Payload {
	    public String thumbnail;
	    public String identifier;
	    public String title;
	    public String price;
	    public String url;
	}
	
}
