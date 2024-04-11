package test.net.ideahut.partner.tokopedia.sdk.api.seller.order;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class AcceptOrderTest {

	@Test
	public void test() {
		Long order_id = 1411070828L;
		TokpedResponse<String> response = TestConstants.tokopedia.getSellerApi().getOrderApi().acceptOrder(order_id);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
