package net.ideahut.partner.tokopedia.sdk.seller.object.webhook;

public class CampaignNotification {

	public String action;
    public Long fs_id;
    public Long product_id;
    public Long shop_id;
    public Double original_price;
    public Double discounted_price;
    public Double discount_percentage;
    public String start_date;
    public String end_date;
    
    public static class Action {
		public static final String slash_price_active 	= "slash_price_active";
		public static final String slash_price_inactive = "slash_price_inactive";
		public static final String flash_sale_active 	= "flash_sale_active";
		public static final String flash_sale_inactive 	= "flash_sale_inactive";
	}
	
}
