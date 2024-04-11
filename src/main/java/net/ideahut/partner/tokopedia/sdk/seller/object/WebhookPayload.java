package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookPayload {

	public Long fs_id;
    public Integer order_status;
    public Long order_id;
    public Long shop_id;
    public Long warehouse_id;
    public List<ProductDetail> product_details;	
	
	public static class ProductDetail{
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public String notes;
	    public String currency;
	    public Double weight;
	    public Double total_weight;
	    public Double price;
	    public Double total_price;
	    public Integer quantity;
	    public String sku;
	}
	
}
