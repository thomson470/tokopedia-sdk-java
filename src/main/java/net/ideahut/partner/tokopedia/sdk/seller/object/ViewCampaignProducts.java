package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewCampaignProducts {

	public ArrayList<Product> products;
    public Integer total_product;
    
	public static class AdditionalCartInfo {
	    public TimerDetail timer_detail;
	}

	public static class Campaign {
	    public Long campaignID;
	    public Long slash_price_product_id;
	    public Integer discount_percentage;
	    public String discounted_price;
	    public String original_price;
	    public Long custom_stock;
	    public Integer campaign_status;
	    public String start_date;
	    public String end_date;
	    public String campaign_type_name;
	    public String campaign_short_name;
	    public Integer max_order;
	    public String discounted_price_fmt;
	    public String original_price_fmt;
	    public Integer original_stock;
	    public Integer min_order;
	    public AdditionalCartInfo additional_cart_info;
	    public StockWording stock_wording;
	}

	public static class Product {
	    @JsonProperty("ID") 
	    public Long iD;
	    public String price;
	    public Shop shop;
	    public Campaign campaign;
	    public Integer max_order;
	    public String price_unfmt;
	    public Integer min_order;
	}

	public static class Shop {
	}

	public static class StockWording {
	}

	public static class TimerDetail {
		
	}


	
}
