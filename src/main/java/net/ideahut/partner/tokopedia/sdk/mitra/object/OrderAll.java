package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class OrderAll {
	
	public String fs_id;
    public Long order_id;
    public Boolean is_cod_mitra;
    public Boolean accept_partial;
    public String invoice_ref_num;
    public List<Product> products;
    public List<ProductsFulfilled> products_fulfilled;
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
    public Long fulfill_by;
    public Long create_time;
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
	    public Double ttl_product_price;
	    public Double shipping_cost;
	    public Double insurance_cost;
	    public Double ttl_amount;
	    public Double voucher_amount;
	    public Double toppoints_amount;
	}

	public static class Buyer {
	    public Long id;
	    public String name;
	    public String phone;
	    public String email;
	}

	public static class CustomFields {
	    public String awb;
	}

	public static class DiscountDetail {
	    public Double amount;
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

	public static class Product {
	    public Long id;
	    public String name;
	    public Integer quantity;
	    public String notes;
	    public Double weight;
	    public Double total_weight;
	    public Double price;
	    public Double total_price;
	    public String currency;
	    public String sku;
	    public Boolean is_wholesale;
	}

	public static class ProductsFulfilled {
	    public Long product_id;
	    public Integer quantity_deliver;
	    public Integer quantity_reject;
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

	public static class Recipient {
	    public String name;
	    public String phone;
	    public Address address;
	}

	public static class SummaryPromo {
	    public String name;
	    public Boolean is_coupon;
	    public Boolean show_cashback_amount;
	    public Boolean show_discount_amount;
	    public Double cashback_amount;
	    public Double cashback_points;
	    public String type;
	    public Double discount_amount;
	    public List<DiscountDetail> discount_details;
	    public String invoice_desc;
	}

	public static class TotalDiscountDetail {
	    public Double amount;
	    public String type;
	}

	public static class VoucherInfo {
	    public String voucher_code;
	    public Integer voucher_type;
	}
	
}
