package net.ideahut.partner.tokopedia.sdk.seller.object;

public class ReplyResult {

	public Long msg_id;
    public Long sender_id;
    public Integer role;
    public Long reply_time;
    public String from;
    public String msg;
    public Attachment attachment;
    public FallbackAttachment fallback_attachment;
    
	public static class Attachment {
	    public QuotationProfile quotation_profile;
	}

	public static class FallbackAttachment {
	    public String html;
	    public String message;
	}

	public static class QuotationProfile {
	    public String thumbnail;
	    public String identifier;
	    public String title;
	    public String price;
	    public String url;
	}
	
}
