package net.ideahut.partner.tokopedia.sdk.seller.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Shop;
import net.ideahut.partner.tokopedia.sdk.seller.object.ShowcaseDetail;
import net.ideahut.partner.tokopedia.sdk.seller.object.UpdateShopStatus;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class ShopApi extends Tokopedia.Api {

	protected ShopApi(Tokopedia tokopedia) {
		super(tokopedia);
	}

	public TokpedResponse<List<Shop>> getShopInfo(TokpedInquiry inquiry) {
		String query = "";
		if (inquiry != null) {
			if (inquiry.page != null) {
				query += "page=" + inquiry.page + "&";
			}
			if (inquiry.per_page != null) {
				query += "per_page=" + inquiry.per_page + "&";
			}
			if (inquiry.shop_id != null) {
				query += "shop_id=" + inquiry.shop_id + "&";
			}
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/shop/fs/" + fs_id + "/shop-info?" + query);		
		return execute(new TypeReference<List<Shop>>() {}, request);
	}
	
	public TokpedResponse<String> updateShopStatus(UpdateShopStatus update_shop_status) {
		Assert.notNull(update_shop_status, "update_shop_status required");
		Assert.notNull(update_shop_status.shop_id, "shop_id required");
		Assert.hasLength(update_shop_status.action, "action required"); // open atau close
		Assert.hasLength(update_shop_status.start_date, "start_date required");
		Assert.hasLength(update_shop_status.end_date, "end_date required");
		byte[] json = Mapper.writeValueAsBytes(update_shop_status);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/shop/fs/" + fs_id + "/shop-status")	
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(String.class, request);
	}
	
	public TokpedResponse<ShowcaseDetail> getShowcase(Long shop_id, Integer page, Integer page_count, Boolean hide_zero, String display) {
		if (page == null) {
			page = 1;
		}
		if (page_count == null) {
			page_count = 10;
		}
		String query = "page=" + page + "&page_count=" + page_count;
		if (shop_id != null) {
			query += "&shop_id=" + shop_id;
		}
		if (hide_zero != null) {
			query += "&shop_id=" + (Boolean.TRUE.equals(hide_zero) ? 1 : 0);
		}
		if (display != null) {
			query += "&display=" + display;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/showcase/fs/" + fs_id + "/get?" + query);		
		return execute(ShowcaseDetail.class, request);
	}
	
	public TokpedResponse<String> createShowcase(Long shop_id, String name) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.hasLength(name, "name required");
		ObjectNode jdata = Mapper.createObjectNode();
		jdata.put("Name", name);
		byte[] json = Mapper.writeValueAsBytes(jdata);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/showcase/fs/" + fs_id + "/create?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(String.class, request);
	}
	
	public TokpedResponse<String> updateShowcase(Long shop_id, String id, String name) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.hasLength(id, "id required");
		Assert.hasLength(name, "name required");
		ObjectNode jdata = Mapper.createObjectNode();
		jdata.put("Name", name);
		jdata.put("id", id);
		byte[] json = Mapper.writeValueAsBytes(jdata);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/showcase/fs/" + fs_id + "/update?shop_id=" + shop_id)
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		return execute(String.class, request);
	}
	
	public TokpedResponse<String> deleteShowcase(Long shop_id, String id) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.hasLength(id, "id required");
		ObjectNode jdata = Mapper.createObjectNode();
		jdata.put("id", id);
		byte[] json = Mapper.writeValueAsBytes(jdata);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/showcase/fs/" + fs_id + "/delete?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(String.class, request);
	}

}
