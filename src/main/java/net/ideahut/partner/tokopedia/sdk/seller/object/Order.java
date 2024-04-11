package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	
	public String fs_id;
    public Long order_id;
    public Boolean is_cod_mitra;
    public Boolean accept_partial;
    public String invoice_ref_num;
    public Boolean have_product_bundle;
    public List<Product> products;
    public List<ProductsFulfilled> products_fulfilled;
    public BundleDetail bundle_detail;
    public String device_type;
    public Buyer buyer;
    public Long shop_id;
    public Long payment_id;
    public Recipient recipient;
    public Logistics logistics;
    public Amt amt;
    public DropshipperInfo dropshipper_info;
    public VoucherInfo voucher_info;
    public Integer order_status;
    public Long warehouse_id;
    public Integer fulfill_by;
    public Integer create_time;
    public CustomFields custom_fields;
    public PromoOrderDetail promo_order_detail;

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
	    public Integer ttl_product_price;
	    public Integer shipping_cost;
	    public Integer insurance_cost;
	    public Integer ttl_amount;
	    public Integer voucher_amount;
	    public Integer toppoints_amount;
	}

	public static class Bundle {
	    public Long bundle_id;
	    public String bundle_variant_id;
	    public String bundle_name;
	    public Integer bundle_price;
	    public Integer bundle_quantity;
	    public Integer bundle_subtotal_price;
	    public List<OrderDetail> order_detail;
	}

	public static class BundleDetail {
	    public List<Bundle> bundle;
	    public List<NonBundle> non_bundle;
	    public Integer total_product;
	}

	public static class Buyer {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public String phone;
	    public String email;
	}

	public static class CustomFields {
	    public String awb;
	}

	public static class DiscountDetail {
	    public Integer amount;
	    @JsonProperty("Type") 
	    public String type;
	}

	public static class DropshipperInfo {
	}

	public static class Logistics {
	    public Long shipping_id;
	    public Long district_id;
	    public Long city_id;
	    public Long province_id;
	    public String geo;
	    public String shipping_agency;
	    public String service_type;
	}

	public static class NonBundle {
	    public Long order_dtl_id;
	    public Long order_id;
	    public Long product_id;
	    public String product_name;
	    public String product_desc;
	    public Integer quantity;
	    public Integer product_price;
	    public Double product_weight;
	    public Double total_weight;
	    public Integer subtotal_price;
	    public String notes;
	    public Integer finsurance;
	    public Integer returnable;
	    public Long child_cat_id;
	    public Long currency_id;
	    public Integer insurance_price;
	    public Integer normal_price;
	    public Integer currency_rate;
	    public String prod_pic;
	    public Integer min_order;
	    public Integer must_insurance;
	    public Integer condition;
	    public Long campaign_id;
	    public String sku;
	    public Boolean is_slash_price;
	    public String oms_detail_data;
	    public String thumbnail;
	}

	public static class OrderDetail {
	    public Long order_dtl_id;
	    public Long order_id;
	    public Long product_id;
	    public String product_name;
	    public String product_desc;
	    public Integer quantity;
	    public Integer product_price;
	    public Double product_weight;
	    public Double total_weight;
	    public Integer subtotal_price;
	    public String notes;
	    public Integer finsurance;
	    public Integer returnable;
	    public Long child_cat_id;
	    public Long currency_id;
	    public Integer insurance_price;
	    public Integer normal_price;
	    public Integer currency_rate;
	    public String prod_pic;
	    public Integer min_order;
	    public Integer must_insurance;
	    public Integer condition;
	    public Long campaign_id;
	    public String sku;
	    public Boolean is_slash_price;
	    public String oms_detail_data;
	    public String thumbnail;
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
	    public Integer price;
	    public Integer total_price;
	    public String currency;
	    public String sku;
	    public Boolean is_wholesale;
	}

	public static class ProductsFulfilled {
	    public Long product_id;
	    public Integer quantity_deliver;
	    public Integer quantity_reject;
	}

	public static class PromoOrderDetail{
	    public Long order_id;
	    public Integer total_cashback;
	    public Integer total_discount;
	    public Integer total_discount_product;
	    public Integer total_discount_shipping;
	    public List<TotalDiscountDetail> total_discount_details;
	    public List<SummaryPromo> summary_promo;
	}

	public static class Recipient {
	    @JsonProperty("Name") 
	    public String name;
	    public String phone;
	    public Address address;
	}

	public static class SummaryPromo {
	    @JsonProperty("Name") 
	    public String name;
	    public Boolean is_coupon;
	    public Boolean show_cashback_amount;
	    public Boolean show_discount_amount;
	    public Double cashback_amount;
	    public Integer cashback_points;
	    @JsonProperty("Type") 
	    public String type;
	    public Double discount_amount;
	    public List<DiscountDetail> discount_details;
	    public String invoice_desc;
	}

	public static class TotalDiscountDetail {
	    public Integer amount;
	    @JsonProperty("Type") 
	    public String type;
	}

	public static class VoucherInfo {
	    public String voucher_code;
	    public Integer voucher_type;
	}

	
}
