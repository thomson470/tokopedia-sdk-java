package net.ideahut.partner.tokopedia.sdk.seller.api;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.SlashPriceCancel;
import net.ideahut.partner.tokopedia.sdk.seller.object.SlashPriceInput;
import net.ideahut.partner.tokopedia.sdk.seller.object.SlashPriceStatus;
import net.ideahut.partner.tokopedia.sdk.seller.object.ViewCampaignProducts;
import net.ideahut.partner.tokopedia.sdk.seller.object.ViewSlashPrice;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class CampaignApi extends Tokopedia.Api {

	private static final List<String> STATUS = Arrays.asList("SCHEDULED", "ONGOING", "PAUSED");
	
	protected CampaignApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<List<ViewSlashPrice>> viewSlashPrice(TokpedInquiry inquiry) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.isTrue(inquiry.shop_id != null || inquiry.warehouse_id != null || inquiry.product_id != null, "shop_id/warehouse_id/product_id  required");
		Integer page = inquiry.page;
		if (page == null) {
			page = 1;
		}
		Integer per_page = inquiry.per_page;
		if (per_page == null) {
			per_page = 10;
		}
		String query = "page=" + page + "&per_page=" + per_page;
		if (inquiry.shop_id != null) {
			query += "&shop_id=" + inquiry.shop_id;
		}
		if (inquiry.warehouse_id != null) {
			query += "&warehouse_id=" + inquiry.warehouse_id;
		}
		if (inquiry.product_id != null) {
			query += "&product_id=" + inquiry.product_id;
		}		
		if (inquiry.status != null && STATUS.contains(inquiry.status)) {
			query += "&status=" + inquiry.status;
		}		
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/slash-price/fs/" + fs_id + "/view?" + query);
		return execute(new TypeReference<List<ViewSlashPrice>>() {}, request);
	}
	
	public TokpedResponse<ViewCampaignProducts> viewCampaignProducts(Long shop_id, Long product_id) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notNull(product_id, "product_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/campaign/fs/" + fs_id + "/view?product_id="+ product_id +"&shop_id=" + shop_id);
		return execute(ViewCampaignProducts.class, request);
	}
	
	public TokpedResponse<SlashPriceStatus> addSlashPrice(Long shop_id, List<SlashPriceInput> slashPriceInputs) {		
		Assert.notNull(shop_id, "shop_id required");
		byte[] json = Mapper.writeValueAsBytes(slashPriceInputs);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/slash-price/fs/" + fs_id + "/add?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(SlashPriceStatus.class, request);
	}
	
	public TokpedResponse<SlashPriceStatus> updateSlashPrice(Long shop_id, List<SlashPriceInput> slashPriceInputs) {		
		Assert.notNull(shop_id, "shop_id required");
		byte[] json = Mapper.writeValueAsBytes(slashPriceInputs);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/slash-price/fs/" + fs_id + "/update?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(SlashPriceStatus.class, request);
	}
	
	public TokpedResponse<SlashPriceStatus> cancelSlashPrice(Long shop_id, List<SlashPriceCancel> slashPriceCancels) {
		Assert.notNull(shop_id, "shop_id required");
		byte[] json = Mapper.writeValueAsBytes(slashPriceCancels);
		RequestBody body = RequestBody.create(json, JSON);	
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/slash-price/fs/" + fs_id + "/cancel?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(SlashPriceStatus.class, request);
	}

}
