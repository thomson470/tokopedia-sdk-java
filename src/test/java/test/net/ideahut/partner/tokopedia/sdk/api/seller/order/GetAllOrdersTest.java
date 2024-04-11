package test.net.ideahut.partner.tokopedia.sdk.api.seller.order;

import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Order;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetAllOrdersTest {

	@Test
	public void test() {
		TokpedInquiry inquiry = new TokpedInquiry();
		//inquiry.shop_id = 14645432L;
		inquiry.from_date = "1667952000";
		inquiry.to_date = "1668038399";
		//inquiry.status = "100";
		TokpedResponse<List<Order>> response = TestConstants.tokopedia.getSellerApi().getOrderApi().getAllOrders(inquiry);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
