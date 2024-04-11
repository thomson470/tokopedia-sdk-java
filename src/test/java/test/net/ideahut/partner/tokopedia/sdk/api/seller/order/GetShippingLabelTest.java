package test.net.ideahut.partner.tokopedia.sdk.api.seller.order;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetShippingLabelTest {

	@Test
	public void test() {
		Long order_id = 1406086970L;
		TokpedResponse<String> response = TestConstants.tokopedia.getSellerApi().getOrderApi().getShippingLabel(order_id, true);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
