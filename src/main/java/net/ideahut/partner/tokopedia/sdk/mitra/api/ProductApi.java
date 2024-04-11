package net.ideahut.partner.tokopedia.sdk.mitra.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.mitra.object.ProductGetV1;
import net.ideahut.partner.tokopedia.sdk.mitra.object.ProductGetV2;
import net.ideahut.partner.tokopedia.sdk.mitra.object.ProductInputV1;
import net.ideahut.partner.tokopedia.sdk.mitra.object.StockUpdateInput;
import net.ideahut.partner.tokopedia.sdk.mitra.object.StockUpdateResult;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class ProductApi extends Tokopedia.Api {

	protected ProductApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<ProductGetV1> getProductV1(ProductInputV1 input) {
		Assert.notNull(input, "input required");
		Assert.notNull(input.shop_id, "shop_id required");
		Integer start = input.start;
		if (start == null || start < 0) {
			start = 0;
		}
		Integer rows = input.rows;
		if (rows == null || rows < 1) {
			rows = 10;
		}
		String query = "shop_id=" + input.shop_id + "&start=" + start + "&rows=" + rows;
		if (input.order_by != null) {
			query += "&order_by=" + input.order_by;
		}
		if (input.keyword != null) {
			query += "&keyword=" + input.keyword;
		}
		if (input.exclude_keyword != null) {
			query += "&exclude_keyword=" + input.exclude_keyword;
		}
		if (input.sku != null) {
			query += "&sku=" + input.sku;
		}
		if (input.price_min != null) {
			query += "&price_min=" + input.price_min;
		}
		if (input.price_max != null) {
			query += "&price_max=" + input.price_max;
		}
		if (input.preorder != null) {
			query += "&preorder=" + input.preorder;
		}
		if (input.free_return != null) {
			query += "&free_return=" + input.free_return;
		}
		if (input.wholesale != null) {
			query += "&wholesale=" + input.wholesale;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v1/fs/" + fs_id + "/product/list?" + query);
		return execute(ProductGetV1.class, request);
	}
	
	public TokpedResponse<List<ProductGetV2>> getProductV2(TokpedInquiry inquiry) {
		Integer page = 1, per_page = 10;
		Long product_id = null;
		if (inquiry != null) {
			if (inquiry.page != null && inquiry.page > 0) {
				page = inquiry.page;
			}
			if (inquiry.per_page != null && inquiry.per_page > 0) {
				per_page = inquiry.per_page;
			}
			product_id = inquiry.product_id;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/products/fs/" + fs_id + "/" + page + "/" + per_page + "?" + (product_id != null ? "product_id=" + product_id : ""));
		TokpedResponse<List<ProductGetV2>> response = execute(new TypeReference<List<ProductGetV2>>() {}, request);
		return response;
	}
	
	public TokpedResponse<StockUpdateResult> updateStock(Long shop_id, List<StockUpdateInput> inputs) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(inputs, "inputs required");
		// validasi input
		for (StockUpdateInput input : inputs) {
			Assert.notNull(input.new_stock, "new_stock required");
			Assert.isTrue(input.product_id != null || input.sku != null, "product_id/sku required");
		}
		byte[] json = Mapper.writeValueAsBytes(inputs);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v1/fs/" + fs_id + "/stock/update?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(StockUpdateResult.class, request);
	}
	
	public TokpedResponse<StockUpdateResult> incrementStock(Long shop_id, List<StockUpdateInput> inputs) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(inputs, "inputs required");
		// validasi input
		for (StockUpdateInput input : inputs) {
			Assert.notNull(input.stock_value, "stock_value required");
			Assert.isTrue(input.product_id != null || input.sku != null, "product_id/sku required");
		}
		byte[] json = Mapper.writeValueAsBytes(inputs);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v2/fs/" + fs_id + "/stock/increment?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(StockUpdateResult.class, request);
	}
	
	public TokpedResponse<StockUpdateResult> decrementStock(Long shop_id, List<StockUpdateInput> inputs) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(inputs, "inputs required");
		// validasi input
		for (StockUpdateInput input : inputs) {
			Assert.notNull(input.stock_value, "stock_value required");
			Assert.isTrue(input.product_id != null || input.sku != null, "product_id/sku required");
		}
		byte[] json = Mapper.writeValueAsBytes(inputs);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v2/fs/" + fs_id + "/stock/decrement?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(StockUpdateResult.class, request);
	}

}
