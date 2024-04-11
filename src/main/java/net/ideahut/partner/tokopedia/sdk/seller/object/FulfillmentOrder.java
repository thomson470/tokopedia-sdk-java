package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FulfillmentOrder {
	
	public List<OrderDatum> order_data;
    public Long next_order_id;
    public Long first_order_id;

	public static class BookingData {
	    public Long order_id;
	    public String booking_code;
	    public Integer booking_status;
	}

	public static class Cod {
		
	}

	public static class DropShipper {
	    public Long order_id;
	    public String dropship_name;
	    public String dropship_telp;
	}

	public static class ItemDeliveredDeadline {
	    @JsonProperty("Time") 
	    public String time;
	    @JsonProperty("Valid") 
	    public Boolean valid;
	}

	public static class Kelontong {
		
	}

	public static class Now {
		
	}

	public static class Order {
	    public Long order_id;
	    public Long buyer_id;
	    public Long seller_id;
	    public Long payment_id;
	    public Integer order_status;
	    public String invoice_number;
	    public String invoice_pdf_link;
	    public Integer open_amt;
	    public Integer payment_amt_cod;
	}

	public static class OrderDatum {
	    public Order order;
	    public List<OrderHistory> order_history;
	    public List<OrderDetail> order_detail;
	    public DropShipper drop_shipper;
	    public TypeMeta type_meta;
	    public OrderShipmentFulfillment order_shipment_fulfillment;
	    public BookingData booking_data;
	}

	public static class OrderDetail {
	    public Long order_detail_id;
	    public Long product_id;
	    public String product_name;
	    public Integer quantity;
	    public Double product_price;
	    public Double insurance_price;
	}

	public static class OrderHistory {
	    public String order_hist_id;
	    public Integer status;
	    public String shipping_date;
	    public Integer create_by;
	}

	public static class OrderShipmentFulfillment {
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

	public static class Ppp {
		
	}

	public static class Sampai {
		
	}

	public static class TradeIn {
		
	}

	public static class TypeMeta {
	    public Kelontong kelontong;
	    public Cod cod;
	    public Sampai sampai;
	    public Now now;
	    public Ppp ppp;
	    public TradeIn trade_in;
	    public VehicleLeasing vehicle_leasing;
	}

	public static class VehicleLeasing {
		
	}
	
}
