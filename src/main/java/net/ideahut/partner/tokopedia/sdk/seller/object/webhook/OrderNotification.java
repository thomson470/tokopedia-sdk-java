package net.ideahut.partner.tokopedia.sdk.seller.object.webhook;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderNotification {
	
	public Long fs_id;
    public Long order_id;
    public Boolean accept_partial;
    public String invoice_num;
    public List<Product> products;
    public Customer customer;
    public Recipient recipient;
    public Long shop_id;
    public Long warehouse_id;
    public String shop_name;
    public Long payment_id;
    public Logistics logistics;
    public Amt amt;
    public DropshipperInfo dropshipper_info;
    public VoucherInfo voucher_info;
    public String device_type;
    public Long create_time;
    public Integer order_status;
    public Encryption encryption;
    public BundleDetail bundle_detail;
    public Map<String, String> custom_fields;
    //public CustomFields custom_fields;

	public static class Address {
	    public String address_full;
	    public String district;
	    public String city;
	    public String province;
	    public String country;
	    public String postal_code;
	    public Long district_id;
	    public Long city_id;
	    public Long province_id;
	    public String geo;
	}

	public static class Amt {
	    public Double ttl_product_price;
	    public Double shipping_cost;
	    public Double insurance_cost;
	    public Double ttl_amount;
	    public Double voucher_amount;
	    public Double toppoints_amount;
	}

	public static class Bundle {
	    public Long bundle_id;
	    public Long bundle_variant_id;
	    public String bundle_name;
	    public Double bundle_price;
	    public Integer bundle_quantity;
	    public Double bundle_subtotal_price;
	    public List<OrderDetail> order_detail;
	}

	public static class BundleDetail {
	    public Integer total_product;
	    public String product_bundling_icon;
	    public List<Bundle> bundle;
	    public List<NonBundle> non_bundle;
	}

	public static class Customer {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public String phone;
	    public String email;
	}

	//public class CustomFields {		
	//}

	public static class DropshipperInfo {
	    @JsonProperty("Name") 
	    public String name;
	    public String phone;
	}

	public static class Encryption {
	    public String secret;
	    public String content;
	}

	public static class Logistics {
	    public Long shipping_id;
	    public Long district_id;
	    public Long city_id;
	    public String geo;
	    public String shipping_agency;
	    public String service_type;
	}

	public static class NonBundle {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public Integer quantity;
	    public String notes;
	    public Double weight;
	    public Double total_weight;
	    public Double price;
	    public Double total_price;
	    public String currency;
	    public String sku;
	}

	public static class OrderDetail {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public Integer quantity;
	    public Double price;
	    public Double weight;
	    public Double total_weight;
	    public Double subtotal_price;
	    public String notes;
	    @JsonProperty("Currency") 
	    public String currency;
	    public String sku;
	    public Long bundle_id;
	    public String bundle_variant_id;
	}

	public static class Product {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public Integer quantity;
	    public String notes;
	    public Double weight;
	    public Double total_weight;
	    public Double price;
	    public Double total_price;
	    public String currency;
	    public String sku;
	}

	public static class Recipient {
	    @JsonProperty("Name") 
	    public String name;
	    public String phone;
	    public Address address;
	}

	public static class VoucherInfo {
	    public Integer voucher_type;
	    public String voucher_code;
	}


	
}
