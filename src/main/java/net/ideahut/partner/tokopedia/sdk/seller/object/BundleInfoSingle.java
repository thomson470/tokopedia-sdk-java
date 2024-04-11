package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BundleInfoSingle {

	public List<BundleInfo> bundle_info;
    public String error;
    
	public static class BundleInfo {
	    public Long bundle_id;
	    public Long group_id;
	    @JsonProperty("Name") 
	    public String name;
	    @JsonProperty("Type") 
	    public Integer type;
	    public Integer status;
	    public Long shop_id;
	    public Integer start_time_unix;
	    public Integer stop_time_unix;
	    public List<BundleItem> bundle_item;
	    public Long warehouse_id;
	    public Integer quota;
	    public Integer original_quota;
	    public Integer max_order;
	    public Preorder preorder;
	}

	public static class BundleItem {
	    public Long product_id;
	    @JsonProperty("Name") 
	    public String name;
	    public String pic_url;
	    public Integer status;
	    public List<Selection> selection;
	    public List<Child> child;
	    public Double bundle_price;
	    public Double original_price;
	    public Integer stock;
	    public Integer min_order;
	    public String product_status;
	}

	public static class Child {
	    public Long product_id;
	    @JsonProperty("Name") 
	    public String name;
	    public String pic_url;
	    public Integer min_order;
	    public Double bundle_price;
	    public Double original_price;
	    public Integer stock;
	    public List<Long> option_id;
	    public Boolean is_buyable;
	}

	public static class Option {
	    public Long product_variant_option_id;
	    public Long unit_value_id;
	    public String value;
	    public String hex;
	    public Picture picture;
	}

	public static class Picture {
	    public String file_name;
	    public String file_path;
	    public String url;
	    public String url100;
	    public String url200;
	}

	public static class Preorder {
	    public String status;
	    public Integer status_num;
	    public String process_type;
	    public Integer process_type_num;
	    public String start_time;
	    public String end_time;
	    public Integer order_limit;
	    public Integer max_order;
	    public Integer process_day;
	    public Long process_time;
	}

	public static class Selection {
	    public Long product_variant_id;
	    public Long variant_id;
	    public Long variant_unit_id;
	    public Integer position;
	    public List<Option> option;
	    @JsonProperty("Name") 
	    public String name;
	    public String identifier;
	}
	
}
