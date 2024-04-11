package test.net.ideahut.partner.tokopedia.sdk.api.seller.interaction;

import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Message;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetListMessageTest {

	@Test
	public void test() {
		Integer filter = 0;
		TokpedInquiry inquiry = new TokpedInquiry();
		inquiry.shop_id = 14645432L;
		inquiry.page = 1;
		inquiry.per_page = 10;		
		TokpedResponse<List<Message>> response = TestConstants.tokopedia.getSellerApi().getInteractionApi().getListMessage(inquiry, filter);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
