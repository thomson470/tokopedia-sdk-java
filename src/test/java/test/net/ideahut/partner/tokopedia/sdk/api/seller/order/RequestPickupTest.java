package test.net.ideahut.partner.tokopedia.sdk.api.seller.order;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.RequestPickup;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class RequestPickupTest {

	@Test
	public void test() {
		Long order_id = 1410211885L;
		Long shop_id = 14645432L;
		TokpedResponse<RequestPickup> response = TestConstants.tokopedia.getSellerApi().getOrderApi().requestPickup(order_id, shop_id);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
