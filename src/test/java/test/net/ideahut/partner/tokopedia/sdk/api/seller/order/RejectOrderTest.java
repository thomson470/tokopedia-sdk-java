package test.net.ideahut.partner.tokopedia.sdk.api.seller.order;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.OrderReject;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class RejectOrderTest {

	@Test
	public void test() {
		Long order_id = 1411070828L;
		OrderReject order_reject = new OrderReject();
		order_reject.reason_code = 5;
		order_reject.reason = "Maaf tidak ada pegawai di lokasi";
		TokpedResponse<String> response = TestConstants.tokopedia.getSellerApi().getOrderApi().rejectOrder(order_id, order_reject);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
