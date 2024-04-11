package net.ideahut.partner.tokopedia.sdk.mitra.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.mitra.object.OrderAll;
import net.ideahut.partner.tokopedia.sdk.mitra.object.OrderReject;
import net.ideahut.partner.tokopedia.sdk.mitra.object.OrderSingle;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class OrderMitraApi extends Tokopedia.Api {

	protected OrderMitraApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<List<OrderAll>> getAllOrders(TokpedInquiry inquiry) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.notNull(inquiry.from_date, "from_date required");
		Assert.notNull(inquiry.to_date, "to_date required");
		Integer page = inquiry.page != null ? inquiry.page : 1;
		Integer per_page = inquiry.per_page != null ? inquiry.per_page : 10;
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
		return execute(new TypeReference<List<OrderAll>>() {}, request);
	}
	
	public TokpedResponse<OrderSingle> getSingleOrder(Long order_id, String invoice_num) {
		Assert.isTrue(order_id != null || invoice_num != null, "order_id or invoice_num required");
		String query = order_id != null ? "order_id=" + order_id : "invoice_num=" + invoice_num;		
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/fs/" + fs_id + "/order?" + query);
		return execute(OrderSingle.class, request);
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
	
}
