package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BundleInfoList {

	public List<BundleListInfo> bundle_list_info;
    public Boolean is_last_page;
    public Long last_group_id;
	
	public static class BundleListInfo {
	    public Long group_id;
	    public Long bundle_id;
	    @JsonProperty("Name") 
	    public String name;
	    @JsonProperty("Type") 
	    public Integer type;
	    public Integer status;
	    public Long shop_id;
	    public Long start_time_unix;
	    public Long stop_time_unix;
	    public List<BundleListItem> bundle_list_item;
	    public Integer sold;
	    public Long total_bundle_group;
	}

	public static class BundleListItem {
	    public Long bundle_id;
	    public Long product_id;
	    @JsonProperty("Name") 
	    public String name;
	    public String pic_url;
	    public String product_url;
	    public Integer status;
	    public Integer quantity;
	    public String child_ids;
	    public Integer discount_percentage;
	    public Integer min_order;
	}
	
}
