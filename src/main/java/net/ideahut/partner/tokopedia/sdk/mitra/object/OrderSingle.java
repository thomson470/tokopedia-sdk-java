package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderSingle {

	public Long order_id;
    public Long buyer_id;
    public Long seller_id;
    public Long payment_id;
    public Boolean is_affiliate;
    public Boolean is_fulfillment;
    public OrderWarehouse order_warehouse;
    public Integer order_status;
    public String invoice_number;
    public String invoice_pdf;
    public String invoice_url;
    public Double open_amt;
    public Double lp_amt;
    public Double cashback_amt;
    public String info;
    public String comment;
    public Double item_price;
    public BuyerInfo buyer_info;
    public ShopInfo shop_info;
    public ShipmentFulfillment shipment_fulfillment;
    public Preorder preorder;
    public OrderInfo order_info;
    public OriginInfo origin_info;
    public PaymentInfo payment_info;
    public InsuranceInfo insurance_info;
    public Object hold_info;
    public Object cancel_request_info;
    public String create_time;
    public Object shipping_date;
    public String update_time;
    public String payment_date;
    public Object delivered_date;
    public Object est_shipping_date;
    public Object est_delivery_date;
    public Object related_invoices;
    public Object custom_fields;
    public PromoOrderDetail promo_order_detail;	
	
	public static class BuyerInfo {
	    public Long buyer_id;
	    public String buyer_fullname;
	    public String buyer_email;
	    public String buyer_phone;
	}

	public static class Destination {
	    public String receiver_name;
	    public String receiver_phone;
	    public String address_street;
	    public String address_district;
	    public String address_city;
	    public String address_province;
	    public String address_postal;
	    public Long customer_address_id;
	    public Long district_id;
	    public Long city_id;
	    public Long province_id;
	}

	public static class DestinationLoc {
	    public Double lat;
	    public Double lon;
	}

	public static class DiscountDetail {
	    public Double amount;
	    public String type;
	}

	public static class InsuranceInfo {
	    public Integer insurance_type;
	}

	public static class ItemDeliveredDeadline {
	    @JsonProperty("Time") 
	    public String time;
	    @JsonProperty("Valid") 
	    public Boolean valid;
	}

	public static class MetaData {
	    public Long warehouse_id;
	    public Long partner_id;
	    public Long shop_id;
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
	    public String country_name;
	    public Boolean is_fulfillment;
	}

	public static class OrderDetail {
	    public Long order_detail_id;
	    public Long product_id;
	    public String product_name;
	    public String product_desc_pdp;
	    public String product_desc_atc;
	    public Double product_price;
	    public Double subtotal_price;
	    public Double weight;
	    public Double total_weight;
	    public Integer quantity;
	    public Integer quantity_deliver;
	    public Integer quantity_reject;
	    public Boolean is_free_returns;
	    public Double insurance_price;
	    public Double normal_price;
	    public Long currency_id;
	    public Double currency_rate;
	    public Integer min_order;
	    public Long child_cat_id;
	    public String campaign_id;
	    public String product_picture;
	    public String snapshot_url;
	    public String sku;
	}

	public static class OrderHistory {
	    public String action_by;
	    public Integer hist_status_code;
	    public String message;
	    public String timestamp;
	    public String comment;
	    public String create_by;
	    public String update_by;
	}

	public static class OrderInfo {
	    public List<OrderDetail> order_detail;
	    public List<OrderHistory> order_history;
	    public Integer order_age_day;
	    public Integer shipping_age_day;
	    public Integer delivered_age_day;
	    public Boolean partial_process;
	    public ShippingInfo shipping_info;
	    public Destination destination;
	    public Boolean is_replacement;
	    public Integer replacement_multiplier;
	}

	public static class OrderWarehouse {
	    public Long warehouse_id;
	    public String fulfill_by;
	    public MetaData meta_data;
	}

	public static class OriginInfo {
	    public String sender_name;
	    public Long origin_province;
	    public String origin_province_name;
	    public Long origin_city;
	    public String origin_city_name;
	    public String origin_address;
	    public Long origin_district;
	    public String origin_district_name;
	    public String origin_postal_code;
	    public String origin_geo;
	    public String receiver_name;
	    public String destination_address;
	    public Long destination_province;
	    public Long destination_city;
	    public Long destination_district;
	    public String destination_postal_code;
	    public String destination_geo;
	    public DestinationLoc destination_loc;
	}

	public static class PaymentInfo {
	    public Long payment_id;
	    public String payment_ref_num;
	    public String payment_date;
	    public Integer payment_method;
	    public String payment_status;
	    public Long payment_status_id;
	    public String create_time;
	    public Long pg_id;
	    public String gateway_name;
	    public Double discount_amount;
	    public String voucher_code;
	    public Long voucher_id;
	}

	public static class Preorder {
	    public Long order_id;
	    public Integer preorder_type;
	    public Long preorder_process_time;
	    public String preorder_process_start;
	    public String preorder_deadline;
	    public Long shop_id;
	    public Long customer_id;
	}

	public static class PromoOrderDetail {
	    public Long order_id;
	    public Double total_cashback;
	    public Double total_discount;
	    public Double total_discount_product;
	    public Double total_discount_shipping;
	    public List<TotalDiscountDetail> total_discount_details;
	    public List<SummaryPromo> summary_promo;
	}

	public static class ShipmentFulfillment {
	    public Long id;
	    public Long order_id;
	    public String payment_date_time;
	    public Boolean is_same_day;
	    public String accept_deadline;
	    public String confirm_shipping_deadline;
	    public ItemDeliveredDeadline item_delivered_deadline;
	    public Boolean is_accepted;
	    public Boolean is_confirm_shipping;
	    public Boolean is_item_delivered;
	    public Integer fulfillment_status;
	}

	public static class ShippingInfo {
	    public Long sp_id;
	    public Long shipping_id;
	    public String logistic_name;
	    public String logistic_service;
	    public Double shipping_price;
	    public Double shipping_price_rate;
	    public Double shipping_fee;
	    public Double insurance_price;
	    public Double fee;
	    public Boolean is_change_courier;
	    public Long second_sp_id;
	    public Long second_shipping_id;
	    public String second_logistic_name;
	    public String second_logistic_service;
	    public Double second_agency_fee;
	    public Double second_insurance;
	    public Double second_rate;
	    public String awb;
	    public Integer autoresi_cashless_status;
	    public String autoresi_awb;
	    public Double autoresi_shipping_price;
	    public Integer count_awb;
	    public Boolean isCashless;
	    public Boolean is_fake_delivery;
	}

	public static class ShopInfo {
	    public Long shop_owner_id;
	    public String shop_owner_email;
	    public String shop_owner_phone;
	    public String shop_name;
	    public String shop_domain;
	    public Long shop_id;
	}

	public static class SummaryPromo {
	    public String name;
	    public Boolean is_coupon;
	    public Boolean show_cashback_amount;
	    public Boolean show_discount_amount;
	    public Double cashback_amount;
	    public Integer cashback_points;
	    public String type;
	    public Double discount_amount;
	    public List<DiscountDetail> discount_details;
	    public String invoice_desc;
	}

	public static class TotalDiscountDetail {
	    public Double amount;
	    public String type;
	}
	
}
