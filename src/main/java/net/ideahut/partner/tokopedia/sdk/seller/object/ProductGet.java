package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductGet {
	
	public Long shop_id;
    public Long user_id;
    public String shop_name;
    public String logo;
    public String shop_url;
    public Integer is_open;
    public Integer status;
    public String date_shop_created;
    public String domain;
    public ArrayList<Long> admin_id;
    public String reason;
    public Long district_id;
    public String province_name;
    public ArrayList<Warehouse> warehouses;
    public Boolean subscribe_tokocabang;
    public Boolean is_mitra;

	public static class PartnerId {
	    @JsonProperty("Int64") 
	    public Integer int64;
	    @JsonProperty("Valid") 
	    public Boolean valid;
	}

	public static class ShopId {
	    @JsonProperty("Int64") 
	    public Integer int64;
	    @JsonProperty("Valid") 
	    public Boolean valid;
	}

	public static class Warehouse {
	    public Long warehouse_id;
	    public PartnerId partner_id;
	    public ShopId shop_id;
	    public String warehouse_name;
	    public Long district_id;
	    public String district_name;
	    public Long city_id;
	    public String city_name;
	    public Long province_id;
	    public String province_name;
	    public Integer status;
	    public String postal_code;
	    public Integer is_default;
	    public String latlon;
	    public String latitude;
	    public String longitude;
	    public String email;
	    public String address_detail;
	    public String phone;
	    public String wh_type;
	}
	
}
