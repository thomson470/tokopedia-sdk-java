package net.ideahut.partner.tokopedia.sdk.seller.api;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ActiveCourier;
import net.ideahut.partner.tokopedia.sdk.seller.object.ShipmentInfo;
import net.ideahut.partner.tokopedia.sdk.util.Assert;

public class LogisticApi extends Tokopedia.Api {

	protected LogisticApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<ActiveCourier> getActiveCourier(Long shop_id) {
		Assert.notNull(shop_id, "shop_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/logistic/fs/" + fs_id + "/active-info?shop_id=" + shop_id);
		return execute(ActiveCourier.class, request);
	}
	
	public TokpedResponse<ShipmentInfo> getShipmentInfo(Long shop_id) {
		Assert.notNull(shop_id, "shop_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v2/logistic/fs/" + fs_id + "/info?shop_id=" + shop_id);
		return execute(ShipmentInfo.class, request);
	}

}
