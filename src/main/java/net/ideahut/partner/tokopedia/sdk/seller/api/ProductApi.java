package net.ideahut.partner.tokopedia.sdk.seller.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductAnnotation;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductChangeResult;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductDiscussion;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductGet;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductNew;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductPriceStock;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductVariant;
import net.ideahut.partner.tokopedia.sdk.seller.object.Products;
import net.ideahut.partner.tokopedia.sdk.seller.object.UploadStatus;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class ProductApi extends Tokopedia.Api {	

	protected ProductApi(Tokopedia tokopedia) {
		super(tokopedia);
	}

	public TokpedResponse<List<ProductGet>> getProduct(Long product_id) {
		Assert.notNull(product_id, "product_id is required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/shop/fs/" + fs_id + "/shop-info?product=" + product_id);		
		return execute(new TypeReference<List<ProductGet>>() {}, request);
	}
	
	public TokpedResponse<ProductVariant> getVariant(Long cat_id) {
		Assert.notNull(cat_id, "cat_id is required");
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v2/fs/" + fs_id + "/category/get_variant?cat_id=" + cat_id);		
		return execute(ProductVariant.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> createProduct(Long shop_id, ProductNew productNew) {
		Assert.notNull(productNew, "productNew required");
		Assert.notEmpty(productNew.products, "product list required");
		byte[] json = Mapper.writeValueAsBytes(productNew);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v3/products/fs/" + fs_id + "/create?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> editProduct(Products products) {
		Assert.notNull(products, "products required");
		Assert.notEmpty(products.products, "product list required");
		byte[] json = Mapper.writeValueAsBytes(products);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v3/products/fs/" + fs_id + "/edit")
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<UploadStatus> checkUploadStatus(Long shop_id, String upload_id) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.hasLength(upload_id, "upload_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/products/fs/" + fs_id + "/status/" + upload_id + "?shop_id=" + shop_id);
		return execute(UploadStatus.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> setActiveProduct(Long shop_id, List<Long> product_ids) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(product_ids, "product_ids required");
		ArrayNode ids = Mapper.convert(ArrayNode.class, product_ids);
		ObjectNode data = Mapper.createObjectNode();
		data.putArray("product_id").addAll(ids);
		byte[] json = Mapper.writeValueAsBytes(data);		
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/products/fs/" + fs_id + "/active?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> setInActiveProduct(Long shop_id, List<Long> product_ids) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(product_ids, "product_ids required");
		ArrayNode ids = Mapper.convert(ArrayNode.class, product_ids);
		ObjectNode data = Mapper.createObjectNode();
		data.putArray("product_id").addAll(ids);
		byte[] json = Mapper.writeValueAsBytes(data);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/products/fs/" + fs_id + "/inactive?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> updatePriceOnly(Long shop_id, List<ProductPriceStock> product_prices) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(product_prices, "product_prices required");
		byte[] json = Mapper.writeValueAsBytes(product_prices);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v1/fs/" + fs_id + "/price/update?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> updateStockOnly(Long shop_id, List<ProductPriceStock> product_stocks) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(product_stocks, "product_stocks required");
		byte[] json = Mapper.writeValueAsBytes(product_stocks);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v1/fs/" + fs_id + "/stock/update?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<ProductChangeResult> deleteProduct(Long shop_id, List<Long> product_ids) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notEmpty(product_ids, "product_ids required");
		ArrayNode ids = Mapper.convert(ArrayNode.class, product_ids);
		ObjectNode data = Mapper.createObjectNode();
		data.putArray("product_id").addAll(ids);
		byte[] json = Mapper.writeValueAsBytes(data);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v3/products/fs/" + fs_id + "/delete?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(ProductChangeResult.class, request);
	}
	
	public TokpedResponse<ProductDiscussion> getProductDiscussion(TokpedInquiry inquiry, Long product_id) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.notNull(inquiry.shop_id, "shop_id required");
		Assert.notNull(product_id, "product_id required");
		Assert.notNull(inquiry.page, "page required");
		Assert.notNull(inquiry.per_page, "per_page required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/discussion/fs/" + fs_id + "/list?shop_id=" + inquiry.shop_id + "&product_id=" + product_id + "&page=" + inquiry.page + "&per_page=" + inquiry.per_page);
		return execute(ProductDiscussion.class, request);
	}
	
	public TokpedResponse<List<ProductAnnotation>> getProductAnnotation(Long cat_id) {
		Assert.notNull(cat_id, "cat_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/fs/" + fs_id + "/product/annotation?cat_id=" + cat_id);
		return execute(new TypeReference<List<ProductAnnotation>>() {}, request);
	}
	
}
