package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.Map;

public class SlashPriceInput {

	public Long product_id;
    public Integer discounted_price;
    public Integer discount_percentage;
    public Long start_time_unix;
    public Long end_time_unix;
    public Integer max_order;
    public Map<String, SlashPriceWarehouse> slash_price_warehouses;
     
    public static class SlashPriceWarehouse {
    	public Long warehouse_id;
        public Integer max_order;
    }
	
}
