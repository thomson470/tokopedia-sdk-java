package net.ideahut.partner.tokopedia.sdk.seller.api;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Categories;

public class CategoryApi extends Tokopedia.Api {

	protected CategoryApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<Categories> getAllCategories(String keyword) {
		String query = keyword != null ? "keyword=" + keyword : "";		
		TokpedRequest request = TokpedRequest.create()
		.path("/inventory/v1/fs/" + fs_id + "/product/category?" + query);
		return execute(Categories.class, request);
	}

}
