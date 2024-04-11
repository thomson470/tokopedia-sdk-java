package net.ideahut.partner.tokopedia.sdk.seller.object.webhook;

import java.util.List;

public class ProductChangesNotification {

	public Long fs_id;
    public List<ProductChangesDatum> product_changes_data;
	
	public static class ProductChangesDatum {
	    public String action;
	    public Long product_id;
	    public Long shop_id;
	    public Long warehouse_id;
	    public String value;
	    public String previous_value;
	    public Long update_time;
	    public Boolean is_default_warehouse;
	}
	
	public static class Action {
		public static final String stock_overwrite 		= "stock_overwrite";
		public static final String stock_decrement 		= "stock_decrement";
		public static final String stock_increment 		= "stock_increment";
		public static final String stock_alert_changes 	= "stock_alert_changes";
		public static final String price_changes 		= "price_changes";
		public static final String status_changes 		= "status_changes";
	}
	
}
