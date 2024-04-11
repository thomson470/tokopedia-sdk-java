package net.ideahut.partner.tokopedia.sdk.seller.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.SaldoHistory;
import net.ideahut.partner.tokopedia.sdk.util.Assert;

public class FinanceApi extends Tokopedia.Api {

	protected FinanceApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<List<SaldoHistory>> getSaldoHistory(TokpedInquiry inquiry, Boolean export) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.notNull(inquiry.shop_id, "shop_id required");
		Assert.hasLength(inquiry.from_date, "from_date required");
		Assert.hasLength(inquiry.to_date, "to_date required");
		Integer page = inquiry.page;
		if (page == null) {
			page = 1;
		}
		Integer per_page = inquiry.per_page;
		if (per_page == null) {
			per_page = 10;
		}
		boolean isExport = Boolean.TRUE.equals(export);
		String query = 
		"from_date=" + inquiry.from_date +
		"&to_date=" + inquiry.to_date + 
		"&page=" + page + 
		"&per_page=" + per_page +
		"&export=" + (isExport ? 1 : 0);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/fs/" + fs_id + "/shop/" + inquiry.shop_id + "/saldo-history?" + query);
		return execute(new TypeReference<List<SaldoHistory>>() {}, request);		
	}

}
