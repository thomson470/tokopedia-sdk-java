package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

public class BundleCreate {

	public Bundle bundle;
	
	public static class Bundle{
	    public String bundle_name;
	    public Integer bundle_type;
	    public Integer bundle_status;
	    public Integer max_order;
	    public Long start_time_unix;
	    public Long stop_time_unix;
	    public List<Long> warehouse_id;
	    public List<BundleItem> bundle_items;
	}

	public static class BundleItem {
	    public Long product_id;
	    public Integer status;
	    public Integer min_order;
	    public Double bundle_price;
	    public List<Child> children;
	}

	public static class Child {
	    public Long variant_id;
	    public Double variant_price;
	}
	
}
