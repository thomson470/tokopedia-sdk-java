package test.net.ideahut.partner.tokopedia.sdk.api.seller.order;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.OrderSingle;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetSingleOrderTest {

	@Test
	public void test() {
		Long order_id = 1410211885L; //1406086970L;
		String invoice_num = null; //"INV/20221109/MPL/2805621861";
		TokpedResponse<OrderSingle> response = TestConstants.tokopedia.getSellerApi().getOrderApi().getSingleOrder(order_id, invoice_num);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
