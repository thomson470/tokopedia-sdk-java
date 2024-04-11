package net.ideahut.partner.tokopedia.sdk.seller.api;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.BundleCreate;
import net.ideahut.partner.tokopedia.sdk.seller.object.BundleIds;
import net.ideahut.partner.tokopedia.sdk.seller.object.BundleInfoInput;
import net.ideahut.partner.tokopedia.sdk.seller.object.BundleInfoList;
import net.ideahut.partner.tokopedia.sdk.seller.object.BundleInfoSingle;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class BundleApi extends Tokopedia.Api {

	protected BundleApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<BundleIds> createBundle(Long shop_id, BundleCreate bundleCreate) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.notNull(bundleCreate, "bundleCreate required");
		byte[] json = Mapper.writeValueAsBytes(bundleCreate);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/products/bundle/fs/" + fs_id + "/create?shop_id=" + shop_id)
		.method(TokpedRequest.Method.POST)
		.body(body);
		return execute(BundleIds.class, request);
	}
	
	public TokpedResponse<String> cancelBundle(Long shop_id, Long bundle_id) {		
		Assert.notNull(shop_id, "shop_id required");
		Assert.notNull(bundle_id, "bundle_id required");
		ObjectNode jnode = Mapper.createObjectNode();
		jnode.putObject("bundle").put("bundle_id", bundle_id);
		byte[] json = Mapper.writeValueAsBytes(jnode);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/products/bundle/fs/" + fs_id + "/edit?shop_id=" + shop_id)
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		return execute(String.class, request);
	}
	
	public TokpedResponse<BundleInfoSingle> getBundleInfo(Long shop_id, Long bundle_id, Long product_id) {		
		Assert.notNull(shop_id, "shop_id required");
		Assert.isTrue(bundle_id != null || product_id != null, "bundle_id/product_id required");
		String query = "shop_id=" + shop_id;
		if (bundle_id != null) {
			query += "&bundle_id=" + bundle_id;
		} else if (product_id != null) {
			query += "&product_id=" + product_id;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/products/bundle/fs/" + fs_id + "/info?" + query);
		return execute(BundleInfoSingle.class, request);
	}
	
	public TokpedResponse<BundleInfoList> getBundleList(BundleInfoInput bundleInfoInput) {
		Assert.notNull(bundleInfoInput, "bundleInfoInput required");
		String query = "";
		if (bundleInfoInput.shop_id != null) {
			query += "shop_id=" + bundleInfoInput.shop_id;
		} else if (bundleInfoInput.product_id != null) {
			query += "product_id=" + bundleInfoInput.product_id;
		} else {
			throw new IllegalArgumentException("shop_id/product_id required");
		}
		if (bundleInfoInput.type != null) {
			query += "&type=" + bundleInfoInput.type;
		}
		if (bundleInfoInput.status != null) {
			query += "&status=" + bundleInfoInput.status;
		}
		if (bundleInfoInput.last_group_id != null) {
			query += "&last_group_id=" + bundleInfoInput.last_group_id;
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/products/bundle/fs/" + fs_id + "/list?" + query);
		return execute(BundleInfoList.class, request);
	}

}
