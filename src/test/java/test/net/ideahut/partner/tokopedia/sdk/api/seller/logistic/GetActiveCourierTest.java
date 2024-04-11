package test.net.ideahut.partner.tokopedia.sdk.api.seller.logistic;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ActiveCourier;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetActiveCourierTest {

	@Test
	public void test() {
		Long shop_id = 14645432L;
		TokpedResponse<ActiveCourier> response = TestConstants.tokopedia.getSellerApi().getLogisticApi().getActiveCourier(shop_id);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
