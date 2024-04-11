package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewSlashPrice {
	
	public Long slash_price_product_id;
    public Long product_id;
    @JsonProperty("Name") 
    public String name;
    public Price price;
    public Integer stock;
    public String url;
    public String sku;
    public Double discounted_price;
    public Integer discounted_percentage;
    public Integer max_order;
    public String start_date;
    public String end_date;
    public List<Warehouse> warehouses;
    public Long slash_price_status_id;
	
	public static class Price {
	    public Integer min;
	    public String min_formated;
	    public Integer max;
	    public String max_formated;
	}

	public static class Warehouse{
	    public Long warehouse_id;
	    public String warehouse_name;
	    public String warehouse_location;
	    public Integer warehouse_stock;
	    public Integer initial_quota;
	    public Integer max_order;
	    public Long event_id;
	}
	
}
