package net.ideahut.partner.tokopedia.sdk.seller.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ConfirmShipping;
import net.ideahut.partner.tokopedia.sdk.seller.object.FulfillmentOrder;
import net.ideahut.partner.tokopedia.sdk.seller.object.Order;
import net.ideahut.partner.tokopedia.sdk.seller.object.OrderReject;
import net.ideahut.partner.tokopedia.sdk.seller.object.OrderSingle;
import net.ideahut.partner.tokopedia.sdk.seller.object.RequestPickup;
import net.ideahut.partner.tokopedia.sdk.seller.object.ResolutionTicket;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

/*
 STATUS CODE
 -----------
	0	: Seller cancel order.
	3	: Order Reject Due Empty Stock.
	5	: Order Canceled by Fraud
	6	: Order Rejected (Auto Cancel Out of Stock)
	10	: Order rejected by seller.
	15	: Instant Cancel by Buyer.
	100	: Order Created.
	103	: Wait for payment confirmation from third party.
	220	: Payment verified, order ready to process.
	221	: Waiting for partner approval.
	400	: Seller accept order.
	450	: Waiting for pickup.
	500	: Order shipment.
	501	: Status changed to waiting resi have no input.
	520	: Invalid shipment reference number (AWB).
	530	: Requested by user to correct invalid entry of shipment reference number.
	540	: Delivered to Pickup Point.
	550	: Return to Seller.
	600	: Order delivered.
	601	: Buyer open a case to finish an order.
	690	: Fraud Review
	700	: Order finished.
 */

public class OrderApi extends Tokopedia.Api {

	protected OrderApi(Tokopedia tokopedia) {
		super(tokopedia);
	}

	public TokpedResponse<List<Order>> getAllOrders(TokpedInquiry inquiry) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.notNull(inquiry.from_date, "from_date required");
		Assert.notNull(inquiry.to_date, "to_date required");
		Integer page = inquiry.page;
		if (page == null || page < 1) {
			page = 1;
		}
		Integer per_page = inquiry.per_page;
		if (per_page == null || per_page < 1) {
			per_page = 10;
		}
		String query = "fs_id=" + fs_id + "&from_date=" + inquiry.from_date + "&to_date=" + inquiry.to_date + "&page=" + page + "&per_page=" + per_page;
		if (inquiry.shop_id != null) {
			query += "&shop_id=" + inquiry.shop_id;
		}
		if (inquiry.warehouse_id != null) {
			query += "&warehouse_id=" + inquiry.warehouse_id;
		}
		if (inquiry.status != null) {
			query += "&status=" + inquiry.status;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/order/list?" + query);		
		return execute(new TypeReference<List<Order>>() {}, request);
	}
	
	public TokpedResponse<OrderSingle> getSingleOrder(Long order_id, String invoice_num) {
		Assert.isTrue(order_id != null || invoice_num != null, "order_id or invoice_num required");
		String query = order_id != null && order_id > 0 ? "order_id=" + order_id : "invoice_num=" + invoice_num;		
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/fs/" + fs_id + "/order?" + query);
		return execute(OrderSingle.class, request);
	}
	
	public TokpedResponse<String> getShippingLabel(Long order_id, Boolean printed) {
		Assert.notNull(order_id, "order_id required");
		boolean isPrinted = Boolean.TRUE.equals(printed);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/order/" + order_id + "/fs/" + fs_id + "/shipping-label?printed=" + (isPrinted ? 1 : 0));
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		TokpedResponse<String> result = new TokpedResponse<String>();
		if (response.data instanceof byte[]) {
			result.header = new TokpedResponse.Header("00", "OK");
			result.data = new String(response.data);
		}
		return result;
	}
	
	public TokpedResponse<String> acceptOrder(Long order_id) {
		Assert.notNull(order_id, "order_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/order/" + order_id + "/fs/" + fs_id + "/ack")
		.method(TokpedRequest.Method.POST);
		return execute(String.class, request);
	}
	
	public TokpedResponse<String> rejectOrder(Long order_id, OrderReject order_reject) {
		Assert.notNull(order_id, "order_id required");
		Assert.notNull(order_reject, "order_reject required");
		Assert.notNull(order_reject.reason_code, "reason_code required");
		Assert.hasLength(order_reject.reason, "reason required");
		byte[] json = Mapper.writeValueAsBytes(order_reject);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/order/" + order_id + "/fs/" + fs_id + "/nack")
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(String.class, request);
	}
	
	public TokpedResponse<String> confirmShipping(Long order_id, ConfirmShipping confirm_shipping) {
		Assert.notNull(order_id, "order_id required");
		Assert.notNull(confirm_shipping, "confirm_shipping required");
		Assert.notNull(confirm_shipping.order_status, "order_status required");
		Assert.hasLength(confirm_shipping.shipping_ref_num, "shipping_ref_num required");
		byte[] json = Mapper.writeValueAsBytes(confirm_shipping);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/order/" + order_id + "/fs/" + fs_id + "/status")
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(String.class, request);
	}
	
	public TokpedResponse<RequestPickup> requestPickup(Long order_id, Long shop_id) {
		Assert.notNull(order_id, "order_id required");
		Assert.notNull(shop_id, "shop_id required");
		ObjectNode jnode = Mapper.createObjectNode();
		jnode.put("order_id", order_id);
		jnode.put("shop_id", shop_id);
		byte[] json = Mapper.writeValueAsBytes(jnode);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v1/fs/" + fs_id + "/pick-up")
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(RequestPickup.class, request);
	}
	
	public TokpedResponse<FulfillmentOrder> getFulfillmentOrder(TokpedInquiry inquiry) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.isTrue(inquiry.order_id != null || inquiry.shop_id != null || inquiry.warehouse_id != null, "order_id/shop_id/warehouse_id required");
		Integer per_page = inquiry.per_page != null ? inquiry.per_page : 10;
		String query = "per_page=" + per_page;
		if (inquiry.order_id != null) {
			query += "&order_id=" + inquiry.order_id;
		}
		else if (inquiry.shop_id != null) {
			query += "&shop_id=" + inquiry.shop_id;
		}
		else if (inquiry.warehouse_id != null) {
			query += "&warehouse_id=" + inquiry.warehouse_id;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/fs/" + fs_id + "/fulfillment_order?" + query);
		return execute(FulfillmentOrder.class, request);
	}
	
	public TokpedResponse<ResolutionTicket> getResolutionTicket(String shop_id, String start_date, String end_date) {
		Assert.hasLength(shop_id, "shop_id required");
		Assert.notNull(start_date, "start_date required");
		Assert.notNull(end_date, "end_date required");
		TokpedRequest request = TokpedRequest.create()
		.path("/resolution/v1/fs/" + fs_id + "/ticket?from_date=" + start_date + "&to_date=" + end_date);
		return execute(ResolutionTicket.class, request);
	}

}
